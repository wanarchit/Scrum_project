package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormMicroplaque;
import scrum.noyau.Order;
import scrum.noyau.Sample;

/**
 *
 * @author Delphine
 */
public class FormMicroplaque extends JPanel {

    MenuTechnician myMenu;
    CtrlFormMicroplaque controleur;
    JLabel butSample1;
    JLabel butSample2;
    JLabel butSample3;
    JLabel butSample4;
    JLabel butSample5;
    JLabel butSample6;
    JLabel butSample7;
    JLabel butSample8;
    JButton validateForm;
    JButton butRetour;
    JTextField nameMicro;
    JButton ajouter;

    public FormMicroplaque(MenuTechnician leMenu) {
        myMenu = leMenu;
        controleur = new CtrlFormMicroplaque(this);

        // Title
        JLabel headLabel = new JLabel("New Microplaque");
        headLabel.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        JLabel labName = new JLabel("Name of microplate : ");
        nameMicro = new JTextField(20);
        JPanel pan1 = new JPanel();
        pan1.add(labName);
        pan1.add(nameMicro);

        butSample1 = new JLabel ("Sample 1");
        butSample1.setBorder(border);
        butSample1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample2 = new JLabel ("Sample 2");
        butSample2.setBorder(border);
        butSample2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample3 = new JLabel ("Sample 3");
        butSample3.setBorder(border);
        butSample3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample4 = new JLabel ("Sample 4");
        butSample4.setBorder(border);
        butSample4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample5 = new JLabel ("Sample 5");
        butSample5.setBorder(border);
        butSample5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample6 = new JLabel ("Sample 6");
        butSample6.setBorder(border);
        butSample6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample7 = new JLabel ("Sample 7");
        butSample7.setBorder(border);
        butSample7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample8 = new JLabel ("Sample 8");
        butSample8.setBorder(border);
        butSample8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       
        
        JPanel panelGeneral = new JPanel (new GridBagLayout());
        GridBagConstraints centre = new GridBagConstraints();
        
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
        
        JPanel panelDroite = new JPanel(new BorderLayout());
        panelDroite.add(pan1, BorderLayout.NORTH);
        panelDroite.add(panelGeneral, BorderLayout.CENTER);
        
        
        //Partie gauche
        JLabel lesSamp = new JLabel("The samples");
        JComboBox listeSamp = new JComboBox();
        for (Order or : myMenu.getLeMenu2().getListOrder()){
            for (Sample samp : or.getSamples()){
                listeSamp.addItem(samp.getIdSample());
            }
        }
        
        ajouter = new JButton("Add the sample");

        JPanel panelGauche = new JPanel (new BorderLayout());
        panelGauche.add(lesSamp, BorderLayout.NORTH);
        panelGauche.add(listeSamp, BorderLayout.CENTER);    
        panelGauche.add(ajouter, BorderLayout.SOUTH); 
        
        
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
        this.add(panelDroite,BorderLayout.CENTER);
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panButtons,BorderLayout.SOUTH);
    }
    
    public MenuTechnician getLeMenuP(){
        return myMenu;
    }
    
    public JButton getButValid(){
        return validateForm;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
    
    public JLabel getButS1(){
        return butSample1;
    }    
    
    public JLabel getButS2(){
        return butSample2;
    }    
    
    public JLabel getButS3(){
        return butSample3;
    }    
    
    public JLabel getButS4(){
        return butSample4;
    }    
    
    public JLabel getButS5(){
        return butSample5;
    }    
    
    public JLabel getButS6(){
        return butSample6;
    }    
    
    public JLabel getButS7(){
        return butSample7;
    }    
    
    public JLabel getButS8(){
        return butSample8;
    }  
}
