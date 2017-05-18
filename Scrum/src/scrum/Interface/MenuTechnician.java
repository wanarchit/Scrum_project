/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Interface;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.Controleur.CtrlMenuSecretary;
import scrum.Controleur.CtrlMenuTechnician;
import scrum.Scrum;
import scrum.noyau.Customer;
import scrum.noyau.Customer2;
import scrum.noyau.IntegrationTest;
import scrum.noyau.Order;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Jennifer
 */
public class MenuTechnician extends JPanel {
        	
    private IntegrationTest model;
    
    private MenuPrincipal2 menu2; 
    private Scrum fenetreMain;
    private JButton butFormMicroplaque;
    private JButton butFormFirstRead;
    private JButton butRetour;
    private CtrlMenuTechnician controleur;

    public MenuTechnician (MenuPrincipal2 menu){
        menu2 = menu;
        model = new IntegrationTest();
        this.fenetreMain = menu.getFenetreMain();
        controleur = new CtrlMenuTechnician(this);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        
        JLabel textMenu = new JLabel("STechnician menu");
        textMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butFormMicroplaque = new JButton ("Create Microplaque");
        butFormMicroplaque.addActionListener(controleur);
        butFormFirstRead = new JButton ("First Read");
        butFormFirstRead.addActionListener(controleur);
        panButRetour.add(butRetour);
        
        this.setLayout(new GridLayout(5,1));
        this.add(textMenu);
        this.add(butFormMicroplaque);
        this.add(butFormFirstRead);
        this.add(panButRetour);

        
    }
    public Scrum getFenetreMain(){
        return fenetreMain;
    }
    
    public JButton getbutFormMicroplaque(){
        return butFormMicroplaque;
    }
    
    public JButton getbutFormFirstRead(){
        return butFormFirstRead;
    }
    
   
    
  public void afficheFormMicroplaque(){
       FormMicroplaque formMicroP = new FormMicroplaque(this);
       fenetreMain.setContentPane(formMicroP);
        fenetreMain.repaint();
       fenetreMain.revalidate();
   }
    
    public void afficheFormFirstRead() {
   	FormFirstRead formFirstR = new FormFirstRead(this);
        fenetreMain.setContentPane(formFirstR);
        fenetreMain.repaint();
        fenetreMain.revalidate();
  }
    

          public void afficheMenuTechnician(){
        fenetreMain.setContentPane(this);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
        public MenuPrincipal2 getLeMenu2(){
        return menu2;
    }
         public JButton getButRetour(){
        return butRetour;
    }
         public JButton getButFormMicroplaque(){
        return butFormMicroplaque;
    }
          public JButton getButFormFirstRead(){
    	return butFormFirstRead;
    }
          
          
     
 
}
