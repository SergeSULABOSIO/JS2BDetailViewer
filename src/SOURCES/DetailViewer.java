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
    private DefaultListModel<ProprieteViewer> listModel = null;
    private JList<ProprieteViewer> proprieteList = null;
    private Vector<ConstanteViewer> propConstantes = new Vector<>();
    private Vector<ProprieteViewer> propAEviter = new Vector<>();
    private Vector<ProprieteViewer> propSpeciaux = new Vector<>();
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
        initPropSpeciaux(propSpeciaux);
        init();
    }

    public abstract void initPropConstantes(Vector<ConstanteViewer> constantes);

    public abstract void initPropAEviter(Vector<ProprieteViewer> proprietes);

    public abstract void initPropSpeciaux(Vector<ProprieteViewer> proprietes);

    private ConstanteViewer isPropConstante(String nomChamp, String valeur) {
        for (ConstanteViewer constante : propConstantes) {
            //System.out.println(constante.toString());
            if (constante.getNom().equals(nomChamp) && constante.getCode().equals(valeur)) {
                return constante;
            }
        }
        return null;
    }

    private ProprieteViewer isPropAEviter(String nomChamp) {
        for (ProprieteViewer propriete : propAEviter) {
            //System.out.println(constante.toString());
            if (propriete.getNom().equals(nomChamp)) {
                return propriete;
            }
        }
        return null;
    }

    private void init() {
        icones = new Icones();
        listModel = new DefaultListModel<>();
        listModel.addElement(new ProprieteViewer("***", "***", 0));
        
        if (obj != null) {
            for (Field champ : obj.getClass().getDeclaredFields()) {
                try {
                    ProprieteViewer pp = isPropAEviter(champ.getName() + "");
                    if (pp != null) {
                        continue;
                    }
                    ConstanteViewer cc = isPropConstante(champ.getName() + "", champ.get(obj) + "");
                    if (champ.getType() == int.class) {
                        if (cc == null) {
                            listModel.addElement(new ProprieteViewer(champ.getName(), champ.getInt(obj) + "", ProprieteViewer.TYPE_ENTIER));
                        } else {
                            listModel.addElement(new ProprieteViewer(champ.getName(), cc.getValeur(), ProprieteViewer.TYPE_ENTIER));
                        }
                    } else if (champ.getType() == String.class) {
                        if (cc == null) {
                            listModel.addElement(new ProprieteViewer(champ.getName(), champ.get(obj) + "", ProprieteViewer.TYPE_TEXTE));
                        } else {
                            listModel.addElement(new ProprieteViewer(champ.getName(), cc.getValeur(), ProprieteViewer.TYPE_TEXTE));
                        }
                    } else {
                        if (cc == null) {
                            listModel.addElement(new ProprieteViewer(champ.getName(), champ.get(obj) + "", ProprieteViewer.TYPE_MONNETAIRE));
                        } else {
                            listModel.addElement(new ProprieteViewer(champ.getName(), cc.getValeur(), ProprieteViewer.TYPE_MONNETAIRE));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        for (ProprieteViewer propSpec : propSpeciaux) {
            listModel.addElement(new ProprieteViewer(propSpec.getNom(), propSpec.getValeur(), propSpec.getType()));
        }

        proprieteList = new JList<>(listModel);
        proprieteList.setCellRenderer(new ProprieteRenderer(taillePolice, imageObjet));
        scrolDetail.setViewportView(proprieteList);
        if (tabDetails != null) {
            tabDetails.setTitleAt(0, "Détails - " + nomObjet);
            tabDetails.setIconAt(0, icones.getInfos_01());
        }
    }

}
