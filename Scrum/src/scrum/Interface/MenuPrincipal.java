package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.Controleur.CtrlMenuPrincipal;
import scrum.Scrum;
import scrum.noyau.Customer2;
import scrum.noyau.Order;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Paul
 */
public class MenuPrincipal extends JPanel{
    
    private Scrum fenetreMain;
    private JButton butFormCustomer;
    private JButton butFormOrder;
    private JButton butFormSpecie;
    private JButton butFormCategory;
    private CtrlMenuPrincipal controleur;
    
    private ArrayList<Customer2> listCustomer;
    private ArrayList<Order> listOrder;
    private ArrayList<Specie> listSpecie;
    private ArrayList<SpecieCategory> listCategory;
    
    public MenuPrincipal(Scrum laFenetre){
        fenetreMain = laFenetre;
        controleur = new CtrlMenuPrincipal(this);
        
        // Import of data
        listCustomer = new ArrayList();
        
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
        
        this.setLayout(new GridLayout(5,1));
        this.add(textMenu);
        this.add(butFormCustomer);
        this.add(butFormOrder);
        this.add(butFormSpecie);
        this.add(butFormCategory);
        
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
        // METTRE NEW FORM ORDER
        //fenetreMain.setContentPane(newForm);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheFormSpecie(){
        // METTRE NEW FORM SPECIES
        //fenetreMain.setContentPane(newForm);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    public void afficheFormCategory(){
        // METTRE NEW FORM CATEGORY
        //fenetreMain.setContentPane(newForm);
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
}
