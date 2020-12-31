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
@WebServlet(name = "ContaController", urlPatterns = {"/Conta"})
public class ContaController extends HttpServlet {

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
        
        String loginAtivo = (String) request.getSession().getAttribute("loginAtivo");
        if (loginAtivo != null) {
        
            String operacao = request.getParameter("Operacao");
            
            if(operacao != null){
                if(operacao.equals("AlterarNome")){

                    String nome = request.getParameter("Nome");
                    String login = request.getParameter("Login");
                    
                    UsuarioDao usuarioDao  = new UsuarioDao();
                    Usuario usuario = new Usuario();
                    usuario = usuarioDao.consultar(loginAtivo);
                    usuario.setNome(nome);
                    usuario.setLogin(login);
                    usuarioDao.alterar(usuario);
                    response.sendRedirect("Sair");
                    
                }
                else if(operacao.equals("AlterarSenha")){

                    String senhaAtual = request.getParameter("SenhaAtual");
                    String novaSenha = request.getParameter("NovaSenha");
                    String confirmaSenha = request.getParameter("ConfirmaSenha");
                    
                    UsuarioService usuarioService = new UsuarioService();
                    
                    if(usuarioService.comparaSenha(novaSenha, confirmaSenha)){
                    
                        UsuarioDao usuarioDao  = new UsuarioDao();
                        Usuario usuario = new Usuario();
                        usuario = usuarioDao.consultar(loginAtivo);
                        if(usuario.getSenha().equals(usuarioService.hashSHA512(senhaAtual))){
                            usuario.setSenha(usuarioService.hashSHA512(novaSenha));
                            usuarioDao.alterar(usuario);
                            response.sendRedirect("Sair");
                        }
                        else{
                            this.mensagemErro(request, response, "Senha inválida!");
                        }
                        
                    }
                    else{
                        this.mensagemErro(request, response, "A senha não confere!");
                    }
                    
                }
                else if(operacao.equals("ExcluirConta")){

                    UsuarioDao usuarioDao  = new UsuarioDao();
                    usuarioDao.excluir(usuarioDao.consultar(loginAtivo));
                    response.sendRedirect("Sair");

                }
            }
            else{
                
                UsuarioDao usuarioDao  = new UsuarioDao();
                Usuario usuario = new Usuario();
                usuario = usuarioDao.consultar(loginAtivo);
                
                request.setAttribute("Nome", usuario.getNome());
                request.setAttribute("Login", usuario.getLogin());
                RequestDispatcher dispatcher = request.getRequestDispatcher("conta.jsp");
                dispatcher.forward(request, response);
                
            }
        }
        else{
            response.sendRedirect("Start");
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
      
        request.setAttribute("mensagemTitulo", "Erro na Alteração");
        request.setAttribute("mensagemErro", mensagemDoErro);
        request.setAttribute("pagina", "Conta");
        RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
        dispatcher.forward(request, response);
        
    }
    
    
}
