/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import scrum.Interface.FormCustomerConnexion;
import scrum.noyau.Customer2;

/**
 *
 * @author Jennifer
 */
public class CtrlFormCustomerConnexion implements ActionListener
 
{
  private FormCustomerConnexion myForm; 
  public CtrlFormCustomerConnexion (FormCustomerConnexion form)
  {
      myForm = form; 
  }
  
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButValid())){
            if(myForm.getFieldIdentifiant().getText().isEmpty()){
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The customer identifiant field is empty", "Create customer", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(myForm.getFieldPassword().getText().isEmpty()){
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "The customer password field is empty", "Create customer", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    
                ArrayList<Customer2> listId = myForm.getLeMenuP().getListCustomer();
                    boolean idValidate = false;
                    String finalIdCustomer;
                    String finalPswCustomer;
                    
                    finalIdCustomer = myForm.getFieldIdentifiant().getText();
                    finalPswCustomer = myForm.getFieldPassword().getText();
                    for(Customer2 cust : listId){
                        if (cust.getLogin().equals(finalIdCustomer)){
                            if(cust.getPassword().equals(finalPswCustomer)){
                                idValidate = true;
                            }
                        }
                    }

                    if (idValidate){
                        JOptionPane boiteDial = new JOptionPane();
                        boiteDial.showMessageDialog(null, "The customer is connected", "Connexion of customer", JOptionPane.INFORMATION_MESSAGE);
                         myForm.getLeMenuP().afficheMenuPrincipal2();
                    }else{
                        JOptionPane boiteDial = new JOptionPane();
                        boiteDial.showMessageDialog(null, "Identifiant or password is wrong", "Connexion of customer", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
        }else if(e.getSource().equals(myForm.getButRetour())){
            myForm.getLeMenuP().afficheMenuPrincipal2();
        }
    }
  
  
}
