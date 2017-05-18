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
public class MenuSecretary extends JPanel {
        	
    private IntegrationTest model;
    
    private MenuPrincipal2 menu2; 
    private Scrum fenetreMain;
    private JButton butFormCustomer;
    private JButton butFormOrder;
    private JButton butFormSpecie;
    private JButton butFormCategory;
    private JButton butRetour;
    private CtrlMenuSecretary controleur;
    
    //private ArrayList<Customer2> listCustomer;
    //private ArrayList<Order> listOrder;
    //private ArrayList<Specie> listSpecie;
    //private ArrayList<SpecieCategory> listCategory;
    
    public MenuSecretary (MenuPrincipal2 menu){
        menu2 = menu;
        model = new IntegrationTest();
        this.fenetreMain = menu.getFenetreMain();
        controleur = new CtrlMenuSecretary(this);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        
        JLabel textMenu = new JLabel("Secretary menu");
        textMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butFormCustomer = new JButton("Create a customer");
        butFormCustomer.addActionListener(controleur);
        butFormOrder = new JButton("Create an order");
        butFormOrder.addActionListener(controleur);
        butFormSpecie = new JButton("Create a specie");
        butFormSpecie.addActionListener(controleur);
        butFormCategory = new JButton("Create a category");
        butFormCategory.addActionListener(controleur);
        
        panButRetour.add(butRetour);
        
        this.setLayout(new GridLayout(5,1));
        this.add(textMenu);
        this.add(butFormCustomer);
        this.add(butFormOrder);
        this.add(butFormSpecie);
        this.add(butFormCategory);
        this.add(panButRetour);

        
    }
    public Scrum getFenetreMain(){
        return fenetreMain;
    }
    
    public JButton getButFormCustomer(){
        return butFormCustomer;
    }
    
    public JButton getButFormOrder(){
        return butFormOrder;
    }
    
    public JButton getButFormSpecie(){
        return butFormSpecie;
    }
    
    public JButton getButFormCategory(){
        return butFormCategory;
    }
    
    public void afficheFormCustomer(){
        FormCustomer newForm = new FormCustomer(this);
        fenetreMain.setContentPane(newForm);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheFormOrder(){
    	FormOrder newForm = new FormOrder(this);
        fenetreMain.setContentPane(newForm);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheFormSpecie(){
        FormSpecies formSpec = new FormSpecies(this);
        fenetreMain.setContentPane(formSpec);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    public void afficheFormCategory(){
        FormCategory formCat = new FormCategory(this);
        fenetreMain.setContentPane(formCat);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
//      public void addOrder(Customer customer, Order newOrder){
//        ArrayList<Order> listOrder = new ArrayList<Order> ();
//        listOrder = menu2.getListOrder();
//    	listOrder.add(newOrder);
//    	customer.addOrder(newOrder);
//    }

	public void goListOrder(Customer customer) {
            new ListOrder(customer);
	}
          public void afficheMenuSecretary(){
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
