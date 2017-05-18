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

import scrum.Scrum;
import scrum.Controleur.CtrlMenuPrincipal2;
import scrum.noyau.Analysis;
import scrum.noyau.Customer;
import scrum.noyau.Customer2;
import scrum.noyau.IntegrationTest;
import scrum.noyau.Microplaque;
import scrum.noyau.Order;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Jennifer
 */
public class MenuPrincipal2 extends JPanel {


    private IntegrationTest model;
    
    private Scrum fenetreMain;
    
    private JButton butSecretary,butTehcnician,butValidator,butCustomer;
    
    private CtrlMenuPrincipal2 controleur;
    
    private ArrayList<Customer2> listCustomer;
    private ArrayList<Analysis> listAnalysis;
    private ArrayList<Order> listOrder;
    private ArrayList<Specie> listSpecie;
    private ArrayList<SpecieCategory> listCategory;
    private ArrayList<Microplaque> listMicroplaques;
    
    
    public MenuPrincipal2(Scrum laFenetre){
    	model = new IntegrationTest();
    	
        fenetreMain = laFenetre;
        controleur = new CtrlMenuPrincipal2(this);
        
        // Import of data
        listCustomer = new ArrayList <Customer2> (model.getCustomer());
        listOrder = new ArrayList();
        listSpecie = new ArrayList();
        listCategory = new ArrayList <SpecieCategory> (model.getCategory());
        listMicroplaques = new ArrayList();
        listAnalysis = model.getAnalyses();
                
        JLabel textMenu = new JLabel("Main menu");
        textMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSecretary = new JButton("Secretary : ");
        butSecretary.addActionListener(controleur);
        butTehcnician = new JButton("Technician : ");
        butTehcnician.addActionListener(controleur);
        butValidator = new JButton("Validator : ");
        butValidator.addActionListener(controleur);
        butCustomer = new JButton("Customer : ");
        butCustomer.addActionListener(controleur);

                
        this.setLayout(new GridLayout(5,1));
        this.add(textMenu);
        this.add(butSecretary);
        this.add(butTehcnician);
        this.add(butValidator);
        this.add(butCustomer);
    }
    
    public Scrum getFenetreMain(){
        return fenetreMain;
    }
    
    public JButton getButSecretary(){
        return butSecretary;
    }
    
    public JButton getButTechnician(){
        return butTehcnician;
    }
    
    public JButton getButValidator(){
        return butValidator;
    }
    
    public JButton getButCustomer(){
        return butCustomer;
    }
    
    public void afficheMenuSecretary(){
      MenuSecretary menu = new MenuSecretary(this);
      fenetreMain.setContentPane(menu);
      fenetreMain.repaint();
      fenetreMain.revalidate();
    }
       public void afficheMenuTechnician(){
      MenuTechnician menu = new MenuTechnician(this);
      fenetreMain.setContentPane(menu);
      fenetreMain.repaint();
      fenetreMain.revalidate();
    }
        public void afficheMenuValidator(){
        MenuValidator menu = new MenuValidator(this);
        fenetreMain.setContentPane(menu);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
        
        public void afficheFormConnexionCustomer(){
        FormCustomerConnexion formCusConnexion = new FormCustomerConnexion(this);
       fenetreMain.setContentPane(formCusConnexion);
        fenetreMain.repaint();
       fenetreMain.revalidate();
   }
    
   public ArrayList<Customer2> getListCustomer(){
        return listCustomer;
    }
    
    public ArrayList<Order> getListOrder(){
        return listOrder;
    }
    
    public ArrayList<Specie> getListSpecie(){
        return listSpecie;
    }
    
    public ArrayList<SpecieCategory> getListCategory(){
        return listCategory;
    }
    
    public ArrayList<Analysis> getListAnalysis(){
    	return listAnalysis;
    }
    
    public ArrayList<Microplaque> getListMicroplaques(){
    	return listMicroplaques;
    }
    
    public void addOrder(Customer customer, Order newOrder){
    	listOrder.add(newOrder);
    	customer.addOrder(newOrder);
    }

    public void goListOrder(Customer customer) {
        new ListOrder(customer);
    }
    
    public void afficheMenuPrincipal2(){
        
        System.out.println("Les customers:");
        for(Customer2 cus :listCustomer ){
            System.out.println(cus.getName());
        }
        System.out.println("Les Order:");
        for(Order ord :listOrder ){
            System.out.println(ord.getId());
        }
        System.out.println("Les Microplaques:");
        for(Microplaque mp :listMicroplaques ){
            System.out.println(mp.getName());
        }
        
        //System.out.println(listSpecie);
        //System.out.println(listCategory);
       // System.out.println(listMicroplaques);
        //System.out.println(listAnalysis);
      fenetreMain.setContentPane(this);
      fenetreMain.repaint();
      fenetreMain.revalidate();
    }
}
