/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.controller;

import agendams.model.dao.ContaDao;
import agendams.model.dao.UsuarioDao;
import agendams.model.entity.Usuario;
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
@WebServlet(name = "AdmController", urlPatterns = {"/Adm"})
public class AdmController extends HttpServlet {

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

            List<List<String>> usuariosLista = new ArrayList<List<String>>();
            UsuarioDao usuarioDao = new UsuarioDao();
            ContaDao contaDao = new ContaDao();
            List<Usuario> usuarios = usuarioDao.consultar();
            
            usuarios.forEach((u) ->{
                List<String> usuarioItem = new ArrayList<String>();
                usuarioItem.add(0, String.valueOf(u.getIdUsuario()));
                usuarioItem.add(1, u.getNome());
                usuarioItem.add(2, u.getLogin());
                usuarioItem.add(3, contaDao.consultar(u.getIdConta()).getTipoConta());
                usuariosLista.add(usuarioItem);
            });
      
            request.setAttribute("lista", usuariosLista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("adm.jsp");
            dispatcher.forward(request, response);
        
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
