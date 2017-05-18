/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormCustomer;
import scrum.Controleur.CtrlFormCustomerConnexion;

/**
 *
 * @author Jennifer
 */
public class FormCustomerConnexion extends JPanel {
    MenuPrincipal2 myMenu;
    private CtrlFormCustomerConnexion controleur;
    private JTextField idCustomer;
    private JPasswordField passwordCustomer;
    private JButton butValidate;
    private JButton butRetour;
    
    public FormCustomerConnexion (MenuPrincipal2 leMenu)
    {
        myMenu = leMenu;
        controleur = new CtrlFormCustomerConnexion(this);
        
        JLabel headLabel = new JLabel ("Connexion Customer");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JPanel panForm = new JPanel( new BorderLayout());
        JPanel panCenterForm = new JPanel( new GridBagLayout());
        
        JPanel panId = new JPanel();
        JPanel panPassword = new JPanel();
        
        JPanel panIdField = new JPanel();
        JPanel panPasswordField = new JPanel();
        
        idCustomer= new JTextField(20);
        panId.add(new JLabel("Identifiant :  "));
        panIdField.add(idCustomer);
       
        passwordCustomer= new JPasswordField(20);
        panPassword.add(new JLabel("Password :  "));
        panPasswordField.add(passwordCustomer);
        
        GridBagConstraints RightCenter = new GridBagConstraints();
        RightCenter.anchor = GridBagConstraints.LINE_END;
        RightCenter.gridx = 0;
        RightCenter.gridy = 0;
        
        GridBagConstraints LeftCenter = new GridBagConstraints();
        LeftCenter.anchor = GridBagConstraints.LINE_START;
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 0;
        
        panCenterForm.add(panId, RightCenter);
        panCenterForm.add(panIdField, LeftCenter);
        RightCenter.gridx = 0;
        RightCenter.gridy = 1;
        panCenterForm.add(panPassword, RightCenter);
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 1;
        panCenterForm.add(panPasswordField,LeftCenter);
        
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
    
    public MenuPrincipal2 getLeMenuP(){
        return myMenu;
    }
    
    public JTextField getFieldIdentifiant(){
        return idCustomer;
    }
    
    public JTextField getFieldPassword(){
        return passwordCustomer;
    }
    
    public JButton getButValid(){
        return butValidate;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
        
    }
    

