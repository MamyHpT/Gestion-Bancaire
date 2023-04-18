/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Mamy Hp
 */
public class Compte {
    private String num_compte;
    private String nom_et_prenoms;
    private String password;
    private Float solde;
    private String num_cin;
    private String num_phone;
    private String sexe;
    private String adresse;
    private String email;
    private String date_creation;

    public Compte(String num_compte, String nom_et_prenoms, String password, String num_cin, String num_phone, String sexe, String adresse, String email) {
        this.num_compte = num_compte;
        this.nom_et_prenoms = nom_et_prenoms;
        this.password = password;
        this.num_cin = num_cin;
        this.num_phone = num_phone;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
    }

    public Compte(String num_compte, String password, Float solde, String nom_et_prenoms, String num_cin, String num_phone, String sexe, String adresse, String email, String date_creation) {
        this.num_compte = num_compte;
        this.nom_et_prenoms = nom_et_prenoms;
        this.password = password;
        this.solde = solde;
        this.num_cin = num_cin;
        this.num_phone = num_phone;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.date_creation = date_creation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getSolde() {
        return solde;
    }

    public void setSolde(Float solde) {
        this.solde = solde;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    public String getNom_et_prenoms() {
        return nom_et_prenoms;
    }

    public void setNom_et_prenoms(String nom_et_prenoms) {
        this.nom_et_prenoms = nom_et_prenoms;
    }

    public String getNum_cin() {
        return num_cin;
    }

    public void setNum_cin(String num_cin) {
        this.num_cin = num_cin;
    }

    public String getNum_phone() {
        return num_phone;
    }

    public void setNum_phone(String num_phone) {
        this.num_phone = num_phone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
  
}
