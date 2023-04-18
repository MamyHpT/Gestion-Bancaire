/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import beans.Compte;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GestionAdmin;
import model.GestionCompte;

/**
 *
 * @author Mamy Hp
 */
public class InfoCompteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String pseudo = (String) session.getAttribute("pseudo");
            if (pseudo == null) {
                response.sendRedirect("Login");
            } else {
                String num_compte = request.getParameter("num_compte");
                GestionCompte gc = new GestionCompte();
                Compte compte = gc.select(num_compte);
                request.setAttribute("compte", compte);
                request.setAttribute("pseudo", pseudo);
                this.getServletContext().getRequestDispatcher("/WEB-INF/pages/info-compte.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            response.sendRedirect("Compte");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            GestionCompte gc = new GestionCompte();
            GestionAdmin ga = new GestionAdmin();
            String action = request.getParameter("action"), num_compte = request.getParameter("num_compte"), password = request.getParameter("password");
            switch (action) {
                case "suppression" -> {
                    if (gc.verifierCompte(num_compte, password) != 0 || ga.verifyPass(password) != 0) {
                        gc.delete(num_compte);
                        out.print("suppression reussi");
                    } else {
                        out.print("incorrect");
                    }
                }
                case "affichage" -> {
                    if (gc.verifierCompte(num_compte, password) != 0 || ga.verifyPass(password) != 0) {
                        out.print("ok");
                    } else {
                        out.print("incorrect");
                    }
                }
                case "modification" -> {
                    String nom_et_prenoms = request.getParameter("nom_et_prenoms"), num_cin = request.getParameter("num_cin"), num_phone = request.getParameter("num_phone"), sexe = request.getParameter("sexe"), adresse = request.getParameter("adresse"), email = request.getParameter("email");
                    Compte compte = new Compte(num_compte, nom_et_prenoms, "", num_cin, num_phone, sexe, adresse, email);
                    gc.updateAll(compte);
                    compte = new GestionCompte().select(num_compte);
                    nom_et_prenoms = compte.getNom_et_prenoms();
                    num_cin = compte.getNum_cin();
                    num_phone = compte.getNum_phone();
                    sexe = compte.getSexe();
                    adresse = compte.getAdresse();
                    email = compte.getEmail();
                    out.print(nom_et_prenoms + "=>" + num_cin + "=>" + num_phone + "=>" + sexe + "=>" + adresse + "=>" + email);
                }
                case "password" -> {
                    String ancien_password = request.getParameter("ancien_pass"), new_password = request.getParameter("new_pass");
                    if (gc.verifierCompte(num_compte, ancien_password) != 0) {
                        gc.changePassword(num_compte, new_password);
                        out.print(new_password);
                    } else {
                        out.print("Incorrect");
                    }
                }
                default ->
                    throw new AssertionError();
            }
        } catch (Exception ex) {
            Logger.getLogger(InfoCompteServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

}
