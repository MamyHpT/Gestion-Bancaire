/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import beans.Versement;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import model.GestionCompte;
import model.GestionVersement;

/**
 *
 * @author Mamy Hp
 */
public class VersementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String pseudo = (String) session.getAttribute("pseudo");
            if (pseudo == null) {
                response.sendRedirect("Login");
            } else {
                GestionVersement gv = new GestionVersement();
                List<Versement> versements = gv.selectAll();
                request.setAttribute("versements", versements);
                request.setAttribute("pseudo", pseudo);
                this.getServletContext().getRequestDispatcher("/WEB-INF/pages/versement.jsp").forward(request, response);
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
            if (request.getParameter("num_compte").isBlank() || request.getParameter("montant").isBlank()) {
                out.print("""
                    <div class="modal-header" autre>
                        <h5 class="modal-title text-danger" id="staticBackdropLabel">
                            <i class="fas fa-exclamation-circle"></i> ERREUR DE SAISIE</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <h5 class="alert alert-danger" style="color: rgb(20, 8, 73);">
                            * TOUS LES CHAMPS SONT OBLIGATOIRE ! *
                        </h5>
                    </div>
                    <div class="modal-footer">
                        <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-versement">OK</button>
                    </div>
                """);
            } else {
                String num_compte = request.getParameter("num_compte").toUpperCase(), nom_et_prenoms;
                float montant = Float.parseFloat(request.getParameter("montant"));
                if (montant < 1000) {
                    out.print("""
                        <div class="modal-header" autre>
                            <h5 class="modal-title text-warning" id="staticBackdropLabel">
                                <i class="fas fa-exclamation-triangle"></i> ERREUR MONTANT</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <h5 class="alert alert-warning" style="color: rgb(20, 8, 73);">
                                * LE MONTANT DOIT ETRE SUPERIEUR OU EGAL A 1000 ARIARY ! *
                            </h5>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-outline-dark" data-bs-dismiss="modal" id="annuler-versement">OK</button>
                        </div>
                    """);
                } else {
                    if (request.getParameter("action").equals("verification")) {
                        if (gc.verifierCompte(num_compte) != 0) {
                            nom_et_prenoms = gc.selectOne(num_compte);
                            out.print("<div class=\"modal-header\" autre>\n"
                                    + "                            <h5 class=\"modal-title text-info\" id=\"staticBackdropLabel\">\n"
                                    + "                                <i class=\"fas fa-exclamation-triangle\"></i> CONFIRMATION DU VERSEMENT</h5>\n"
                                    + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                    + "                        </div>\n"
                                    + "                        <div class=\"modal-body\">\n"
                                    + "                            <h5 class=\"alert alert-info\" style=\"color: rgb(20, 8, 73);\">\n"
                                    + "                                Vous allez verser " + montant + " Ariary sur le compte de " + nom_et_prenoms + "<br><br>\n"
                                    + "                                Numéro bancaire : " + num_compte + "\n"
                                    + "                            </h5>\n"
                                    + "                        </div>\n"
                                    + "                        <div class=\"modal-footer\">\n"
                                    + "                            <form>\n"
                                    + "                                <input type=\"hidden\" value=\"" + num_compte + "\" name=\"num_compte\" id=\"num_compte\">\n"
                                    + "                                <input type=\"hidden\" value=\"" + montant + "\" name=\"montant\" id=\"montant\">\n"
                                    + "                                <input type=\"hidden\" value=\"validation\" name=\"action\" id=\"action\">\n"
                                    + "\n"
                                    + "                                <button class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\"\n"
                                    + "                                    id=\"annuler-versement\">Annuler</button>\n"
                                    + "                                <button role=\"button\" type=\"button\" class=\"btn btn-info\" data-bs-dismiss=\"modal\" id=\"valider-versement\">Envoyer</button>\n"
                                    + "                            </form>"
                                    + "                        </div>");
                        } else {
                            out.print("<div class=\"modal-header\" autre>\n"
                                    + "                            <h5 class=\"modal-title text-danger\" id=\"staticBackdropLabel\">\n"
                                    + "                                <i class=\"fas fa-exclamation-circle\"></i> NUMERO DE COMPTE NON RECONNU</h5>\n"
                                    + "                            <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n"
                                    + "                        </div>\n"
                                    + "                        <div class=\"modal-body\">\n"
                                    + "                            <h5 class=\"alert alert-danger\" style=\"color: rgb(20, 8, 73);\">\n"
                                    + "                                Veuillez vérifier le numéro de compte.\n"
                                    + "                            </h5>\n"
                                    + "                        </div>\n"
                                    + "                        <div class=\"modal-footer\">\n"
                                    + "                            <button type=\"reset\" class=\"btn btn-outline-dark\" data-bs-dismiss=\"modal\" id=\"annuler-versement\">OK</button>\n"
                                    + "                        </div>");
                        }
                    } else {
                        Versement versement = new Versement(num_compte, montant);
                        GestionVersement gv = new GestionVersement();
                        gv.insert(versement);
                        List<Versement> versements = new GestionVersement().selectAll();
                        String data = "";
                        for (int i = 0; i < versements.size(); i++) {
                            data += "<tr>\n"
                                    + "                                <td>" + versements.get(i).getNum_versement() + "</td>\n"
                                    + "                                <td>" + versements.get(i).getDate_versement() + "</td>\n"
                                    + "                                <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                    + "                                <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                    + "                                <td>" + versements.get(i).getMontant_versement() + "</td>\n"
                                    + "                            </tr>";
                        }
                        out.print(data);
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(VersementServlet.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

}
