/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author Mamy Hp
 */
public class GestionAdmin {
    
    public Connexion connexion;

    public GestionAdmin() throws Exception {
        connexion = new Connexion();
    }
    
    public void insert(String nom, String pseudo, String mail, String pass) throws Exception {
        String query = "INSERT INTO admin(nom_admin,pseudo_admin,password,mail_admin) VALUES('" + nom + "','" + pseudo + "','" + pass + "','" + mail + "')";
        connexion.executeUpdate(query);
        Connexion.close();
    }
    
    public int login(String pseudo, String password) throws Exception{
        String query = "SELECT COUNT(password) as password FROM admin WHERE pseudo_admin='"+ pseudo +"' AND password='"+ password +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("password");
    }
    
    public int verifyPass(String password) throws Exception{
        String query = "SELECT COUNT(password) as password FROM admin WHERE password='"+ password +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("password");
    }
    
    public int verifierAdmin(String pseudo) throws Exception{
        String query = "SELECT COUNT(nom_admin) as nombre FROM admin WHERE pseudo_admin='"+ pseudo +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public int verifierCompte(String nom, String mail) throws Exception{
        String query = "SELECT COUNT(nom_admin) as nombre FROM admin WHERE nom_admin='"+ nom +"' AND mail_admin='"+ mail +"'";
        ResultSet rs = connexion.execute(query);
        rs.next();
        return rs.getInt("nombre");
    }
    
    public void changePassword(String nom, String pass) throws Exception {
        String query = "UPDATE admin SET password='" + pass + "' WHERE nom_admin='" + nom + "'";
        connexion.executeUpdate(query);
        Connexion.close();
    }
    
}
