package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.Controleur.CtrlFormMicroplaque;

/**
 *
 * @author Delphine
 */
public class FormMicroplaque extends JPanel {

    MenuPrincipal myMenu;
    CtrlFormMicroplaque controleur;
    JButton butSample1;
    JButton butSample2;
    JButton butSample3;
    JButton butSample4;
    JButton butSample5;
    JButton butSample6;
    JButton butSample7;
    JButton butSample8;
    JButton validateForm;
    JButton butRetour;

    public FormMicroplaque(MenuPrincipal leMenu) {
        myMenu = leMenu;
        controleur = new CtrlFormMicroplaque(this);

        // Title
        JLabel headLabel = new JLabel("New Microplaque");
        headLabel.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        butSample1 = new JButton ("Sample 1");
        butSample2 = new JButton ("Sample 2");
        butSample3 = new JButton ("Sample 3");
        butSample4 = new JButton ("Sample 4");
        butSample5 = new JButton ("Sample 5");
        butSample6 = new JButton ("Sample 6");
        butSample7 = new JButton ("Sample 7");
        butSample8 = new JButton ("Sample 8");
        
        JPanel panelGeneral = new JPanel (new GridBagLayout());
        GridBagConstraints centre = new GridBagConstraints();
        //centre.anchor = GridBagConstraints.CENTER;
        
        centre.gridx = 0;
        centre.gridy = 0;
        butSample1.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample1,centre);
        
        centre.gridx = 1;
        centre.gridy = 0; 
        butSample2.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample2,centre);
        
        centre.gridx = 2;
        centre.gridy = 0;
        butSample3.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample3,centre);
        
        centre.gridx = 3;
        centre.gridy = 0;    
        butSample4.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample4,centre);
        
        centre.gridx = 0;
        centre.gridy = 1;  
        butSample5.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample5,centre);
        
        centre.gridx = 1;
        centre.gridy = 1;   
        butSample6.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample6,centre);
        
        centre.gridx = 2;
        centre.gridy = 1;  
        butSample7.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample7,centre);
        
        centre.gridx = 3;
        centre.gridy = 1;    
        butSample8.setPreferredSize(new Dimension(100,75));
        panelGeneral.add(butSample8,centre);
        
        
        // Creation of the button to return to the main menu and the validate button
        JPanel panButValid = new JPanel();
        validateForm = new JButton("Valider");
        validateForm.addActionListener(controleur);
        panButValid.add(validateForm);

        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);

        JPanel panButtons = new JPanel(new GridLayout(1, 2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.setLayout(new BorderLayout());
        this.add(headLabel,BorderLayout.NORTH);
        this.add(panelGeneral,BorderLayout.CENTER);
        this.add(panButtons,BorderLayout.SOUTH);
    }
    
    public MenuPrincipal getLeMenuP(){
        return myMenu;
    }
    
    public JButton getButValid(){
        return validateForm;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
}
