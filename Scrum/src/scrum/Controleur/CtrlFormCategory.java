/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import scrum.Interface.FormCategory;
import scrum.noyau.Customer2;

/**
 *
 * @author Marin
 */
public class CtrlFormCategory {
    private FormCategory myForm;
    
    public CtrlFormCategory(FormCategory form){
        myForm=form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButValid())){
            String Category = myForm.getCategory().getText();
            System.out.println("get field : "+Category);//test
            Category=Category.toLowerCase();
            listeCat=myForm.getLeMenuP().getListCustomer();
            
            
            
            String[] words = Category.split(" ");
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
