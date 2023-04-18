/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import model.GestionAdmin;

/**
 *
 * @author Mamy Hp
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            GestionAdmin ga = new GestionAdmin();
            PrintWriter out = response.getWriter();
            String action = request.getParameter("action");
            switch (action) {
                case "login" -> {
                    String pseudo = request.getParameter("pseudo"), password = request.getParameter("password");
                    if (ga.verifierAdmin(pseudo) != 0) {
                        if (ga.login(pseudo, password) != 0) {
                            HttpSession session = request.getSession();
                            session.setAttribute("pseudo", pseudo);
                            out.print("Logged");
                        } else {
                            out.print("not logged");
                        }
                    }else{
                        out.print("pseudo error");
                    }
                }
                case "create" -> {
                    String nom_et_prenoms = request.getParameter("nom_et_prenoms"), pseudo = request.getParameter("pseudo"), mail = request.getParameter("mail"), password = request.getParameter("password"), approbation = request.getParameter("approbation");
                    if(ga.verifyPass(approbation) != 0){
                        ga.insert(nom_et_prenoms, pseudo, mail, password);
                        out.print("ok");
                    }else{
                        out.print("non approuver");
                    }
                }
                case "change" -> {
                    String nom = request.getParameter("nom_et_prenoms"), mail = request.getParameter("mail"), password = request.getParameter("password");
                    if(ga.verifierCompte(nom, mail) != 0){
                        ga.changePassword(nom, password);
                        out.print("ok");
                    }else{
                        out.print("incorrect");
                    }
                }
                default ->
                    throw new AssertionError();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
