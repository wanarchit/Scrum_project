package scrum.Interface;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.LINE_END;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        
        // Title
        JLabel headLabel = new JLabel("New Customer");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // Panel form
        
        JPanel panForm = new JPanel(new BorderLayout());
        JPanel panCenterForm = new JPanel (new GridBagLayout());
         
      
        JPanel panCorpo = new JPanel ();
        JPanel panCity = new JPanel ();
        
        JPanel panCorpoField = new JPanel ();
        JPanel panCityField = new JPanel ();
        
        
        // Customer
        nameCustomer = new JTextField(20);
        panCorpo.add(new JLabel("Corporation :  "));
        panCorpoField.add(nameCustomer);
        
        cityCustomer = new JTextField(20);
        panCity.add(new JLabel("City :  "));
        panCityField.add(cityCustomer);
        
        GridBagConstraints RightCenter = new GridBagConstraints();
        RightCenter.anchor = GridBagConstraints.LINE_END;
        RightCenter.gridx = 0;
        RightCenter.gridy = 0;
        
        GridBagConstraints LeftCenter = new GridBagConstraints();
        LeftCenter.anchor = GridBagConstraints.LINE_START;
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 0;
      

        panCenterForm.add(panCorpo, RightCenter);
        panCenterForm.add(panCorpoField, LeftCenter);
        RightCenter.gridx = 0;
        RightCenter.gridy = 1;
        panCenterForm.add(panCity, RightCenter);
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 1;
        panCenterForm.add(panCityField,LeftCenter);
        
        panForm.add(panCenterForm,BorderLayout.CENTER);


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
