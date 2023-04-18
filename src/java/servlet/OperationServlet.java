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
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import beans.*;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import model.*;

/**
 *
 * @author Mamy Hp
 */
public class OperationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String pseudo = (String) session.getAttribute("pseudo");
            if (pseudo == null) {
                response.sendRedirect("Login");
            } else {
                Date d = new Date(new java.util.Date().getTime());
                String date = d.toString();
                int nbversement = new GestionVersement().today(date);
                int nbRetrait = new GestionRetrait().today(date);
                int nbTransfert = new GestionTransfert().today(date);
                GestionVersement gv = new GestionVersement();
                List<Versement> versements = gv.select();
                request.setAttribute("versements", versements);
                request.setAttribute("pseudo", pseudo);
                request.setAttribute("nbVersement", nbversement);
                request.setAttribute("nbRetrait", nbRetrait);
                request.setAttribute("nbTransfert", nbTransfert);
                this.getServletContext().getRequestDispatcher("/WEB-INF/pages/operation.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(OperationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String action = request.getParameter("action");

            switch (action) {
                case "filtre" -> {
                    String filtre = request.getParameter("filtre");
                    switch (filtre) {
                        case "versement" -> {
                            List<Versement> versements = new GestionVersement().select();
                            String data = """
                                        <div class="row mx-auto mt-3 bg-white p-5 rounded table-responsive">
                                            <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle" id="table-versements">
                                                <div class="row mb-3">
                                                    <div class="col-1 form-floating" style="font-weight: bolder;">
                                                        <select class="form-select text-info" name="tri-versement" id="tri-versement" aria-label="Trier par :">
                                                            <option value="id" selected>Numero</option>
                                                            <option value="nom">Nom</option>
                                                            <option value="num">Numero bancaire</option>
                                                            <option value="nouveau">Nouveau</option>
                                                            <option value="montant-sup">Montant Supérieur</option>
                                                            <option value="montant-inf">Montant Inférieur</option>
                                                        </select>
                                                        <label for="tri-versement" style="color: rgb(20, 8, 73);"><i class="fas fa-filter"></i> Trier par :</label>
                                                    </div>
                                                    <div class="col h3 text-center text-info">
                                                        <b><i class="fas fa-list"></i> LISTE DES VERSEMENTS</b>
                                                    </div>
                                                    <div class="col-4">
                                                        <form>
                                                            <div class="input-group mb-3">
                                                                <input type="search" id="rechercher-versement" class="form-control" placeholder="Rechercher ...">
                                                                <button class="btn" type="button" id="btn-recherche-versement">
                                                                    <i class="fas fa-search"></i>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <thead class="text-center text-light border-light">
                                                    <tr>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">N\u00b0</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Nom et Pr\u00e9noms</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Num\u00e9ro de compte</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Montant (Ar)</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Date et Heure</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="liste-versements">
                            """;
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            data += """
                                        </tbody>
                                    </table>
                                </div>""";
                            out.print(data);
                        }
                        case "retrait" -> {
                            List<Retrait> retraits = new GestionRetrait().select();
                            String data = """
                                        <div class="row mx-auto mt-3 bg-white p-5 rounded table-responsive">
                                            <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle" id="table-retraits">
                                                <div class="row mb-3">
                                                    <div class="col-1 form-floating" style="font-weight: bolder;">
                                                        <select class="form-select text-info" name="tri-retrait" id="tri-retrait" aria-label="Trier par :">
                                                            <option value="id" selected>Numero</option>
                                                            <option value="nom">Nom</option>
                                                            <option value="num">Numero bancaire</option>
                                                            <option value="nouveau">Nouveau</option>
                                                            <option value="montant-sup">Montant Supérieur</option>
                                                            <option value="montant-inf">Montant Inférieur</option>
                                                        </select>
                                                        <label for="tri-retrait" style="color: rgb(20, 8, 73);"><i class="fas fa-filter"></i> Trier par :</label>
                                                    </div>
                                                    <div class="col h3 text-center text-info">
                                                        <b><i class="fas fa-list"></i> LISTE DES RETRAITS</b>
                                                    </div>
                                                    <div class="col-4">
                                                        <form>
                                                            <div class="input-group mb-3">
                                                                <input type="search" id="rechercher-retrait" class="form-control" placeholder="Rechercher ...">
                                                                <button class="btn" type="button" id="btn-recherche-retrait">
                                                                    <i class="fas fa-search"></i>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <thead class="text-center text-light border-light">
                                                    <tr>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">N°</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Nom et Prénoms</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Numéro de compte</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Montant (Ar)</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">N° cheque</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Date et Heure</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="liste-retraits">
                            """;
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            data += """
                                        </tbody>
                                    </table>
                                </div>""";
                            out.print(data);
                        }
                        case "transfert" -> {
                            List<Transfert> transferts = new GestionTransfert().select();
                            String data = """
                                        <div class="row mx-auto mt-3 bg-white p-5 rounded table-responsive">
                                            <table class="table table-sm table-striped table-info table-hover table-bordered border-dark align-middle" id="table-transferts">
                                                <div class="row mb-3">
                                                    <div class="col-1 form-floating" style="font-weight: bolder;">
                                                        <select class="form-select text-info" name="tri-transfert" id="tri-transfert" aria-label="Trier par :">
                                                            <option value="id" selected>Numero</option>
                                                            <option value="num">Numero bancaire</option>
                                                            <option value="nouveau">Nouveau</option>
                                                            <option value="montant-sup">Montant Supérieur</option>
                                                            <option value="montant-inf">Montant Inférieur</option>
                                                        </select>
                                                        <label for="tri-transfert" style="color: rgb(20, 8, 73);"><i class="fas fa-filter"></i> Trier par :</label>
                                                    </div>
                                                    <div class="col h3 text-center text-info">
                                                        <b><i class="fas fa-list"></i> LISTE DES TRANSFERTS</b>
                                                    </div>
                                                    <div class="col-4">
                                                        <form>
                                                            <div class="input-group mb-3">
                                                                <input type="search" id="rechercher-transfert" class="form-control" placeholder="Rechercher ...">
                                                                <button class="btn" type="button" id="btn-recherche-transfert">
                                                                    <i class="fas fa-search"></i>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                                <thead class="text-center text-light border-light">
                                                    <tr>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">N°</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);" colspan="2">Envoyeur</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);" colspan="2">Destinataire</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Montant</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Date et Heure</th>
                                                        <th scope="col" style="background-color: rgb(20, 8, 73);">Motif</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="liste-transferts">
                            """;
                            for (int i = 0; i < transferts.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            data += """
                                        </tbody>
                                    </table>
                                </div>""";
                            out.print(data);
                        }
                        default ->
                            throw new AssertionError();
                    }
                }
                case "tri-versement" -> {
                    String tri = request.getParameter("tri");
                    switch (tri) {
                        case "id" -> {
                            List<Versement> versements = new GestionVersement().select();
                            String data = "";
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            out.print(data);
                        }
                        case "nom" -> {
                            List<Versement> versements = new GestionVersement().selectByNom();
                            String data = "";
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            out.print(data);
                        }
                        case "num" -> {
                            List<Versement> versements = new GestionVersement().selectByIdCompte();
                            String data = "";
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            out.print(data);
                        }
                        case "nouveau" -> {
                            List<Versement> versements = new GestionVersement().selectByNouveau();
                            String data = "";
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            out.print(data);
                        }
                        case "montant-sup" -> {
                            List<Versement> versements = new GestionVersement().selectByMontantSup();
                            String data = "";
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            out.print(data);
                        }
                        case "montant-inf" -> {
                            List<Versement> versements = new GestionVersement().selectByMontantInf();
                            String data = "";
                            for (int i = 0; i < versements.size(); i++) {
                                data += "<tr>\n"
                                        + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                        + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "</tr>";
                            }
                            out.print(data);
                        }
                        default ->
                            throw new AssertionError();
                    }
                }
                case "tri-retrait" -> {
                    String tri = request.getParameter("tri");
                    switch (tri) {
                        case "id" -> {
                            List<Retrait> retraits = new GestionRetrait().select();
                            String data = "";
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "nom" -> {
                            List<Retrait> retraits = new GestionRetrait().selectByNom();
                            String data = "";
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "num" -> {
                            List<Retrait> retraits = new GestionRetrait().selectByIdCompte();
                            String data = "";
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "nouveau" -> {
                            List<Retrait> retraits = new GestionRetrait().selectByNouveau();
                            String data = "";
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "montant-sup" -> {
                            List<Retrait> retraits = new GestionRetrait().selectByMontantSup();
                            String data = "";
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "montant-inf" -> {
                            List<Retrait> retraits = new GestionRetrait().selectByMontantInf();
                            String data = "";
                            for (int i = 0; i < retraits.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                        + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        default ->
                            throw new AssertionError();
                    }
                }
                case "tri-transfert" -> {
                    String tri = request.getParameter("tri");
                    switch (tri) {
                        case "id" -> {
                            List<Transfert> transferts = new GestionTransfert().select();
                            String data = "";
                            for (int i = 0; i < transferts.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>\n"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "num" -> {
                            List<Transfert> transferts = new GestionTransfert().selectByIdCompte();
                            String data = "";
                            for (int i = 0; i < transferts.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>\n"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "nouveau" -> {
                            List<Transfert> transferts = new GestionTransfert().selectByNouveau();
                            String data = "";
                            for (int i = 0; i < transferts.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>\n"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "montant-sup" -> {
                            List<Transfert> transferts = new GestionTransfert().selectByMontantSup();
                            String data = "";
                            for (int i = 0; i < transferts.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>\n"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        case "montant-inf" -> {
                            List<Transfert> transferts = new GestionTransfert().selectByMontantInf();
                            String data = "";
                            for (int i = 0; i < transferts.size(); i++) {
                                data += "<tr>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                        + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                        + "                                    <td class=\"text-center\">\n"
                                        + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                        + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                        + "                                        </button>\n"
                                        + "                                    </td>\n"
                                        + "                                </tr>";
                            }
                            out.print(data);
                        }
                        default ->
                            throw new AssertionError();
                    }
                }
                case "supprimer-versement" -> {
                    int num_versement = Integer.parseInt(request.getParameter("num_versement"));
                    String password = request.getParameter("password"), tri = request.getParameter("tri");
                    GestionAdmin ga = new GestionAdmin();
                    if (ga.verifyPass(password) == 0) {
                        out.print("incorrect");
                    } else {
                        GestionVersement gv = new GestionVersement();
                        gv.delete(num_versement);
                        switch (tri) {
                            case "id" -> {
                                List<Versement> versements = new GestionVersement().select();
                                String data = "";
                                for (int i = 0; i < versements.size(); i++) {
                                    data += "<tr>\n"
                                            + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "</tr>";
                                }
                                out.print(data);
                            }
                            case "nom" -> {
                                List<Versement> versements = new GestionVersement().selectByNom();
                                String data = "";
                                for (int i = 0; i < versements.size(); i++) {
                                    data += "<tr>\n"
                                            + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "</tr>";
                                }
                                out.print(data);
                            }
                            case "num" -> {
                                List<Versement> versements = new GestionVersement().selectByIdCompte();
                                String data = "";
                                for (int i = 0; i < versements.size(); i++) {
                                    data += "<tr>\n"
                                            + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "</tr>";
                                }
                                out.print(data);
                            }
                            case "nouveau" -> {
                                List<Versement> versements = new GestionVersement().selectByNouveau();
                                String data = "";
                                for (int i = 0; i < versements.size(); i++) {
                                    data += "<tr>\n"
                                            + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "</tr>";
                                }
                                out.print(data);
                            }
                            case "montant-sup" -> {
                                List<Versement> versements = new GestionVersement().selectByMontantSup();
                                String data = "";
                                for (int i = 0; i < versements.size(); i++) {
                                    data += "<tr>\n"
                                            + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "</tr>";
                                }
                                out.print(data);
                            }
                            case "montant-inf" -> {
                                List<Versement> versements = new GestionVersement().selectByMontantInf();
                                String data = "";
                                for (int i = 0; i < versements.size(); i++) {
                                    data += "<tr>\n"
                                            + "<td>" + versements.get(i).getNum_versement() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + versements.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getMontant_versement() + "</td>\n"
                                            + "                                    <td class=\"text-end\">" + versements.get(i).getDate_versement() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-versement\" id=\"supprimer-versement\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "</tr>";
                                }
                                out.print(data);
                            }
                            default ->
                                throw new AssertionError();
                        }
                    }
                }
                case "supprimer-retrait" -> {
                    int num_retrait = Integer.parseInt(request.getParameter("num_retrait"));
                    String password = request.getParameter("password"), tri = request.getParameter("tri");
                    GestionAdmin ga = new GestionAdmin();
                    if (ga.verifyPass(password) == 0) {
                        out.print("incorrect");
                    } else {
                        GestionRetrait gv = new GestionRetrait();
                        gv.delete(num_retrait);
                        switch (tri) {
                            case "id" -> {
                                List<Retrait> retraits = new GestionRetrait().select();
                                String data = "";
                                for (int i = 0; i < retraits.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "nom" -> {
                                List<Retrait> retraits = new GestionRetrait().selectByNom();
                                String data = "";
                                for (int i = 0; i < retraits.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "num" -> {
                                List<Retrait> retraits = new GestionRetrait().selectByIdCompte();
                                String data = "";
                                for (int i = 0; i < retraits.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "nouveau" -> {
                                List<Retrait> retraits = new GestionRetrait().selectByNouveau();
                                String data = "";
                                for (int i = 0; i < retraits.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "montant-sup" -> {
                                List<Retrait> retraits = new GestionRetrait().selectByMontantSup();
                                String data = "";
                                for (int i = 0; i < retraits.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "montant-inf" -> {
                                List<Retrait> retraits = new GestionRetrait().selectByMontantInf();
                                String data = "";
                                for (int i = 0; i < retraits.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNom_et_prenoms() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_compte() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getMontant_retrait() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getNum_cheque() + "</td>\n"
                                            + "                                    <td>" + retraits.get(i).getDate_retrait() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-retrait\" id=\"supprimer-retrait\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            default ->
                                throw new AssertionError();
                        }
                    }
                }
                case "supprimer-transfert" -> {
                    int num_transfert = Integer.parseInt(request.getParameter("num_transfert"));
                    String password = request.getParameter("password"), tri = request.getParameter("tri");
                    GestionAdmin ga = new GestionAdmin();
                    if (ga.verifyPass(password) == 0) {
                        out.print("incorrect");
                    } else {
                        GestionTransfert gt = new GestionTransfert();
                        gt.delete(num_transfert);
                        switch (tri) {
                            case "id" -> {
                                List<Transfert> transferts = new GestionTransfert().select();
                                String data = "";
                                for (int i = 0; i < transferts.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>\n"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "num" -> {
                                List<Transfert> transferts = new GestionTransfert().selectByIdCompte();
                                String data = "";
                                for (int i = 0; i < transferts.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>\n"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "nouveau" -> {
                                List<Transfert> transferts = new GestionTransfert().selectByNouveau();
                                String data = "";
                                for (int i = 0; i < transferts.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>\n"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "montant-sup" -> {
                                List<Transfert> transferts = new GestionTransfert().selectByMontantSup();
                                String data = "";
                                for (int i = 0; i < transferts.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>\n"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            case "montant-inf" -> {
                                List<Transfert> transferts = new GestionTransfert().selectByMontantInf();
                                String data = "";
                                for (int i = 0; i < transferts.size(); i++) {
                                    data += "<tr>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_env() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNum_compte_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getNom_rec() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMontant_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getDate_transfert() + "</td>\n"
                                            + "                                    <td>" + transferts.get(i).getMotif() + "</td>\n"
                                            + "                                    <td class=\"text-center\">\n"
                                            + "                                        <button class=\"btn btn-outline-danger\" role=\"button\" title=\"Supprimer\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-supprimer-transfert\" id=\"supprimer-transfert\">\n"
                                            + "                                            <i class=\"fas fa-trash-alt\"></i>\n"
                                            + "                                        </button>\n"
                                            + "                                    </td>\n"
                                            + "                                </tr>";
                                }
                                out.print(data);
                            }
                            default ->
                                throw new AssertionError();
                        }
                    }
                }
                case "ret" -> {
                    Date d = new Date(new java.util.Date().getTime());
                    String date = d.toString();
                    String tri = request.getParameter("tri");
                    switch (tri) {
                        case "today" -> {
                            out.print(new GestionRetrait().today(date));
                        }
                        case "month" -> {
                            out.print(new GestionRetrait().monthly(date));
                        }
                        case "year" -> {
                            out.print(new GestionRetrait().year(date));
                        }
                        default ->
                            throw new AssertionError();
                    }
                }
                case "vers" -> {
                    Date d = new Date(new java.util.Date().getTime());
                    String date = d.toString();
                    String tri = request.getParameter("tri");
                    switch (tri) {
                        case "today" -> {
                            out.print(new GestionVersement().today(date));
                        }
                        case "month" -> {
                            out.print(new GestionVersement().monthly(date));
                        }
                        case "year" -> {
                            out.print(new GestionVersement().year(date));
                        }
                        default ->
                            throw new AssertionError();
                    }
                }
                case "trans" -> {
                    Date d = new Date(new java.util.Date().getTime());
                    String date = d.toString();
                    String tri = request.getParameter("tri");
                    switch (tri) {
                        case "today" -> {
                            out.print(new GestionTransfert().today(date));
                        }
                        case "month" -> {
                            out.print(new GestionTransfert().monthly(date));
                        }
                        case "year" -> {
                            out.print(new GestionTransfert().year(date));
                        }
                        default ->
                            throw new AssertionError();
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
