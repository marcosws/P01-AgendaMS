/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendams.controller;

import agendams.model.dao.ContaDao;
import agendams.model.dao.UsuarioDao;
import agendams.model.entity.Conta;
import agendams.model.entity.Usuario;
import agendams.model.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "StartController", urlPatterns = {"/Start"})
public class StartController extends HttpServlet {

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
        
        String login = request.getParameter("Login");
        String senha = request.getParameter("Senha");
        
        if(usuarioService.isNullOrEmpty(login) && usuarioService.isNullOrEmpty(senha)){
            String loginAtivo = (String) request.getSession().getAttribute("loginAtivo");
            if(loginAtivo == null){
                response.sendRedirect("start.jsp"); 
            }
            else{
                response.sendRedirect("Home");
            }
        }
        else{
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = new Usuario();
            usuario = usuarioDao.consultar(login);
            
            
            
            if(usuario != null){
                if(usuario.getSenha().equals(usuarioService.hashSHA512(senha))){
                    
                    ContaDao contaDao = new ContaDao();
                    Conta conta = new Conta();
                    conta = contaDao.consultar(usuario.getIdConta());
                    request.getSession().setAttribute("loginAtivo", login);
                    request.getSession().setAttribute("contaAtiva", conta.getTipoConta());
                    response.sendRedirect("Home");
                }
                else{
                    this.mensagemErro(request, response, "Senha inválida!");
                }
            }
            else{
                this.mensagemErro(request, response, "Usuário inesistente!");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
