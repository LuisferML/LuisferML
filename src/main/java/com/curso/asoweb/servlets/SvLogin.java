/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.curso.asoweb.servlets;

import com.curso.asoweb.logica.Controladora;
import com.curso.asoweb.logica.RolesUsuarios;
import com.curso.asoweb.logica.Usuarios;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author luis_
 */
@WebServlet("/Svlogin")
public class SvLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SvLogin</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SvLogin at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
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
//        processRequest(request, response);

        String email = null;
        String password = null;
        email = request.getParameter("emailusuario");
        password = request.getParameter("usuariopassword");
        String mensajeError = null;

        if (!(email == null) && !(password == null)) {

            Controladora control = new Controladora();
            Usuarios us = new Usuarios();
            RolesUsuarios rolUs = new RolesUsuarios();
            us = control.CtrConsultaUsuarioXEmail(email);
            String passwordBD = us.getClave();
            String emailBD = us.getEmail();
            rolUs = control.CtrConsultaRolesByUs(us);

            if (emailBD.equals(email) && passwordBD.equals(password)) {

                try {
                    HttpSession sesionHttp = request.getSession();
                    sesionHttp.setAttribute("emailUsuario", email);
                    sesionHttp.setAttribute("nombreUsuario", us.getUsuario());
                    String creaSocio = null;
                    if (us.getCreaSocio()) {
                        creaSocio = "true";
                    } else {
                        creaSocio = "false";
                    }
                    String rolBaja = null;
                    if (rolUs.getRolBaja()) {
                        rolBaja = "true";
                    } else {
                        rolBaja = "false";
                    }

                    sesionHttp.setAttribute("creaSocio", creaSocio);
                    sesionHttp.setAttribute("usuarioId", us.getId());
                    sesionHttp.setAttribute("rolBaja", rolBaja);

                    request.getRequestDispatcher("mainUsuario.jsp").forward(request, response);

                } catch (Exception e) {
                    e.printStackTrace();
                    mensajeError = "Se produjo un error inesperado al intentar iniciar sesión";
                    HttpSession sesionHttp = request.getSession();
                    sesionHttp.setAttribute("mensajeErrorLogin", mensajeError);
                    request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
                }

            } else {

                mensajeError = "Los datos no corresponden con los de Usuarios Registrados";
                HttpSession sesionHttp = request.getSession();
                sesionHttp.setAttribute("mensajeErrorLogin", mensajeError);
                request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
            }

        } else {
            mensajeError = "Se deben llenar todos los campos";
            HttpSession sesionHttp = request.getSession();
            sesionHttp.setAttribute("mensajeErrorLogin", mensajeError);
            request.getRequestDispatcher("errorLogin.jsp").forward(request, response);

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
// </editor-fold>
}
