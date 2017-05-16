package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
    private MenuPrincipal menu;
    private JComboBox<SpecieCategory> combo;
    private CtrlFormSpecie controleur;
    private JButton valider;
    private JButton retour;

    public FormSpecies(MenuPrincipal theMenu) {
        
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
        
        JPanel form = new JPanel(new BorderLayout());
        form.add(nom, BorderLayout.NORTH);
        form.add(category, BorderLayout.CENTER);
        
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
        this.add(form, BorderLayout.WEST);
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
        
    public MenuPrincipal getLeMenu(){
        return menu;
    }
}
