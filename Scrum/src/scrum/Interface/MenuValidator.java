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
import scrum.Controleur.CtrlMenuValidator;
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
public class MenuValidator extends JPanel {
        	
    private IntegrationTest model;
    
    private MenuPrincipal2 menu2; 
    private Scrum fenetreMain;
     private JButton butExploreOrder;
    private JButton butFormScrapie;
    private JButton butFormSexingTest;
    private JButton butRetour;
    private CtrlMenuValidator controleur;
    

    
    public MenuValidator (MenuPrincipal2 menu){
        menu2 = menu;
        model = new IntegrationTest();
        this.fenetreMain = menu.getFenetreMain();
        controleur = new CtrlMenuValidator(this);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        
        JLabel textMenu = new JLabel("Validator menu");
        textMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butExploreOrder = new JButton("Explore an order");
        butExploreOrder.addActionListener(controleur);
        butFormScrapie = new JButton("Create Scrapie Test");
        butFormScrapie.addActionListener(controleur);
        butFormSexingTest = new JButton ("Create Sexing Test");
        butFormSexingTest.addActionListener(controleur);
  
        
        panButRetour.add(butRetour);
        
        this.setLayout(new GridLayout(5,1));
        this.add(textMenu);
        this.add(butExploreOrder);
        this.add(butFormScrapie);
        this.add(butFormSexingTest);
        this.add(panButRetour);

        
    }
    public Scrum getFenetreMain(){
        return fenetreMain;
    }
    
    public JButton getbutExploreOrder(){
        return butExploreOrder;
    }
    
    public JButton getbutFormScrapie(){
        return butFormScrapie;
    }
    
    public JButton getbutFormSexingTest(){
        return butFormSexingTest;
    }
    
      public void afficheExploreOrder(){
        FormExploreOrder expl = new FormExploreOrder(this);
       fenetreMain.setContentPane(expl);
        fenetreMain.repaint();
       fenetreMain.revalidate();
   }
        public void afficheFormScrapie(){
       FormScrapie scrapie = new FormScrapie(this);
       fenetreMain.setContentPane(scrapie);
        fenetreMain.repaint();
       fenetreMain.revalidate();
   }
           public void afficheFormSexingTest() {
   	FormCreateSexingTest formSexingTest = new FormCreateSexingTest(this);
      fenetreMain.setContentPane(formSexingTest);
       fenetreMain.repaint();
        fenetreMain.revalidate();
   }
             public void afficheMenuValidator(){
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
     
 
}
