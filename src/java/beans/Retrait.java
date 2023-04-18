/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author Mamy Hp
 */
public class Retrait {

    private int num_retrait;
    private String num_compte;
    private int num_cheque;
    private Float montant_retrait;
    private String date_retrait;
    private String nom_et_prenoms;

    public Retrait(String num_compte, int num_cheque, Float montant_retrait) {
        this.num_compte = num_compte;
        this.num_cheque = num_cheque;
        this.montant_retrait = montant_retrait;
    }

    public Retrait(int num_retrait, String num_compte, int num_cheque, Float montant_retrait, String date_retrait, String nom_et_prenoms) {
        this.num_retrait = num_retrait;
        this.num_compte = num_compte;
        this.num_cheque = num_cheque;
        this.montant_retrait = montant_retrait;
        this.date_retrait = date_retrait;
        this.nom_et_prenoms = nom_et_prenoms;
    }

    public String getNom_et_prenoms() {
        return nom_et_prenoms;
    }

    public void setNom_et_prenoms(String nom_et_prenoms) {
        this.nom_et_prenoms = nom_et_prenoms;
    }

    public int getNum_retrait() {
        return num_retrait;
    }

    public void setNum_retrait(int num_retrait) {
        this.num_retrait = num_retrait;
    }

    public String getDate_retrait() {
        return date_retrait;
    }

    public void setDate_retrait(String date_retrait) {
        this.date_retrait = date_retrait;
    }

    public String getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(String num_compte) {
        this.num_compte = num_compte;
    }

    public int getNum_cheque() {
        return num_cheque;
    }

    public void setNum_cheque(int num_cheque) {
        this.num_cheque = num_cheque;
    }

    public Float getMontant_retrait() {
        return montant_retrait;
    }

    public void setMontant_retrait(Float montant_retrait) {
        this.montant_retrait = montant_retrait;
    }

}
