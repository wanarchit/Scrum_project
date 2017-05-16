
package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import scrum.Controleur.CtrlFormExploreOrder;
import scrum.noyau.Customer2;
/**
 *
 * @author SERAZIN
 */
public class FormExploreOrder extends JPanel {
    
    
    MenuPrincipal myMenu;
    private CtrlFormExploreOrder controleur; 
    private JComboBox<Customer2> customer;
    private ArrayList<Customer2> listCustomers;
    private JButton validate;
    private JButton retour;
    
    
    
    public FormExploreOrder (MenuPrincipal menu){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        myMenu = menu;
        controleur = new CtrlFormExploreOrder(this);
        this.listCustomers = listCustomers;
        
        customer = new JComboBox<Customer2>();
        
        JLabel labelTitre = new JLabel ("Explore order"); 
        labelTitre.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panelComboCustomer = new JPanel();
        panelComboCustomer.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelComboCustomer.add(new JLabel (" Customers "));
        panelComboCustomer.add(customer);
        
        JPanel panButValider = new JPanel();
        validate = new JButton ("Valider");
        validate.setPreferredSize(new Dimension(200,20));
        validate.addActionListener(controleur);
        panButValider.add(validate);
        
        JPanel panButRetour = new JPanel();
        retour = new JButton("Retour");
        retour.addActionListener(controleur);
        panButRetour.add(retour);  
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(retour);
        panButtons.add(validate);
        
        this.add(labelTitre);
        this.add(panelComboCustomer);
        this.add(panButtons);
        
    }
    
    public MenuPrincipal getMenuPrincipal(){
        return myMenu;
    }
    
    public JButton getValidate(){
        return validate;
    }
    
    public JButton getRetour(){
        return retour;
    }
    
    
}
