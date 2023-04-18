/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import beans.Versement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mamy Hp
 */
public class GestionVersement {

    public Connexion connexion;

    public GestionVersement() throws Exception {
        connexion = new Connexion();
    }

    public void insert(Versement versement) throws Exception {
        GestionCompte gc = new GestionCompte();
        Float nouveau_solde = gc.getSolde(versement.getNum_compte()) + versement.getMontant_versement();
        String query1 = "UPDATE compte SET solde='" + nouveau_solde + "' WHERE num_compte='" + versement.getNum_compte() + "'";
        connexion.executeUpdate(query1);
        String query2 = "INSERT INTO versement(num_compte,montant_versement) VALUES('" + versement.getNum_compte() + "'," + versement.getMontant_versement() + ")";
        new Connexion().executeUpdate(query2);
        Connexion.close();
    }

    public List<Versement> select() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }
    
    public List<Versement> selectByNom() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte ORDER BY compte.nom_et_prenoms ASC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }
    
    public List<Versement> selectByIdCompte() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte ORDER BY versement.num_compte ASC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }
    
    public List<Versement> selectByNouveau() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte ORDER BY date_versement DESC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }
    
    public List<Versement> selectByMontantSup() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte ORDER BY montant_versement DESC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }
    
    public List<Versement> selectByMontantInf() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte ORDER BY montant_versement ASC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }

    public List<Versement> selectAll() throws Exception {
        List<Versement> versements = new ArrayList<>();
        String query = "SELECT versement.*,compte.nom_et_prenoms FROM versement INNER JOIN compte ON versement.num_compte=compte.num_compte ORDER BY date_versement DESC LIMIT 5";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_versement = rs.getInt("num_versement");
            String num_compte = rs.getString("num_compte");
            Float montant_versement = rs.getFloat("montant_versement");
            String date_versement = rs.getTimestamp("date_versement")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Versement versement = new Versement(num_versement, num_compte, montant_versement, date_versement, nom_et_prenoms);
            versements.add(versement);
        }
        Connexion.close();

        return versements;
    }

    public void delete(int num_versement) throws Exception {
        String query = "DELETE FROM versement WHERE num_versement='" + num_versement + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }
    
    public int today(String date) throws Exception{
        String query = "SELECT COUNT(num_versement) AS nombre FROM versement WHERE date_versement LIKE '"+ date +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int monthly(String date) throws Exception{
        String mois = date.split("-")[0]+"-"+date.split("-")[1]+"-";
        String query = "SELECT COUNT(num_versement) AS nombre FROM versement WHERE date_versement LIKE '"+ mois +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int year(String date) throws Exception{
        String annee = date.split("-")[0]+"-";
        String query = "SELECT COUNT(num_versement) AS nombre FROM versement WHERE date_versement LIKE '"+ annee +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }

}
