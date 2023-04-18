/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import beans.Compte;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mamy Hp
 */
public class GestionCompte {

    public Connexion connexion;

    public GestionCompte() throws Exception {
        connexion = new Connexion();
    }

    public void insert(Compte compte) throws Exception {
        int num = selectNum() + 1;
        String num_compte = "CO-" + num;
        String query = "INSERT INTO compte(num_compte,nom_et_prenoms,password,num_cin,num_phone,sexe,adresse,email) VALUES('" + num_compte + "','" + compte.getNom_et_prenoms() + "','" + compte.getPassword()+ "','" + compte.getNum_cin() + "','" + compte.getNum_phone() + "','" + compte.getSexe() + "','" + compte.getAdresse() + "','" + compte.getEmail()+ "')";
        connexion.executeUpdate(query);
        Connexion.close();
    }

    public Compte select(String id) throws Exception {
        String query = "SELECT * FROM compte WHERE num_compte='" + id + "' OR nom_et_prenoms='" + id + "'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        String num_compte = rs.getString("num_compte");
        String nom_et_prenoms = rs.getString("nom_et_prenoms");
        String password = rs.getString("password");
        Float solde = rs.getFloat("solde");
        String num_cin = rs.getString("num_cin");
        String num_phone = rs.getString("num_phone");
        String sexe = rs.getString("sexe");
        String adresse = rs.getString("adresse");
        String email = rs.getString("email");
        String date_creation = rs.getTimestamp("date_creation")+"";
        Compte compte = new Compte(num_compte, password, solde, nom_et_prenoms, num_cin, num_phone, sexe, adresse, email, date_creation);
        Connexion.close();

        return compte;
    }
    
    public int selectNum() throws Exception{
        int num;
        String query = "SELECT num_compte FROM compte ORDER BY date_creation DESC LIMIT 1";
        ResultSet rs = connexion.execute(query);
        rs.next();
        String[] t = rs.getString("num_compte").split("-");
        num = Integer.parseInt(t[1]);
        return num;
    }
    
    public String selectOne(String num_compte) throws Exception {
        String query = "SELECT nom_et_prenoms FROM compte WHERE num_compte='" + num_compte + "'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        String nom_et_prenoms = rs.getString("nom_et_prenoms");
        Connexion.close();

        return nom_et_prenoms;
    }

    public List selectAll() throws Exception {
        List<Compte> comptes = new ArrayList<>();
        String query = "SELECT * FROM compte";
        ResultSet rs = connexion.execute(query);
        while (rs.next()) {
            String num_compte = rs.getString("num_compte");
            String nom_et_prenoms = rs.getString("nom_et_prenoms");
            String password = rs.getString("password");
            Float solde = rs.getFloat("solde");
            String num_cin = rs.getString("num_cin");
            String num_phone = rs.getString("num_phone");
            String sexe = rs.getString("sexe");
            String adresse = rs.getString("adresse");
            String email = rs.getString("email");
            String date_creation = rs.getTimestamp("date_creation")+"";
            Compte compte = new Compte(num_compte, password, solde, nom_et_prenoms, num_cin, num_phone, sexe, adresse, email, date_creation);
            comptes.add(compte);
        }
        Connexion.close();

        return comptes;
    }

    public void update(Compte compte) throws Exception {
        String query = "UPDATE compte SET nom_et_prenoms='" + compte.getNom_et_prenoms() + "',num_phone='" + compte.getNum_phone() + "',adresse='" + compte.getAdresse().replace("'", "''") + "',email='" + compte.getEmail().replace("'", "''") + "' WHERE num_compte='" + compte.getNum_compte() + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }
    
    public void updateAll(Compte compte) throws Exception {
        String query = "UPDATE compte SET nom_et_prenoms='" + compte.getNom_et_prenoms() + "',num_cin='" + compte.getNum_cin() + "',num_phone='" + compte.getNum_phone() + "',sexe='" + compte.getSexe() + "',adresse='" + compte.getAdresse().replace("'", "''") + "',email='" + compte.getEmail().replace("'", "''") + "' WHERE num_compte='" + compte.getNum_compte() + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }

    public void delete(String num_compte) throws Exception {
        String query = "DELETE FROM compte WHERE num_compte='" + num_compte + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }

    public Float getSolde(String num_compte) throws Exception {
        Float solde;
        String query = "SELECT solde FROM compte WHERE num_compte='" + num_compte + "'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        solde = rs.getFloat("solde");
        return solde;
    }
    
    public int verifierCompte(String num_compte) throws Exception{
        String query = "SELECT COUNT(nom_et_prenoms) AS nombre FROM compte WHERE num_compte='"+ num_compte +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int verifierCompteNom(String nom_et_prenoms) throws Exception{
        String query = "SELECT COUNT(nom_et_prenoms) AS nombre FROM compte WHERE nom_et_prenoms='"+ nom_et_prenoms +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int verifierCompte(String identifiant, String password) throws Exception{
        String query = "SELECT COUNT(nom_et_prenoms) AS nombre FROM compte WHERE (num_compte='"+ identifiant +"' OR nom_et_prenoms='"+identifiant+"') AND password='"+ password +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public void changePassword(String num_compte, String new_pass) throws Exception {
        String query = "UPDATE compte SET password='" + new_pass + "' WHERE num_compte='" + num_compte + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }

}
