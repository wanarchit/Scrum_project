package scrum.Interface;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import scrum.Scrum;
import scrum.Controleur.CtrlMenuPrincipal;
import scrum.noyau.Analysis;
import scrum.noyau.Customer;
import scrum.noyau.Customer2;
import scrum.noyau.IntegrationTest;
import scrum.noyau.Order;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Paul
 */
public class MenuPrincipal extends JPanel{
	
    private IntegrationTest model;
    
    private Scrum fenetreMain;
    private JButton butFormCustomer;
    private JButton butFormOrder;
    private JButton butFormSpecie;
    private JButton butFormCategory;
    private JButton butExploreOrder;
    private JButton butFormScrapie;
    private JButton butFormCustomerConnexion;
    private JButton butFormMicroplaque;
    
    private CtrlMenuPrincipal controleur;
    
    private ArrayList<Customer2> listCustomer;
    private ArrayList<Analysis> listAnalysis;
    private ArrayList<Order> listOrder;
    private ArrayList<Specie> listSpecie;
    private ArrayList<SpecieCategory> listCategory;

	private JButton butFormSexingTest;
    
    
    public MenuPrincipal(Scrum laFenetre){
    	model = new IntegrationTest();
    	
        fenetreMain = laFenetre;
        controleur = new CtrlMenuPrincipal(this);
        
        // Import of data
        listCustomer = model.getCustomer();
        listOrder = new ArrayList();
        listSpecie = new ArrayList();
        listAnalysis = model.getAnalyses();
        listCategory = model.getCategory();
                
        JLabel textMenu = new JLabel("Main menu");
        textMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butFormCustomer = new JButton("Create a customer");
        butFormCustomer.addActionListener(controleur);
        butFormOrder = new JButton("Create an order");
        butFormOrder.addActionListener(controleur);
        butFormSpecie = new JButton("Create a specie");
        butFormSpecie.addActionListener(controleur);
        butFormCategory = new JButton("Create a category");
        butFormCategory.addActionListener(controleur);
        butExploreOrder = new JButton("Explore an order");
        butExploreOrder.addActionListener(controleur);
        butFormScrapie = new JButton("Create Scrapie Test");
        butFormScrapie.addActionListener(controleur);
        butFormCustomerConnexion = new JButton ("Connexion Customer");
        butFormCustomerConnexion.addActionListener(controleur);
        butFormMicroplaque = new JButton ("Create Microplaque");
        butFormMicroplaque.addActionListener(controleur);
        butFormSexingTest = new JButton ("Create Sexing Test");
        butFormSexingTest.addActionListener(controleur);
                
        this.setLayout(new GridLayout(7,1));
        this.add(textMenu);
        this.add(butFormCustomer);
        this.add(butFormOrder);
        this.add(butFormSpecie);
        this.add(butFormCategory);
        this.add(butExploreOrder);
        this.add(butFormScrapie);
        this.add(butFormCustomerConnexion);
        this.add(butFormMicroplaque);
        this.add(butFormSexingTest);
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
    
    public JButton getButExploreOrder(){
        return butExploreOrder;
    }
    
    public JButton getButFormScrapie(){
        return butFormScrapie;
    }
    
    public JButton getButFormCustomerConnexion(){
        return butFormCustomerConnexion;
    }
    
    public JButton getButFormMicroplaque(){
        return butFormMicroplaque;
    }
    
    public JButton getButFormSexingTest(){
    	return butFormSexingTest;
    }
    
    public void afficheFormCustomer(){
        FormCustomer newForm = new FormCustomer(this);
        fenetreMain.setContentPane(newForm);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheFormOrder(){
    	FormOrder newForm = new FormOrder(this,model.getAnalyses(),model.getCategory(),listCustomer);
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
    
    public void afficheFormConnexionCustomer(){
        FormCustomerConnexion formCusConnexion = new FormCustomerConnexion(this);
        fenetreMain.setContentPane(formCusConnexion);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheFormMicroplaque(){
        FormMicroplaque formMicroP = new FormMicroplaque(this);
        fenetreMain.setContentPane(formMicroP);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheFormSexingTest() {
    	FormCreateSexingTest formSexingTest = new FormCreateSexingTest(this);
        fenetreMain.setContentPane(formSexingTest);
        fenetreMain.repaint();
        fenetreMain.revalidate();
	}
    
    public void afficheMenuPrincipal(){
        fenetreMain.setContentPane(this);
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
    
    public void addOrder(Customer customer, Order newOrder){
    	listOrder.add(newOrder);
    	customer.addOrder(newOrder);
    }

	public void goListOrder(Customer customer) {
            new ListOrder(customer);
	}
    
}
