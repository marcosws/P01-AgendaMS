/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.controller;

import agendams.model.dao.ContatoDao;
import agendams.model.entity.Contato;
import agendams.model.service.ContatoService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "IncluirController", urlPatterns = {"/Incluir"})
public class IncluirController extends HttpServlet {

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
        
        String nome = request.getParameter("Nome");
        String cpf = request.getParameter("Cpf");
        String telefone = request.getParameter("Telefone");
        String celular = request.getParameter("Celular");
        String email = request.getParameter("Email");
        String site = request.getParameter("Site");
        
        if((nome == null && cpf == null) 
        && (telefone == null && celular == null)
        && (email == null && site == null)){
            response.sendRedirect("incluir.jsp");
        } 
        else{
            
            ContatoService contatoService = new ContatoService();
            ContatoDao contatoDao = new ContatoDao();
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setCpf(contatoService.removeMascara(cpf));
            contato.setTelefone(contatoService.removeMascara(telefone));
            contato.setCelular(contatoService.removeMascara(celular));
            contato.setEmail(email);
            contato.setSite(site);
            contatoDao.incluir(contato);
            if(contatoDao.getMensagemSQLErro().equals("")){
                response.sendRedirect("Contatos");
            }
            else{
                this.mensagemErro(request, response, contatoDao.getMensagemSQLErro());
            }
            
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
      
        request.setAttribute("mensagemTitulo", "Erro de Acesso");
        request.setAttribute("mensagemErro", mensagemDoErro);
        request.setAttribute("pagina", "Start");
        RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
        dispatcher.forward(request, response);
        
    }

}
