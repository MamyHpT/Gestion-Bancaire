/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import beans.Retrait;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Mamy Hp
 */
public class GestionRetrait {

    public Connexion connexion;

    public GestionRetrait() throws Exception {
        connexion = new Connexion();
    }

    public void insert(Retrait retrait) throws Exception {
        GestionCompte gc = new GestionCompte();
        Float nouveau_solde = gc.getSolde(retrait.getNum_compte()) - retrait.getMontant_retrait();
        String query1 = "UPDATE compte SET solde='" + nouveau_solde + "' WHERE num_compte='" + retrait.getNum_compte() + "'";
        connexion.executeUpdate(query1);
        String query2 = "INSERT INTO retrait(num_compte,num_cheque,montant_retrait) VALUES('" + retrait.getNum_compte() + "','" + retrait.getNum_cheque() + "','" + retrait.getMontant_retrait() + "')";
        connexion.executeUpdate(query2);
        Connexion.close();
    }

    public List<Retrait> select() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }
    
    public List<Retrait> selectByNom() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte ORDER BY compte.nom_et_prenoms ASC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }
    
    public List<Retrait> selectByIdCompte() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte ORDER BY retrait.num_compte ASC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }
    
    public List<Retrait> selectByNouveau() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte ORDER BY date_retrait DESC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }
    
    public List<Retrait> selectByMontantSup() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte ORDER BY montant_retrait DESC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }
    
    public List<Retrait> selectByMontantInf() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte ORDER BY montant_retrait ASC";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }
    
    public List<Retrait> selectAll() throws Exception {
        List<Retrait> retraits = new ArrayList<>();
        String query = "SELECT retrait.*,compte.nom_et_prenoms FROM retrait INNER JOIN compte ON retrait.num_compte=compte.num_compte ORDER BY date_retrait DESC LIMIT 5";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            int num_retrait = rs.getInt("num_retrait");
            String num_compte = rs.getString("num_compte");
            int num_cheque = rs.getInt("num_cheque");
            Float montant_retrait = rs.getFloat("montant_retrait");
            String date_retrait = rs.getTimestamp("date_retrait")+"";
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            Retrait retrait = new Retrait(num_retrait, num_compte, num_cheque, montant_retrait, date_retrait, nom_et_prenoms);
            retraits.add(retrait);
        }
        Connexion.close();

        return retraits;
    }

    public void update(Retrait retrait) throws Exception {
        String query = "UPDATE retrait SET num_cheque='" + retrait.getNum_cheque() + "' WHERE num_retrait='" + retrait.getNum_retrait() + "' AND num_compte='" + retrait.getNum_compte() + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }

    public void delete(int num_retrait) throws Exception {
        String query = "DELETE FROM retrait WHERE num_retrait='" + num_retrait + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }
    
    public int today(String date) throws Exception{
        String query = "SELECT COUNT(num_retrait) AS nombre FROM retrait WHERE date_retrait LIKE '"+ date +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int monthly(String date) throws Exception{
        String mois = date.split("-")[0]+"-"+date.split("-")[1]+"-";
        String query = "SELECT COUNT(num_retrait) AS nombre FROM retrait WHERE date_retrait LIKE '"+ mois +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int year(String date) throws Exception{
        String annee = date.split("-")[0]+"-";
        String query = "SELECT COUNT(num_retrait) AS nombre FROM retrait WHERE date_retrait LIKE '"+ annee +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }

}
