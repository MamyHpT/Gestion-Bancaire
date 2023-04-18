/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Mamy Hp
 */
public class Versement {
    private int num_versement;
    private String num_compte;
    private Float montant_versement;   
    private String date_versement;
    private String nom_et_prenoms;

    public Versement(String num_compte, Float montant_versement) {
        this.num_compte = num_compte;
        this.montant_versement = montant_versement;
    }

    public Versement(int num_versement, String num_compte, Float montant_versement, String date_versement, String nom_et_prenoms) {
        this.num_versement = num_versement;
        this.num_compte = num_compte;
        this.montant_versement = montant_versement;
        this.date_versement = date_versement;
        this.nom_et_prenoms = nom_et_prenoms;
    }

    public String getNom_et_prenoms() {
        return nom_et_prenoms;
    }

    public void setNom_et_prenoms(String nom_et_prenoms) {
        this.nom_et_prenoms = nom_et_prenoms;
    }

    public int getNum_versement() {
        return num_versement;
    }

    public void setNum_versement(int num_versement) {
        this.num_versement = num_versement;
    }

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    public Float getMontant_versement() {
        return montant_versement;
    }

    public void setMontant_versement(Float montant_versement) {
        this.montant_versement = montant_versement;
    }

    public String getDate_versement() {
        return date_versement;
    }

    public void setDate_versement(String date_versement) {
        this.date_versement = date_versement;
    }
    
}
