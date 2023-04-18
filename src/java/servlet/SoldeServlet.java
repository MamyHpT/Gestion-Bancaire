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
import model.GestionCompte;

/**
 *
 * @author Mamy Hp
 */
public class SoldeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pseudo = (String) session.getAttribute("pseudo");
        if (pseudo == null) {
            response.sendRedirect("Login");
        } else {
            request.setAttribute("pseudo", pseudo);
            this.getServletContext().getRequestDispatcher("/WEB-INF/pages/solde.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            GestionCompte gc = new GestionCompte();
            if (request.getParameter("identifiant").isBlank() || request.getParameter("password").isBlank()) {
                out.print("""
                            <div class="card-body">
                                <h5 class="card-title h2 text-center text-warning">
                                    <i class="fas fa-exclamation-triangle"></i> ERREUR DE SAISIE
                                </h5>
                                <p class="card-text text-center mt-5 h5 alert alert-danger">
                                    VEUILLEZ VERIFIER LES CHAMPS DE SAISIE !
                                </p>
                            </div>
                            <div class="card-footer mt-5 text-end">
                                
                            </div>
                """);
            } else {
                String identifiant = request.getParameter("identifiant"), password = request.getParameter("password");
                if (gc.verifierCompte(identifiant) != 0 || gc.verifierCompteNom(identifiant) != 0) {
                    if (gc.verifierCompte(identifiant, password) != 0) {
                        Compte compte = gc.select(identifiant);
                        out.print("<div class=\"card-body\">\n"
                                + "                                <h5 class=\"card-title h2 text-center text-info\">\n"
                                + "                                    <i class=\"fas fa-address-card\"></i> CARD ID : " + compte.getNum_compte() + "\n"
                                + "                                </h5>\n"
                                + "                                <p class=\"card-text text-center mt-5 h5\">\n"
                                + "                                    Le solde de votre compte est de : " + compte.getSolde() + " Ariary.\n"
                                + "                                </p>\n"
                                + "                            </div>\n"
                                + "                            <div class=\"card-footer mt-5 text-end\">\n"
                                + "                                <span class=\"h6 mark rounded p-2\" style=\"color: rgb(20, 8, 73);\">Nom : " + compte.getNom_et_prenoms() + "<span>\n"
                                + "                            </div>");
                    } else {
                        out.print("""
                            <div class="card-body">
                                <h5 class="card-title h2 text-center text-danger">
                                    <i class="fas fa-exclamation-circle"></i> MOT DE PASSE INCORRECT
                                </h5>
                                <p class="card-text text-center mt-5 h5 alert alert-danger">
                                    VEUILLEZ VERIFIER VOTRE MOT DE PASSE !
                                </p>
                            </div>
                            <div class="card-footer mt-5 text-end">
                                
                            </div>
                        """);
                    }

                } else {
                    out.print("""
                        <div class="card-body">
                            <h5 class="card-title h2 text-center text-danger">
                                <i class="fas fa-exclamation-circle"></i> COMPTE INTROUVABLE
                            </h5>
                            <p class="card-text text-center mt-5 h5 alert alert-danger">
                                VEUILLEZ VERIFIER L'IDENTIFIANT DE VOTRE COMPTE !
                            </p>
                        </div>
                        <div class="card-footer mt-5 text-end">

                        </div>
                    """);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VersementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
