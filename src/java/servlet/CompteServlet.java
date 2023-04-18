/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import beans.Compte;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.GestionCompte;

/**
 *
 * @author Mamy Hp
 */
public class CompteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String pseudo = (String) session.getAttribute("pseudo");
            if (pseudo == null) {
                response.sendRedirect("Login");
            } else {
                GestionCompte gc = new GestionCompte();
                List<Compte> compte = gc.selectAll();
                request.setAttribute("comptes", compte);
                request.setAttribute("pseudo", pseudo);
                this.getServletContext().getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(request, response);
            }
        } catch (Exception ex) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            GestionCompte gc = new GestionCompte();
            String action = request.getParameter("action");
            switch (action) {
                case "ajout" -> {
                    String nom_et_prenoms = request.getParameter("nom_et_prenoms"), num_cin = request.getParameter("num_cin"), num_phone = request.getParameter("num_phone"), sexe = request.getParameter("sexe"), adresse = request.getParameter("adresse"), email = request.getParameter("email"), password = request.getParameter("password");
                    if (gc.verifierCompteNom(nom_et_prenoms) != 0) {
                        out.print("<span class=\"alert alert-danger\" compte_existant>* CETTE PERSONNE A DEJA UN COMPTE *</span>");
                    } else {
                        Compte compte = new Compte(num_phone, nom_et_prenoms, password, num_cin, num_phone, sexe, adresse, email);
                        gc.insert(compte);
                        String data = "";
                        List<Compte> comptes = new GestionCompte().selectAll();
                        for (int i = 0; i < comptes.size(); i++) {
                            data += "<tr>\n"
                                    + "                                    <td><img src=\"./img/moi.jpg\" class=\"img-fluid border rounded-circle border-light\" alt=\"profile\"></td>\n"
                                    + "                                    <td>" + comptes.get(i).getNom_et_prenoms() + "</td>\n"
                                    + "                                    <td>" + comptes.get(i).getNum_compte() + "</td>\n"
                                    + "                                    <td>" + comptes.get(i).getNum_phone() + "</td>\n"
                                    + "                                    <td>" + comptes.get(i).getAdresse() + "</td>\n"
                                    + "                                    <td>" + comptes.get(i).getEmail() + "</td>\n"
                                    + "                                    <td>\n"
                                    + "                                        <a href=\"InfoCompte?num_compte=" + comptes.get(i).getNum_compte() + "\" class=\"btn btn-sm btn-outline-dark\" role=\"button\" title=\"info\" id=\"info-compte\"><i class=\"fas fa-info-circle\"></i></a>\n"
                                    + "                                        <button class=\"btn btn-sm btn-outline-info ms-2\" role=\"button\" title=\"modifier\" id=\"modifier-info-compte\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-modifier-info-compte\">\n"
                                    + "                                            <i class=\"fas fa-user-edit\"></i>\n"
                                    + "                                        </button>\n"
                                    + "                                    </td>\n"
                                    + "                                </tr>";
                        }
                        out.print(data);
                    }
                }
                case "modif" -> {
                    String num_compte = request.getParameter("num_compte"), nom_et_prenoms = request.getParameter("nom_et_prenoms"), num_phone = request.getParameter("num_phone"), adresse = request.getParameter("adresse"), email = request.getParameter("email");
                    Compte compte = new Compte(num_compte, nom_et_prenoms, "", "", num_phone, "", adresse, email);
                    gc.update(compte);
                    String data = "";
                    List<Compte> comptes = new GestionCompte().selectAll();
                    for (int i = 0; i < comptes.size(); i++) {
                        data += "<tr>\n"
                                + "                                    <td><img src=\"./img/moi.jpg\" class=\"img-fluid border rounded-circle border-light\" alt=\"profile\"></td>\n"
                                + "                                    <td>" + comptes.get(i).getNom_et_prenoms() + "</td>\n"
                                + "                                    <td>" + comptes.get(i).getNum_compte() + "</td>\n"
                                + "                                    <td>" + comptes.get(i).getNum_phone() + "</td>\n"
                                + "                                    <td>" + comptes.get(i).getAdresse() + "</td>\n"
                                + "                                    <td>" + comptes.get(i).getEmail() + "</td>\n"
                                + "                                    <td>\n"
                                + "                                        <a href=\"InfoCompte?num_compte=" + comptes.get(i).getNum_compte() + "\" class=\"btn btn-sm btn-outline-dark\" role=\"button\" title=\"info\" id=\"info-compte\"><i class=\"fas fa-info-circle\"></i></a>\n"
                                + "                                        <button class=\"btn btn-sm btn-outline-info ms-2\" role=\"button\" title=\"modifier\" id=\"modifier-info-compte\" data-bs-toggle=\"modal\" data-bs-target=\"#modal-modifier-info-compte\">\n"
                                + "                                            <i class=\"fas fa-user-edit\"></i>\n"
                                + "                                        </button>\n"
                                + "                                    </td>\n"
                                + "                                </tr>";
                    }
                    out.print(data);
                }
                default ->
                    throw new AssertionError();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
