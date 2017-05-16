/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormScrapie;
import scrum.noyau.Specie;

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
    private JComboBox<Specie> species;
    
    public FormScrapie(MenuPrincipal leMenu){
        
        
        
        species = new JComboBox<Specie>();
        species.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JComboBox combo = (JComboBox)e.getSource();
                    Specie specieChoose = (Specie) combo.getSelectedItem();
                    //FormOrder.this.majAnalysis(specieChoose);
                    }
                }            
        );
    }
    
}
