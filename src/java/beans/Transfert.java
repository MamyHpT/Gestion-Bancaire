/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Mamy Hp
 */
public class Transfert {
    private int num_transfert;
    private String num_compte_env;
    private String num_compte_rec;
    private Float montant_transfert;
    private String motif;
    private String date_transfert;
    private String nom_env;
    private String nom_rec;

    public Transfert(String num_compte_env, String num_compte_rec, Float montant_transfert, String motif) {
        this.num_compte_env = num_compte_env;
        this.num_compte_rec = num_compte_rec;
        this.montant_transfert = montant_transfert;
        this.motif = motif;
    }

    public Transfert(int num_transfert, String num_compte_env, String num_compte_rec, Float montant_transfert, String motif, String date_transfert, String nom_env, String nom_rec) {
        this.num_transfert = num_transfert;
        this.num_compte_env = num_compte_env;
        this.num_compte_rec = num_compte_rec;
        this.montant_transfert = montant_transfert;
        this.motif = motif;
        this.date_transfert = date_transfert;
        this.nom_env = nom_env;
        this.nom_rec = nom_rec;
    }

    public String getNom_env() {
        return nom_env;
    }

    public void setNom_env(String nom_et_prenoms) {
        this.nom_env = nom_et_prenoms;
    }

    public String getNom_rec() {
        return nom_rec;
    }

    public void setNom_rec(String nom_rec) {
        this.nom_rec = nom_rec;
    }

    public int getNum_transfert() {
        return num_transfert;
    }

    public void setNum_transfert(int num_transfert) {
        this.num_transfert = num_transfert;
    }

    public String getDate_transfert() {
        return date_transfert;
    }

    public void setDate_transfert(String date_transfert) {
        this.date_transfert = date_transfert;
    }

    public String getNum_compte_env() {
        return num_compte_env;
    }

    public void setNum_compte_env(String num_compte_env) {
        this.num_compte_env = num_compte_env;
    }

    public String getNum_compte_rec() {
        return num_compte_rec;
    }

    public void setNum_compte_rec(String num_compte_rec) {
        this.num_compte_rec = num_compte_rec;
    }

    public Float getMontant_transfert() {
        return montant_transfert;
    }

    public void setMontant_transfert(Float montant_transfert) {
        this.montant_transfert = montant_transfert;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
    
    
}
