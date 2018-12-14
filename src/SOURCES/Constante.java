/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOURCES;

/**
 *
 * @author HP Pavilion
 */
public class Constante {
    public String nom;
    public String code;
    public String valeur;

    public Constante(String nom, String code, String valeur) {
        this.nom = nom;
        this.code = code;
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Constante{" + "nom=" + nom + ", code=" + code + ", valeur=" + valeur + '}';
    }
}
