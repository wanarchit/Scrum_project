/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import scrum.Interface.FormCategory;
import scrum.noyau.Customer2;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class CtrlFormCategory implements ActionListener{
    private FormCategory myForm;
    private ArrayList<SpecieCategory> listCat;
    
    public CtrlFormCategory(FormCategory form){
        myForm=form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButValid())){
            String Category = myForm.getCategory().getText();
            System.out.println("get field : "+Category);//test
            Category=Category.toLowerCase();
            listCat=myForm.getLeMenuP().getListCategory();
            for(int i=0; i<listCat.size();i++){
                if(listCat.get(i).getName() == Category){
                    System.out.println("Specie's category already exists !");
                }
                else{
                    System.out.println("Registering done");
                    SpecieCategory sp= new SpecieCategory(Category);
                    myForm.getLeMenuP().getListCategory().add(sp);  
                }
            }
        }
    } 
}
