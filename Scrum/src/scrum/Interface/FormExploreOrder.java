
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
import scrum.noyau.Customer;
import scrum.noyau.Customer2;
/**
 *
 * @author SERAZIN
 */
public class FormExploreOrder extends JPanel {
    
    
    MenuPrincipal myMenu;
    private CtrlFormExploreOrder controleur; 
    private JComboBox<Customer2> customer;
    private JButton validate;
    private JButton retour;
    
    
    
    public FormExploreOrder (MenuPrincipal menu){
        
        myMenu = menu;
        controleur = new CtrlFormExploreOrder(this);
        
        customer = new JComboBox<Customer2>();
        for (Customer2 customer2 : myMenu.getListCustomer()) {
        	customer.addItem(customer2);
		}
        
        JLabel labelTitre = new JLabel ("Explore order"); 
        labelTitre.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panelComboCustomer = new JPanel();
        panelComboCustomer.add(new JLabel (" Customers "));
        panelComboCustomer.add(customer);
        
        JPanel panButValider = new JPanel();
        validate = new JButton ("Valider");
        validate.addActionListener(controleur);
        panButValider.add(validate);
        
        JPanel panButRetour = new JPanel();
        retour = new JButton("Retour");
        retour.addActionListener(controleur);
        panButRetour.add(retour);  
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValider);
        
        this.setLayout(new BorderLayout());
        this.add(labelTitre, BorderLayout.NORTH);
        this.add(panelComboCustomer, BorderLayout.CENTER);
        this.add(panButtons, BorderLayout.SOUTH);
        
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

	public void validation() {
		myMenu.goListOrder((Customer) customer.getSelectedItem());
	}
    
    
}
