/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import beans.Retrait;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GestionCompte;
import model.GestionRetrait;

/**
 *
 * @author Mamy Hp
 */
public class RetraitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String pseudo = (String) session.getAttribute("pseudo");
            if (pseudo == null) {
                response.sendRedirect("Login");
            } else {
                GestionRetrait gr = new GestionRetrait();
                List<Retrait> retrait = gr.selectAll();
                request.setAttribute("retraits", retrait);
                request.setAttribute("pseudo", pseudo);
                this.getServletContext().getRequestDispatcher("/WEB-INF/pages/retrait.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            GestionCompte gc = new GestionCompte();
            if (request.getParameter("num_compte").isBlank() || request.getParameter("montant").isBlank() || request.getParameter("password").isBlank() || request.getParameter("num_cheque").length() != 6) {
                if (request.getParameter("num_cheque").length() != 6 && request.getParameter("num_cheque").length() != 0) {
                    out.print("<div class=\"modal-header\" autre>\n"
                            + "                            <h5 class=\"modal-title text-danger\" id=\"staticBackdropLabel\">\n"
                            + "                                <i class=\"fas fa-exclamation-circle\"></i> ERREUR DE SAISIE</h5>\n"
                            + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"modal-body\">\n"
                            + "                            <h5 class=\"alert alert-danger\" style=\"color: rgb(20, 8, 73);\">\n"
                            + "                                * NUMERO DU CHEQUE INCORRECT ! (6 caractères) *\n"
                            + "                            </h5>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"modal-footer\">\n"
                            + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                            + "                        </div>");
                } else {
                    out.print("<div class=\"modal-header\" autre>\n"
                            + "                            <h5 class=\"modal-title text-danger\" id=\"staticBackdropLabel\">\n"
                            + "                                <i class=\"fas fa-exclamation-circle\"></i> ERREUR DE SAISIE</h5>\n"
                            + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"modal-body\">\n"
                            + "                            <h5 class=\"alert alert-danger\" style=\"color: rgb(20, 8, 73);\">\n"
                            + "                                * TOUS LES CHAMPS SONT OBLIGATOIRE ! *\n"
                            + "                            </h5>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"modal-footer\">\n"
                            + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                            + "                        </div>");
                }

            } else {
                String num_compte = request.getParameter("num_compte").toUpperCase(), password = request.getParameter("password"), nom_et_prenoms;
                float montant = Float.parseFloat(request.getParameter("montant"));
                int num_cheque = Integer.parseInt(request.getParameter("num_cheque"));
                if (Float.parseFloat(request.getParameter("montant")) < 1000) {
                    out.print("<div class=\"modal-header\" autre>\n"
                            + "                            <h5 class=\"modal-title text-warning\" id=\"staticBackdropLabel\">\n"
                            + "                                <i class=\"fas fa-exclamation-triangle\"></i> ERREUR MONTANT</h5>\n"
                            + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"modal-body\">\n"
                            + "                            <h5 class=\"alert alert-warning\" style=\"color: rgb(20, 8, 73);\">\n"
                            + "                                * LE RETRAIT MINIMUM EST DE 1000 Ar ! *\n"
                            + "                            </h5>\n"
                            + "                        </div>\n"
                            + "                        <div class=\"modal-footer\">\n"
                            + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                            + "                        </div>");
                } else {
                    if (request.getParameter("action").equals("verification")) {
                        if (gc.verifierCompte(num_compte) != 0) {
                            if (gc.verifierCompte(num_compte, password) != 0) {
                                if (gc.getSolde(num_compte) < montant) {
                                    out.print("<div class=\"modal-header\" autre>\n"
                                            + "                            <h5 class=\"modal-title text-warning\" id=\"staticBackdropLabel\">\n"
                                            + "                                <i class=\"fas fa-exclamation-triangle\"></i> SOLDE INSUFFISANT</h5>\n"
                                            + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                            + "                        </div>\n"
                                            + "                        <div class=\"modal-body\">\n"
                                            + "                            <h5 class=\"alert alert-warning\" style=\"color: rgb(20, 8, 73);\">\n"
                                            + "                                * VOTRE SOLDE EST INSUFFISANT ! *<br>Vous avez : " + gc.getSolde(num_compte) + " Ariary dans votre compte.\n"
                                            + "                            </h5>\n"
                                            + "                        </div>\n"
                                            + "                        <div class=\"modal-footer\">\n"
                                            + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                                            + "                        </div>");
                                } else {
                                    nom_et_prenoms = gc.selectOne(num_compte);
                                    out.print("<div class=\"modal-header\" autre>\n"
                                            + "                            <h5 class=\"modal-title text-info\" id=\"staticBackdropLabel\">\n"
                                            + "                                <i class=\"fas fa-exclamation-triangle\"></i> CONFIRMATION DU RETRAIT\n"
                                            + "                            </h5>\n"
                                            + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                            + "                        </div>\n"
                                            + "                        <div class=\"modal-body\">\n"
                                            + "                            <h5 class=\"alert alert-info\" style=\"color: rgb(20, 8, 73);\">\n"
                                            + "                                Vous allez faire un retrait de " + montant + " Ariary sur\n"
                                            + "                                le compte de " + nom_et_prenoms + "<br><br>\n"
                                            + "                                Numéro bancaire : " + num_compte + "<br>Chèque N° : " + num_cheque + "\n"
                                            + "                            </h5>\n"
                                            + "                        </div>\n"
                                            + "                        <div class=\"modal-footer\">\n"
                                            + "                            <form>\n"
                                            + "                                <input type=\"hidden\" value=\"" + num_compte + "\" name=\"num_compte\" id=\"num_compte\">\n"
                                            + "                                <input type=\"hidden\" value=\"" + num_cheque + "\" name=\"num_cheque\" id=\"num_cheque\">\n"
                                            + "                                <input type=\"hidden\" value=\"" + montant + "\" name=\"montant\" id=\"montant\">\n"
                                            + "                                <input type=\"hidden\" value=\"" + password + "\" name=\"password\" id=\"password\">\n"
                                            + "\n"
                                            + "                                <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\"\n"
                                            + "                                    id=\"annuler-retrait\">Annuler</button>\n"
                                            + "                                <button role=\"button\" type=\"button\" class=\"btn btn-info\" data-bs-dismiss=\"modal\" id=\"valider-retrait\">Envoyer</button>\n"
                                            + "                            </form>"
                                            + "                        </div>");
                                }

                            } else {
                                out.print("<div class=\"modal-header\" autre>\n"
                                        + "                            <h5 class=\"modal-title text-danger\" id=\"staticBackdropLabel\">\n"
                                        + "                                <i class=\"fas fa-exclamation-circle\"></i> IDENTIFIANT INCORRECT</h5>\n"
                                        + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                        + "                        </div>\n"
                                        + "                        <div class=\"modal-body\">\n"
                                        + "                            <h5 class=\"alert alert-danger\" style=\"color: rgb(20, 8, 73);\">\n"
                                        + "                                * MOT DE PASS INCORRECT ! *\n"
                                        + "                            </h5>\n"
                                        + "                        </div>\n"
                                        + "                        <div class=\"modal-footer\">\n"
                                        + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                                        + "                        </div>");
                            }

                        } else {
                            out.print("<div class=\"modal-header\" autre>\n"
                                    + "                            <h5 class=\"modal-title text-danger\" id=\"staticBackdropLabel\">\n"
                                    + "                                <i class=\"fas fa-exclamation-circle\"></i> NUMERO DE COMPTE NON RECONNU</h5>\n"
                                    + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                    + "                        </div>\n"
                                    + "                        <div class=\"modal-body\">\n"
                                    + "                            <h5 class=\"alert alert-danger\" style=\"color: rgb(20, 8, 73);\">\n"
                                    + "                                VEUILLEZ VERIFIER LE NUMERO DE COMPTE.\n"
                                    + "                            </h5>\n"
                                    + "                        </div>\n"
                                    + "                        <div class=\"modal-footer\">\n"
                                    + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                                    + "                        </div>");
                        }
                    } else {
                        Retrait retrait = new Retrait(num_compte, num_cheque, montant);
                        GestionRetrait gr = new GestionRetrait();
                        gr.insert(retrait);
                        List<Retrait> retraits = new GestionRetrait().selectAll();
                        String data = "";
                        for (int i = 0; i < retraits.size(); i++) {
                            data += "<tr>\n"
                                    + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                    + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                    + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                    + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                    + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                    + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                    + "                                </tr>";
                        }
                        out.print(data);
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(VersementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
