package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
            System.out.println("get field : "+CorpName);
            CorpName=CorpName.toLowerCase();
            String[] words = CorpName.split(" ");
            String finalName = "";
            for(int i=0;i<words.length;i++){
                char[] char_table = words[i].toCharArray();
                char_table[0]=Character.toUpperCase(char_table[0]);
                words[i] = new String(char_table);
                if (i!= words.length-1){
                    finalName+=words[i]+" ";
                }else{
                    finalName+=words[i];
                }
            }
            
            System.out.println("finalName = "+finalName+"!");
            ArrayList<Customer2> listCust = myForm.getLeMenuP().getListCustomer();
            for(Customer2 cust : listCust){
                
            }
        }
    }
    
}
