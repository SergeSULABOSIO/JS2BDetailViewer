package SOURCES;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package SOURCES;

/**
 *
 * @author HP Pavilion
 */
public class ProprieteViewer {
    public String nom;
    public String valeur;
    public int type;
    public static int TYPE_ENTIER = 0;
    public static int TYPE_TEXTE = 1;
    public static int TYPE_MONNETAIRE = 2;
    public static int TYPE_PERIODE = 3;

    public ProprieteViewer(String nom, String valeur, int type) {
        this.nom = nom;
        this.valeur = valeur;
        this.type = type;
    }

    public ProprieteViewer() {
    }

    public ProprieteViewer(String nom) {
        this.nom = nom;
    }
    
    
    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static int getTYPE_ENTIER() {
        return TYPE_ENTIER;
    }

    public static void setTYPE_ENTIER(int TYPE_ENTIER) {
        ProprieteViewer.TYPE_ENTIER = TYPE_ENTIER;
    }

    public static int getTYPE_TEXTE() {
        return TYPE_TEXTE;
    }

    public static void setTYPE_TEXTE(int TYPE_TEXTE) {
        ProprieteViewer.TYPE_TEXTE = TYPE_TEXTE;
    }

    public static int getTYPE_MONNETAIRE() {
        return TYPE_MONNETAIRE;
    }

    public static void setTYPE_MONNETAIRE(int TYPE_MONNETAIRE) {
        ProprieteViewer.TYPE_MONNETAIRE = TYPE_MONNETAIRE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Propriete{" + "nom=" + nom + ", valeur=" + valeur + '}';
    }    
}
