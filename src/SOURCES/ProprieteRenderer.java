/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOURCES;

import ICONES.Icones;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author HP Pavilion
 */
public class ProprieteRenderer extends JLabel implements ListCellRenderer<ProprieteViewer> {

    private Icones icones = null;
    private int taillePolice;
    private ImageIcon imageObjet;

    public ProprieteRenderer(int taillePolice, ImageIcon imageObjet) {
        this.taillePolice = taillePolice;
        this.imageObjet = imageObjet;
        this.icones = new Icones();
        setOpaque(true);
    }

    private void setImage(ProprieteViewer value) {
        if (value.getType() == ProprieteViewer.TYPE_TEXTE) {
            setIcon(icones.getTexte_01());
        } else if(value.getType() == ProprieteViewer.TYPE_ENTIER){
            setIcon(icones.getLatte_01());
        } else if(value.getType() == ProprieteViewer.TYPE_MONNETAIRE){
            setIcon(icones.getArgent_01());
        } else if(value.getType() == ProprieteViewer.TYPE_PERIODE){
            setIcon(icones.getCalendrier_01());
        }
    }

    private void appliquerCouleurSelection(boolean isSelected) {
        if (isSelected == true) {
            setBackground(Color.LIGHT_GRAY);
            setForeground(Color.BLACK);
            setFont(new java.awt.Font("Tahoma", Font.BOLD, taillePolice));
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            setFont(new java.awt.Font("Tahoma", Font.PLAIN, taillePolice));
        }
    }

    private void setPositionEntete() {
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    }
    
    private void setPositionLigneSImple() {
        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ProprieteViewer> list, ProprieteViewer value, int index, boolean isSelected, boolean cellHasFocus) {
        String nom = value.getNom();
        String valeur = value.getValeur();
        

        if(nom.equals("***")){
            setText("");
            setPositionEntete();
            setIcon(imageObjet);
        }else{
            setText(" " + nom + " :: " + valeur);
            setPositionLigneSImple();
            setImage(value);
        }
        appliquerCouleurSelection(isSelected);
        return this;
    }

}
