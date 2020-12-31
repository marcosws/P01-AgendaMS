/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.controller;

import agendams.model.dao.ContaDao;
import agendams.model.dao.ContatoDao;
import agendams.model.dao.UsuarioDao;
import agendams.model.entity.Usuario;
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
@WebServlet(name = "AdmExcluirController", urlPatterns = {"/AdmExcluir"})
public class AdmExcluirController extends HttpServlet {

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
        String contaAtiva = (String) request.getSession().getAttribute("contaAtiva");
        if (loginAtivo != null && contaAtiva.equals("Administrativa")) {
        
            String idUsuario = request.getParameter("idUsuario");
            String Login = request.getParameter("Login");
            
            if(Login == null){
                
                UsuarioDao usuarioDao = new UsuarioDao();
                ContaDao contaDao = new ContaDao();
                ContatoDao contatoDao = new ContatoDao();
                Usuario usuario = new Usuario();
                usuario = usuarioDao.consultar(Integer.parseInt(idUsuario));

                request.setAttribute("idUsuario", idUsuario);
                request.setAttribute("Nome", usuario.getNome());
                request.setAttribute("Login", usuario.getLogin());
                request.setAttribute("tipoConta", contaDao.consultar(usuario.getIdConta()).getTipoConta());
                request.setAttribute("totalContatos", contatoDao.getTotal(Integer.parseInt(idUsuario)));
                RequestDispatcher dispatcher = request.getRequestDispatcher("adm-excluir.jsp");
                dispatcher.forward(request, response);
            
            }
            else{
                
                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(Integer.parseInt(idUsuario));
                usuarioDao.excluir(usuario);
                response.sendRedirect("Adm");
                
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

}
