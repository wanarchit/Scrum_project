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
                    String idCustomer = myForm.getFieldIdentifiant().getText();
                    idCustomer=idCustomer.toLowerCase();
                    String[] words = idCustomer.split(" ");
                    String finalIdCustomer = "";
                    for(int i=0;i<words.length;i++){
                        char[] char_table = words[i].toCharArray();
                        char_table[0]=Character.toUpperCase(char_table[0]);
                        words[i] = new String(char_table);
                        if (i!= words.length-1){
                            finalIdCustomer+=words[i]+" ";
                        }else{
                            finalIdCustomer+=words[i];
                        }
                    }

                    String pswCustomer = myForm.getFieldPassword().getText();
                    pswCustomer=pswCustomer.toLowerCase();
                    String[] words2 = pswCustomer.split(" ");
                    String finalPswCustomer = "";
                    for(int i=0;i<words2.length;i++){
                        char[] char_table = words2[i].toCharArray();
                        char_table[0]=Character.toUpperCase(char_table[0]);
                        words2[i] = new String(char_table);
                        if (i!= words2.length-1){
                            finalPswCustomer+=words2[i]+" ";
                        }else{
                            finalPswCustomer+=words2[i];
                        }
                    }

                    ArrayList<Customer2> listId = myForm.getLeMenuP().getListCustomer();
                    boolean idValidate = true;
                    for(Customer2 cust : listId){
                        if (cust.getLogin().equals(finalIdCustomer)){
                            if(cust.getPassword().equals(finalPswCustomer)){
                                idValidate = false;
                            }
                        }
                    }

                    if (idValidate){
                        JOptionPane boiteDial = new JOptionPane();
                        boiteDial.showMessageDialog(null, "The customer is connected", "Connexion of customer", JOptionPane.INFORMATION_MESSAGE);
                         myForm.getLeMenuP().afficheMenuPrincipal();
                    }else{
                        JOptionPane boiteDial = new JOptionPane();
                        boiteDial.showMessageDialog(null, "Identifiant or password is wrong", "Connexion of customer", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
        }else if(e.getSource().equals(myForm.getButRetour())){
            myForm.getLeMenuP().afficheMenuPrincipal();
        }
    }
  
  
}
