/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.controller;

import agendams.model.dao.ContatoDao;
import agendams.model.dao.UsuarioDao;
import agendams.model.entity.Contato;
import agendams.model.service.ContatoService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ContatosController", urlPatterns = {"/Contatos"})
public class ContatosController extends HttpServlet {

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
                
            ContatoService contatoService = new ContatoService();
            ContatoDao contatoDao = new ContatoDao();
            UsuarioDao usuarioDao = new UsuarioDao();
            List<Contato> contatos = new ArrayList<Contato>();
            contatos = contatoDao.consultar(usuarioDao.consultar(loginAtivo).getIdUsuario());
            if("".equals(contatoDao.getMensagemSQLErro())){
                for(int i = 0; i < contatos.size();i++){  // formata os valores com a mascara.
                    Contato contato = new Contato();
                    contato = contatos.get(i);
                    contato.setCpf(contatoService.mascaraCpf(contato.getCpf()));
                    contato.setTelefone(contatoService.mascaraTelefone(contato.getTelefone()));
                    contato.setCelular(contatoService.mascaraCelular(contato.getCelular()));
                    contatos.set(i, contato);
                }
                request.setAttribute("lista", contatos);
                RequestDispatcher dispatcher = request.getRequestDispatcher("contatos.jsp");
                dispatcher.forward(request, response);
            }
            else{
                this.mensagemErro(request, response, contatoDao.getMensagemSQLErro());
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
      
        request.setAttribute("mensagemTitulo", "Erro no Cadastro");
        request.setAttribute("mensagemErro", mensagemDoErro);
        request.setAttribute("pagina", "Start");
        RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
        dispatcher.forward(request, response);
        
    }

}
