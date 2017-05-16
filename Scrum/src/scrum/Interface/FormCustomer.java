package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormCustomer;

/**
 *
 * @author Paul
 */
public class FormCustomer extends JPanel{
    
    MenuPrincipal myMenu;
    private CtrlFormCustomer controleur;
    private JTextField nameCustomer;
    private JTextField cityCustomer;
    private JButton butValidate;
    private JButton butRetour;
    
    public FormCustomer(MenuPrincipal leMenu){
        myMenu = leMenu;
        controleur = new CtrlFormCustomer(this);
        
        JLabel headLabel = new JLabel("New Customer");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        nameCustomer = new JTextField(20);
        JPanel panField1 = new JPanel();
        panField1.add(new JLabel("Corporation :  "));
        panField1.add(nameCustomer);
        
        cityCustomer = new JTextField(20);
        JPanel panField2 = new JPanel();
        panField2.add(new JLabel("City :  "));
        panField2.add(cityCustomer);
        
        JPanel panForm = new JPanel(new GridLayout(2,1));
        panForm.add(panField1);
        panForm.add(panField2);
        
        JPanel panButValid = new JPanel();
        butValidate = new JButton("Validation");
        butValidate.addActionListener(controleur);
        panButValid.add(butValidate);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.setLayout(new BorderLayout());
        this.add(headLabel,BorderLayout.NORTH);
        this.add(panForm,BorderLayout.CENTER);
        this.add(panButtons,BorderLayout.SOUTH);
        
    }
    
    public MenuPrincipal getLeMenuP(){
        return myMenu;
    }
    
    public JTextField getFieldName(){
        return nameCustomer;
    }
    
    public JTextField getFieldCity(){
        return cityCustomer;
    }
    
    public JButton getButValid(){
        return butValidate;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
}
