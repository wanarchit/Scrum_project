package scrum.Interface;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.LINE_END;
import java.awt.Dimension;
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
    
    MenuSecretary myMenu;
    private CtrlFormCustomer controleur;
    private JTextField nameCustomer;
    private JTextField cityCustomer;
    private JTextField loginCustomer;
    private JTextField mdpCustomer;
    private JButton butValidate;
    private JButton butRetour;
    
    public FormCustomer(MenuSecretary leMenu){
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
        JPanel panLogin = new JPanel ();
        JPanel panMdp = new JPanel ();
        
        JPanel panCorpoField = new JPanel ();
        JPanel panCityField = new JPanel ();
        JPanel panLoginField = new JPanel ();
        JPanel panMdpField = new JPanel ();
        
        
        // Customer
        nameCustomer = new JTextField(20);
        panCorpo.add(new JLabel("Corporation :  "));
        panCorpoField.add(nameCustomer);
        
        cityCustomer = new JTextField(20);
        panCity.add(new JLabel("City :  "));
        panCityField.add(cityCustomer);
        
        loginCustomer = new JTextField(20);
        panLogin.add(new JLabel("Login :  "));
        panLoginField.add(loginCustomer);
        
        mdpCustomer = new JTextField(20);
        panMdp.add(new JLabel("Password:  "));
        panMdpField.add(mdpCustomer);
        
        GridBagConstraints RightCenter = new GridBagConstraints();
        RightCenter.anchor = GridBagConstraints.LINE_END;
        RightCenter.gridx = 0;
        RightCenter.gridy = 0;
        
        GridBagConstraints LeftCenter = new GridBagConstraints();
        LeftCenter.anchor = GridBagConstraints.LINE_START;
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 0;
      
        // Ajout ligne 1
        panCenterForm.add(panCorpo, RightCenter);
        panCenterForm.add(panCorpoField, LeftCenter);
        // Ajout ligne 2
        RightCenter.gridx = 0;
        RightCenter.gridy = 1;
        panCenterForm.add(panCity, RightCenter);
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 1;
        panCenterForm.add(panCityField,LeftCenter);
        // Ajout ligne 3
        RightCenter.gridx = 0;
        RightCenter.gridy = 2;
        panCenterForm.add(panLogin, RightCenter);
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 2;
        panCenterForm.add(panLoginField,LeftCenter);
        // Ajout ligne 4
        RightCenter.gridx = 0;
        RightCenter.gridy = 3;
        panCenterForm.add(panMdp, RightCenter);
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 3;
        panCenterForm.add(panMdpField,LeftCenter);
        
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
    
    public MenuSecretary getLeMenuP(){
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
    
    public JTextField getLogin(){
        return loginCustomer;
    }
    
    public JTextField getPassword(){
        return mdpCustomer;
    }
}
