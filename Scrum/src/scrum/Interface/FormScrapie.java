package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormScrapie;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class FormScrapie extends JPanel {
    MenuPrincipal myMenu;
    private CtrlFormScrapie controleur;
    private JTextField position;
    private JTextField value;
    private JButton butPeak;
    private JButton butValidate;
    private JButton retour;
    private JButton valider;
    private JComboBox<Specie> species;
    private JLabel labelRes;
    private JLabel headTitle;
    
    public FormScrapie(MenuPrincipal leMenu){
        headTitle= new JLabel("Create a Scrapie Test");
        headTitle.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JPanel formScrapie = new JPanel(new BorderLayout());
        labelRes= new JLabel("Results");
        labelRes.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        labelRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        formScrapie.add(labelRes);
   
        species = new JComboBox();
        for (Specie diffSpecies : myMenu.getListSpecie()) {
            species.addItem(diffSpecies);
        }
        formScrapie.add(species);
        
        position = new JTextField();
        position.setPreferredSize(new Dimension(50, 50));
        formScrapie.add(position);
        
        value = new JTextField();
        value.setPreferredSize(new Dimension(50, 50));
        formScrapie.add(value);

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
        this.add(formScrapie, BorderLayout.WEST);
        this.add(panButtons, BorderLayout.SOUTH);
    }
    
    public JTextField getPosition(){
        return position;
    }
    
    public JTextField getValue(){
        return value;
    }
    
    public Specie getValCombo(){
        return species.getItemAt(species.getSelectedIndex());
    }
    
    public JButton getButValider(){
        return valider;
    }
    
    public JButton getButRetour(){
        return retour;
    }
        
    public MenuPrincipal getLeMenu(){
        return myMenu;
    }
    
}
