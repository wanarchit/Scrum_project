/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.FormMicroplaque;

/**
 *
 * @author Delphine
 */
public class CtrlFormMicroplaque implements ActionListener{
    
        private FormMicroplaque myForm;

    public CtrlFormMicroplaque(FormMicroplaque form) {
        myForm = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButS1())){
            
        }
        
        if(e.getSource().equals(myForm.getButValid())){
            
            
            
        }else if(e.getSource().equals(myForm.getButRetour())){
            myForm.getLeMenuP().afficheMenuTechnician();
        }
    }

    
}
