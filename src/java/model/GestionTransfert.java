/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import beans.Transfert;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mamy Hp
 */
public class GestionTransfert {

    public Connexion connexion;

    public GestionTransfert() throws Exception {
        connexion = new Connexion();
    }

    public void insert(Transfert transfert) throws Exception {
        GestionCompte gc = new GestionCompte();
        Float solde_env = gc.getSolde(transfert.getNum_compte_env()) - transfert.getMontant_transfert();
        Float solde_rec = gc.getSolde(transfert.getNum_compte_rec()) + transfert.getMontant_transfert();
        String query1 = "UPDATE compte SET solde='" + solde_env + "' WHERE num_compte='" + transfert.getNum_compte_env() + "'";
        connexion.executeUpdate(query1);
        String query2 = "UPDATE compte SET solde='" + solde_rec + "' WHERE num_compte='" + transfert.getNum_compte_rec() + "'";
        connexion.executeUpdate(query2);
        if (transfert.getMotif().isBlank()) {
            String query3 = "INSERT INTO transfert(num_compte_env,num_compte_rec,montant_transfert) VALUES('" + transfert.getNum_compte_env() + "','" + transfert.getNum_compte_rec() + "','" + transfert.getMontant_transfert() + "')";
            connexion.executeUpdate(query3);
        } else {
            String query3 = "INSERT INTO transfert(num_compte_env,num_compte_rec,montant_transfert,motif) VALUES('" + transfert.getNum_compte_env() + "','" + transfert.getNum_compte_rec() + "','" + transfert.getMontant_transfert() + "','" + transfert.getMotif() + "')";
            connexion.executeUpdate(query3);
        }
        Connexion.close();
    }

    public List<Transfert> select() throws Exception {
        List<Transfert> transferts = new ArrayList<>();
        String query1 = "SELECT * FROM transfert ORDER BY date_transfert";
        ResultSet rs1 = connexion.execute(query1);
        while (rs1.next()) {
            int num_transfert = rs1.getInt("num_transfert");
            String num_compte_env = rs1.getString("num_compte_env");
            String num_compte_rec = rs1.getString("num_compte_rec");
            Float montant_transfert = rs1.getFloat("montant_transfert");
            String motif = rs1.getString("motif");
            String date_transfert = rs1.getDate("date_transfert") + "";
            String query2 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_env + "'";
            ResultSet rs2 = new Connexion().execute(query2);
            rs2.next();
            String nom_env = rs2.getString("nom_et_prenoms");
            String query3 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_rec + "'";
            ResultSet rs3 = new Connexion().execute(query3);
            rs3.next();
            String nom_rec = rs3.getString("nom_et_prenoms");
            Transfert transfert = new Transfert(num_transfert, num_compte_env, num_compte_rec, montant_transfert, motif, date_transfert, nom_env, nom_rec);
            transferts.add(transfert);
        }
        Connexion.close();

        return transferts;
    }

    public List<Transfert> selectByIdCompte() throws Exception {
        List<Transfert> transferts = new ArrayList<>();
        String query1 = "SELECT * FROM transfert ORDER BY num_compte_env ASC";
        ResultSet rs1 = connexion.execute(query1);
        while (rs1.next()) {
            int num_transfert = rs1.getInt("num_transfert");
            String num_compte_env = rs1.getString("num_compte_env");
            String num_compte_rec = rs1.getString("num_compte_rec");
            Float montant_transfert = rs1.getFloat("montant_transfert");
            String motif = rs1.getString("motif");
            String date_transfert = rs1.getDate("date_transfert") + "";
            String query2 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_env + "'";
            ResultSet rs2 = new Connexion().execute(query2);
            rs2.next();
            String nom_env = rs2.getString("nom_et_prenoms");
            String query3 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_rec + "'";
            ResultSet rs3 = new Connexion().execute(query3);
            rs3.next();
            String nom_rec = rs3.getString("nom_et_prenoms");
            Transfert transfert = new Transfert(num_transfert, num_compte_env, num_compte_rec, montant_transfert, motif, date_transfert, nom_env, nom_rec);
            transferts.add(transfert);
        }
        Connexion.close();

        return transferts;
    }

    public List<Transfert> selectByNouveau() throws Exception {
        List<Transfert> transferts = new ArrayList<>();
        String query1 = "SELECT * FROM transfert ORDER BY date_transfert DESC";
        ResultSet rs1 = connexion.execute(query1);
        while (rs1.next()) {
            int num_transfert = rs1.getInt("num_transfert");
            String num_compte_env = rs1.getString("num_compte_env");
            String num_compte_rec = rs1.getString("num_compte_rec");
            Float montant_transfert = rs1.getFloat("montant_transfert");
            String motif = rs1.getString("motif");
            String date_transfert = rs1.getDate("date_transfert") + "";
            String query2 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_env + "'";
            ResultSet rs2 = new Connexion().execute(query2);
            rs2.next();
            String nom_env = rs2.getString("nom_et_prenoms");
            String query3 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_rec + "'";
            ResultSet rs3 = new Connexion().execute(query3);
            rs3.next();
            String nom_rec = rs3.getString("nom_et_prenoms");
            Transfert transfert = new Transfert(num_transfert, num_compte_env, num_compte_rec, montant_transfert, motif, date_transfert, nom_env, nom_rec);
            transferts.add(transfert);
        }
        Connexion.close();

        return transferts;
    }

    public List<Transfert> selectByMontantSup() throws Exception {
        List<Transfert> transferts = new ArrayList<>();
        String query1 = "SELECT * FROM transfert ORDER BY montant_transfert DESC";
        ResultSet rs1 = connexion.execute(query1);
        while (rs1.next()) {
            int num_transfert = rs1.getInt("num_transfert");
            String num_compte_env = rs1.getString("num_compte_env");
            String num_compte_rec = rs1.getString("num_compte_rec");
            Float montant_transfert = rs1.getFloat("montant_transfert");
            String motif = rs1.getString("motif");
            String date_transfert = rs1.getDate("date_transfert") + "";
            String query2 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_env + "'";
            ResultSet rs2 = new Connexion().execute(query2);
            rs2.next();
            String nom_env = rs2.getString("nom_et_prenoms");
            String query3 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_rec + "'";
            ResultSet rs3 = new Connexion().execute(query3);
            rs3.next();
            String nom_rec = rs3.getString("nom_et_prenoms");
            Transfert transfert = new Transfert(num_transfert, num_compte_env, num_compte_rec, montant_transfert, motif, date_transfert, nom_env, nom_rec);
            transferts.add(transfert);
        }
        Connexion.close();

        return transferts;
    }

    public List<Transfert> selectByMontantInf() throws Exception {
        List<Transfert> transferts = new ArrayList<>();
        String query1 = "SELECT * FROM transfert ORDER BY montant_transfert ASC";
        ResultSet rs1 = connexion.execute(query1);
        while (rs1.next()) {
            int num_transfert = rs1.getInt("num_transfert");
            String num_compte_env = rs1.getString("num_compte_env");
            String num_compte_rec = rs1.getString("num_compte_rec");
            Float montant_transfert = rs1.getFloat("montant_transfert");
            String motif = rs1.getString("motif");
            String date_transfert = rs1.getDate("date_transfert") + "";
            String query2 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_env + "'";
            ResultSet rs2 = new Connexion().execute(query2);
            rs2.next();
            String nom_env = rs2.getString("nom_et_prenoms");
            String query3 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_rec + "'";
            ResultSet rs3 = new Connexion().execute(query3);
            rs3.next();
            String nom_rec = rs3.getString("nom_et_prenoms");
            Transfert transfert = new Transfert(num_transfert, num_compte_env, num_compte_rec, montant_transfert, motif, date_transfert, nom_env, nom_rec);
            transferts.add(transfert);
        }
        Connexion.close();

        return transferts;
    }

    public List selectAll() throws Exception {
        List<Transfert> transferts = new ArrayList<>();
        String query1 = "SELECT * FROM transfert ORDER BY date_transfert DESC LIMIT 5";
        ResultSet rs1 = connexion.execute(query1);
        while (rs1.next()) {
            int num_transfert = rs1.getInt("num_transfert");
            String num_compte_env = rs1.getString("num_compte_env");
            String num_compte_rec = rs1.getString("num_compte_rec");
            Float montant_transfert = rs1.getFloat("montant_transfert");
            String motif = rs1.getString("motif");
            String date_transfert = rs1.getDate("date_transfert") + "";
            String query2 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_env + "'";
            ResultSet rs2 = new Connexion().execute(query2);
            rs2.next();
            String nom_env = rs2.getString("nom_et_prenoms");
            String query3 = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte_rec + "'";
            ResultSet rs3 = new Connexion().execute(query3);
            rs3.next();
            String nom_rec = rs3.getString("nom_et_prenoms");
            Transfert transfert = new Transfert(num_transfert, num_compte_env, num_compte_rec, montant_transfert, motif, date_transfert, nom_env, nom_rec);
            transferts.add(transfert);
        }
        Connexion.close();

        return transferts;
    }

    public void update(Transfert transfert) throws Exception {
        String query = "UPDATE transfert SET motif='" + transfert.getMotif() + "' WHERE num_transfert='" + transfert.getNum_transfert() + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }

    public void delete(int num_transfert) throws Exception {
        String query = "DELETE FROM transfert WHERE num_transfert='" + num_transfert + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }
    
    public int today(String date) throws Exception{
        String query = "SELECT COUNT(num_transfert) AS nombre FROM transfert WHERE date_transfert LIKE '"+ date +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int monthly(String date) throws Exception{
        String mois = date.split("-")[0]+"-"+date.split("-")[1]+"-";
        String query = "SELECT COUNT(num_transfert) AS nombre FROM transfert WHERE date_transfert LIKE '"+ mois +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int year(String date) throws Exception{
        String annee = date.split("-")[0]+"-";
        String query = "SELECT COUNT(num_transfert) AS nombre FROM transfert WHERE date_transfert LIKE '"+ annee +"%'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }

}
