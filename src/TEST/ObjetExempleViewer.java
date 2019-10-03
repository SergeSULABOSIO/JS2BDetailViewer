/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

/**
 *
 * @author HP Pavilion
 */
public class ObjetExempleViewer {
    public int id;
    public String nom;
    public String postnom;
    public String prenom;
    public String adresse;
    public int idUtilisateur;
    public String nomUtilisateur;
    public double salaire;
    public int sexe;
    public String fonction;
    public String dateEnreg;
    public int tailleResultat;

    public ObjetExempleViewer(int id, String nom, String postnom, String prenom, String adresse, int idUtilisateur, String nomUtilisateur, double salaire, int sexe, String fonction, String dateEnreg, int tailleResultat) {
        this.id = id;
        this.nom = nom;
        this.postnom = postnom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.salaire = salaire;
        this.sexe = sexe;
        this.fonction = fonction;
        this.dateEnreg = dateEnreg;
        this.tailleResultat = tailleResultat;
        
        
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDateEnreg() {
        return dateEnreg;
    }

    public void setDateEnreg(String dateEnreg) {
        this.dateEnreg = dateEnreg;
    }

    public int getTailleResultat() {
        return tailleResultat;
    }

    public void setTailleResultat(int tailleResultat) {
        this.tailleResultat = tailleResultat;
    }

    @Override
    public String toString() {
        return "ObjetExemple{" + "id=" + id + ", nom=" + nom + ", postnom=" + postnom + ", prenom=" + prenom + ", adresse=" + adresse + ", idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur + ", salaire=" + salaire + ", sexe=" + sexe + ", fonction=" + fonction + ", dateEnreg=" + dateEnreg + ", tailleResultat=" + tailleResultat + '}';
    }
    
}


