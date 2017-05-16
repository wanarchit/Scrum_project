package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import scrum.Interface.FormCustomer;
import scrum.noyau.Customer2;

/**
 *
 * @author Paul
 */
public class CtrlFormCustomer implements ActionListener {

    private FormCustomer myForm;
    
    public CtrlFormCustomer(FormCustomer form){
        myForm = form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButValid())){
            String CorpName = myForm.getFieldName().getText();
            CorpName=CorpName.toLowerCase();
            String[] words = CorpName.split(" ");
            String finalCorpName = "";
            for(int i=0;i<words.length;i++){
                char[] char_table = words[i].toCharArray();
                char_table[0]=Character.toUpperCase(char_table[0]);
                words[i] = new String(char_table);
                if (i!= words.length-1){
                    finalCorpName+=words[i]+" ";
                }else{
                    finalCorpName+=words[i];
                }
            }
            
            String CityName = myForm.getFieldCity().getText();
            CityName=CityName.toLowerCase();
            String[] words2 = CityName.split(" ");
            String finalCityName = "";
            for(int i=0;i<words2.length;i++){
                char[] char_table = words2[i].toCharArray();
                char_table[0]=Character.toUpperCase(char_table[0]);
                words2[i] = new String(char_table);
                if (i!= words2.length-1){
                    finalCityName+=words2[i]+" ";
                }else{
                    finalCityName+=words2[i];
                }
            }
            
            ArrayList<Customer2> listCust = myForm.getLeMenuP().getListCustomer();
            boolean nameValidate = true;
            for(Customer2 cust : listCust){
                if (cust.getName().equals(finalCorpName)){
                    if(cust.getTown().equals(finalCityName)){
                        nameValidate = false;
                    }
                }
            }
            
            if (nameValidate){
                Customer2 newCustomer = new Customer2(finalCorpName,finalCityName);
                myForm.getLeMenuP().getListCustomer().add(newCustomer);
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The new customer is registered", "Create customer", JOptionPane.INFORMATION_MESSAGE);
                 myForm.getLeMenuP().afficheMenuPrincipal();
            }else{
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "This customer already exists in this city", "Create customer", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
}
