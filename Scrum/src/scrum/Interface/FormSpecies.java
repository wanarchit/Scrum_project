package scrum.Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormSpecie;

import scrum.noyau.SpecieCategory;

public class FormSpecies extends JPanel {

    private JTextField fieldNom;
    private MenuPrincipal menu;
    private JComboBox<SpecieCategory> combo;
    private CtrlFormSpecie controleur;
    private JButton valider;

    public FormSpecies(MenuPrincipal theMenu) {
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        
        controleur = new CtrlFormSpecie(this);
        menu = theMenu;
       

        JLabel headTitle = new JLabel("New specie");
        headTitle.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel nom = new JPanel();
        nom.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel titleName = new JLabel("Name :");
        fieldNom = new JTextField();
        fieldNom.setPreferredSize(new Dimension(150, 50));
        nom.add(titleName);
        nom.add(fieldNom);

        JPanel category = new JPanel();
        category.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel titleCategory = new JLabel("Category :");
        combo = new JComboBox();
        for (SpecieCategory specieCategory : menu.getListCategory()) {
            combo.addItem(specieCategory);
        }
        category.add(titleCategory);
        category.add(combo);
        valider = new JButton("Validate");
        valider.addActionListener(controleur);

        this.add(nom);
        this.add(category);
        this.add(valider);
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
    
    public MenuPrincipal getLeMenu(){
        return menu;
    }
}
