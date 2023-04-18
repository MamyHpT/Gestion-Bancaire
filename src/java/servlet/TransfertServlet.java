/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import beans.Transfert;
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
import model.GestionTransfert;

/**
 *
 * @author Mamy Hp
 */
public class TransfertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String pseudo = (String) session.getAttribute("pseudo");
            if (pseudo == null) {
                response.sendRedirect("Login");
            } else {
                GestionTransfert gt = new GestionTransfert();
                List<Transfert> transferts = gt.selectAll();
                request.setAttribute("transferts", transferts);
                request.setAttribute("pseudo", pseudo);
                this.getServletContext().getRequestDispatcher("/WEB-INF/pages/transfert.jsp").forward(request, response);
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
            if (request.getParameter("num_compte_env").isBlank() || request.getParameter("num_compte_rec").isBlank() || request.getParameter("montant").isBlank() || request.getParameter("password").isBlank()) {
                out.print("""
                            <div class="modal-header">
                                <h5 class="modal-title text-danger" id="staticBackdropLabel">
                                    <i class="fas fa-exclamation-circle"></i> ERREUR DE SAISIE</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h5 class="alert alert-danger text-center" style="color: rgb(20, 8, 73);">
                                    * VEUILLEZ VERIFIER LES CHAMPS MANQUANTS ! *
                                </h5>
                            </div>
                            <div class="modal-footer">
                                <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-transfert">OK</button>
                            </div>
                """);
            } else {
                String motif = "";
                if (!request.getParameter("motif").isBlank()) {
                    motif = request.getParameter("motif");
                }
                String num_compte_env = request.getParameter("num_compte_env").toUpperCase(), num_compte_rec = request.getParameter("num_compte_rec").toUpperCase(), password = request.getParameter("password"), nom_env, nom_rec;
                float montant = Float.parseFloat(request.getParameter("montant"));
                if (request.getParameter("action").equals("verification")) {
                    if (gc.verifierCompte(num_compte_env) != 0 && gc.verifierCompte(num_compte_rec) != 0) {
                        if (gc.verifierCompte(num_compte_env, password) != 0) {
                            if (gc.getSolde(num_compte_env) < montant) {
                                out.print("<div class=\"modal-header\">\n"
                                        + "                            <h5 class=\"modal-title text-warning\" id=\"staticBackdropLabel\">\n"
                                        + "                                <i class=\"fas fa-exclamation-triangle\"></i> SOLDE INSUFFISANT</h5>\n"
                                        + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                        + "                        </div>\n"
                                        + "                        <div class=\"modal-body\">\n"
                                        + "                            <h5 class=\"alert alert-warning\" style=\"color: rgb(20, 8, 73);\">\n"
                                        + "                                * VOTRE SOLDE EST INSUFFISANT POUR EFFECTUER CE TRANSFERT ! *<br>Vous avez : " + gc.getSolde(num_compte_env) + " Ariary dans votre compte.\n"
                                        + "                            </h5>\n"
                                        + "                        </div>\n"
                                        + "                        <div class=\"modal-footer\">\n"
                                        + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                                        + "                        </div>");
                            } else {
                                nom_env = gc.selectOne(num_compte_env);
                                nom_rec = new GestionCompte().selectOne(num_compte_rec);
                                out.print("<div class=\"modal-header\">\n"
                                        + "                            <h5 class=\"modal-title text-info\" id=\"staticBackdropLabel\"><i class=\"fas fa-exclamation-triangle\"></i> CONFIRMATION DU TRANSFERT</h5>\n"
                                        + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                        + "                        </div>\n"
                                        + "                        <div class=\"modal-body\">\n"
                                        + "                            <h5 class=\"alert alert-info\" style=\"color: rgb(20, 8, 73);\">\n"
                                        + "                                Vous allez transférer " + montant + " Ariary vers le compte de " + nom_rec + "<br><br>\n"
                                        + "                                Numéro bancaire : " + num_compte_rec + "\n"
                                        + "                            </h5>\n"
                                        + "                            <h5 class=\"alert alert-warning\">\n"
                                        + "                                De la part du compte de " + nom_env + "<br><br>\n"
                                        + "                                Numéro bancaire : " + num_compte_env + "<br>\n"
                                        + "                                Motif : " + motif + "\n"
                                        + "                            </h5>\n"
                                        + "                        </div>\n"
                                        + "                        <div class=\"modal-footer\">\n"
                                        + "                            <form>\n"
                                        + "                                <input type=\"hidden\" value=\"" + num_compte_env + "\" name=\"num_compte_env\" id=\"num_compte_env\">\n"
                                        + "                                <input type=\"hidden\" value=\"" + num_compte_rec + "\" name=\"num_compte_rec\" id=\"num_compte_rec\">\n"
                                        + "                                <input type=\"hidden\" value=\"" + montant + "\" name=\"montant\" id=\"montant\">\n"
                                        + "                                <input type=\"hidden\" value=\"" + motif + "\" name=\"motif\" id=\"motif\">\n"
                                        + "                                <input type=\"hidden\" value=\"" + password + "\" name=\"password\" id=\"password\">\n"
                                        + "\n"
                                        + "                                <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-transfert\">Annuler</button>\n"
                                        + "                                <button role=\"button\" type=\"button\" class=\"btn btn-info\" data-bs-dismiss=\"modal\" id=\"valider-transfert\">Envoyer</button>\n"
                                        + "                            </form>"
                                        + "                        </div>");
                            }

                        } else {
                            out.print("""
                                        <div class="modal-header">
                                            <h5 class="modal-title text-danger" id="staticBackdropLabel">
                                                <i class="fas fa-exclamation-circle"></i> IDENTIFIANT INCORRECT</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <h5 class="alert alert-danger" style="color: rgb(20, 8, 73);">
                                                * LE MOT DE PASS ENVOYEUR EST INCORRECT ! *
                                            </h5>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-transfert">OK</button>
                                        </div>
                            """);
                        }

                    } else {
                        if (gc.verifierCompte(num_compte_env) == 0) {
                            out.print("""
                                        <div class="modal-header">
                                            <h5 class="modal-title text-danger" id="staticBackdropLabel">
                                                <i class="fas fa-exclamation-circle"></i> NUMERO DE COMPTE NON RECONNU</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <h5 class="alert alert-danger" style="color: rgb(20, 8, 73);">
                                                VEUILLEZ VERIFIER LE NUMERO DE COMPTE DE L'ENVOYEUR !
                                            </h5>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-transfert">OK</button>
                                        </div>
                            """);
                        } else {
                            out.print("""
                                        <div class="modal-header">
                                            <h5 class="modal-title text-danger" id="staticBackdropLabel">
                                                <i class="fas fa-exclamation-circle"></i> NUMERO DE COMPTE NON RECONNU</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <h5 class="alert alert-danger" style="color: rgb(20, 8, 73);">
                                                VEUILLEZ VERIFIER LE NUMERO DE COMPTE DU DESTINATAIRE !
                                            </h5>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-transfert">OK</button>
                                        </div>
                            """);
                        }
                    }
                } else {
                    Transfert transfert = new Transfert(num_compte_env, num_compte_rec, montant, motif);
                    GestionTransfert gt = new GestionTransfert();
                    gt.insert(transfert);
                    List<Transfert> transferts = new GestionTransfert().selectAll();
                    String data = "";
                    for (int i = 0; i < transferts.size(); i++) {
                        data += "<tr>\n"
                                + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                + "                                </tr>";
                    }
                    out.print(data);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(VersementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
