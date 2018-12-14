/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOURCES;

import ICONES.Icones;
import java.lang.reflect.Field;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author HP Pavilion
 */
public abstract class DetailViewer {

    public String nomObjet;
    public Object obj;
    public JScrollPane scrolDetail;
    public JTabbedPane tabDetails;
    public int taillePolice;
    private ImageIcon imageObjet;
    private DefaultListModel<Propriete> listModel = null;
    private JList<Propriete> proprieteList = null;
    private Vector<Constante> propConstantes = new Vector<>();
    private Vector<Propriete> propAEviter = new Vector<>();
    private Icones icones = null;

    public DetailViewer(ImageIcon imageObjet, String nomObjet, Object obj, JScrollPane scrolDetail, JTabbedPane tabDetails, int taillePolice) {
        this.nomObjet = nomObjet;
        this.obj = obj;
        this.scrolDetail = scrolDetail;
        this.tabDetails = tabDetails;
        this.taillePolice = taillePolice;
        this.imageObjet = imageObjet;
        
        initPropConstantes(propConstantes);
        initPropAEviter(propAEviter);
        init();
    }
    
    
    public abstract void initPropConstantes(Vector<Constante> constantes);
    public abstract void initPropAEviter(Vector<Propriete> proprietes);

    
    private Constante isPropConstante(String nomChamp, String valeur){
        for(Constante constante : propConstantes){
            //System.out.println(constante.toString());
            if(constante.getNom().equals(nomChamp) && constante.getCode().equals(valeur)){
                return constante;
            }
        }
        return null;
    }
    
    private Propriete isPropAEviter(String nomChamp){
        for(Propriete propriete : propAEviter){
            //System.out.println(constante.toString());
            if(propriete.getNom().equals(nomChamp)){
                return propriete;
            }
        }
        return null;
    }
   
    
    private void init() {
        icones = new Icones();
        listModel = new DefaultListModel<>();
        listModel.addElement(new Propriete("***", "***", 0));
        for (Field champ : obj.getClass().getDeclaredFields()) {
            try {
                Propriete pp = isPropAEviter(champ.getName()+"");
                if(pp != null){
                    continue;
                }
                Constante cc = isPropConstante(champ.getName()+"", champ.get(obj) + "");
                if (champ.getType() == int.class) {
                    if(cc == null){
                        listModel.addElement(new Propriete(champ.getName(), champ.getInt(obj) + "", Propriete.TYPE_ENTIER));
                    }else{
                        listModel.addElement(new Propriete(champ.getName(), cc.getValeur(), Propriete.TYPE_ENTIER));
                    }
                }else if (champ.getType() == String.class) {
                    if(cc == null){
                        listModel.addElement(new Propriete(champ.getName(), champ.get(obj) + "", Propriete.TYPE_TEXTE));
                    }else{
                        listModel.addElement(new Propriete(champ.getName(), cc.getValeur(), Propriete.TYPE_TEXTE));
                    }
                }else{
                    if(cc == null){
                        listModel.addElement(new Propriete(champ.getName(), champ.get(obj) + "", Propriete.TYPE_MONNETAIRE));
                    }else{
                        listModel.addElement(new Propriete(champ.getName(), cc.getValeur(), Propriete.TYPE_MONNETAIRE));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        proprieteList = new JList<>(listModel);
        proprieteList.setCellRenderer(new ProprieteRenderer(taillePolice, imageObjet));
        scrolDetail.setViewportView(proprieteList);
        tabDetails.setTitleAt(0, "Détails - "+nomObjet);
        tabDetails.setIconAt(0, icones.getInfos_01());
    }

}
