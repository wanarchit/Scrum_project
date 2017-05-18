package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.LINE_END;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormSpecie;

import scrum.noyau.SpecieCategory;

public class FormSpecies extends JPanel {

    private JTextField fieldNom;
    private MenuSecretary menu;
    private JComboBox<SpecieCategory> combo;
    private CtrlFormSpecie controleur;
    private JButton valider;
    private JButton retour;

    public FormSpecies(MenuSecretary theMenu) {
        
        controleur = new CtrlFormSpecie(this);
        menu = theMenu;
       
        JLabel headTitle = new JLabel("New specie");
        headTitle.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel panGeneral = new JPanel(new GridBagLayout());
        
        JLabel titleName = new JLabel("Name :    ");
        fieldNom = new JTextField(20);
        
        //CREATION GRIDBAG
        GridBagConstraints centreADroite = new GridBagConstraints();
        centreADroite.anchor = GridBagConstraints.LINE_END;
        
        GridBagConstraints centreAGauche = new GridBagConstraints();
        centreAGauche.anchor = GridBagConstraints.LINE_START;

        //AJOUT PANEL
        centreADroite.gridx=0;
        centreADroite.gridy=0;
        panGeneral.add(titleName,centreADroite);
        
        centreAGauche.gridx=1;
        centreAGauche.gridy=0;
        panGeneral.add(fieldNom,centreAGauche);

        JPanel category = new JPanel();
        category.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel titleCategory = new JLabel("Category :    ");
        combo = new JComboBox();
        for (SpecieCategory specieCategory : menu.getLeMenu2().getListCategory()) {
            combo.addItem(specieCategory);
        }
        category.add(titleCategory);
        category.add(combo);
        
        centreADroite.gridx=0;
        centreADroite.gridy=1;    
        centreAGauche.gridx=1;
        centreAGauche.gridy=1;

        panGeneral.add(titleCategory,centreADroite);
        panGeneral.add(combo,centreAGauche);
        
        JPanel panButValid = new JPanel();
        valider = new JButton("Validation");
        valider.addActionListener(controleur);
        panButValid.add(valider);
        
        JPanel panButRetour = new JPanel();
        retour = new JButton("Retour");
        retour.addActionListener(controleur);
        panButRetour.add(retour);
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.setLayout(new BorderLayout());
        this.add(headTitle,BorderLayout.NORTH);
        this.add(panGeneral, BorderLayout.CENTER);
        this.add(panButtons, BorderLayout.SOUTH);
    }

    public JTextField getValFieldNom(){
        return fieldNom;
    }
    
    public SpecieCategory getValCombo(){
        return combo.getItemAt(combo.getSelectedIndex());
    }
    
    public JButton getButValider(){
        return valider;
    }
    
    public JButton getButRetour(){
        return retour;
    }
        
    public MenuSecretary getLeMenu(){
        return menu;
    }
}
