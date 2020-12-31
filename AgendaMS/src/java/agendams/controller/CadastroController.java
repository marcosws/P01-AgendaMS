/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.controller;

import agendams.model.dao.UsuarioDao;
import agendams.model.entity.Usuario;
import agendams.model.service.UsuarioService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "CadastroController", urlPatterns = {"/Cadastro"})
public class CadastroController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        UsuarioService usuarioService = new UsuarioService();
        
        String nome = request.getParameter("Nome");
        String login = request.getParameter("Login");
        String senha = request.getParameter("Senha");
        String confirmaSenha = request.getParameter("ConfirmaSenha");

        if((nome != null && login != null) && (senha != null && confirmaSenha != null)){
            
            if(usuarioService.verificaSeVazio(nome)){
                this.mensagemErro(request, response, "Nome de usuário é Obrigatório!");
            }
            else if(usuarioService.verificaSeVazio(login)){
                this.mensagemErro(request, response, "Login de usuário é Obrigatório!");
            }
            else if(usuarioService.verificaSeVazio(senha)){
                this.mensagemErro(request, response, "Senha de usuário é Obrigatório!");
            }
            else if(!usuarioService.comparaSenha(senha, confirmaSenha)){
                this.mensagemErro(request, response,  "Senha não Confere!");
            }
            else{
                
                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = new Usuario();
                usuario.setIdConta(1);
                usuario.setNome(nome);
                usuario.setLogin(login);
                usuario.setSenha(usuarioService.hashSHA512(senha));
                usuarioDao.incluir(usuario);
                
                if("".equals(usuarioDao.getMensagemSQLErro())){
                    this.mensagemStatus(request, response, "Cadastro realizado com Sucesso!");
                }
                else{
                    this.mensagemErro(request, response, usuarioDao.getMensagemSQLErro());
                } 
            }
        }
        else{
            response.sendRedirect("cadastro.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void mensagemErro(HttpServletRequest request, HttpServletResponse response, String mensagemDoErro) throws ServletException, IOException{
      
        request.setAttribute("mensagemTitulo", "Erro no Cadastro");
        request.setAttribute("mensagemErro", mensagemDoErro);
        request.setAttribute("pagina", "Cadastro");
        RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
        dispatcher.forward(request, response);
        
    }
    
    private void mensagemStatus(HttpServletRequest request, HttpServletResponse response, String mensagemOk) throws ServletException, IOException{
        
        request.setAttribute("mensagemTitulo", "Cadastro");
        request.setAttribute("mensagemStatus", mensagemOk);
        request.setAttribute("pagina", "Start");
        RequestDispatcher dispatcher = request.getRequestDispatcher("mensagem.jsp");
        dispatcher.forward(request, response);
        
    }
    
}
