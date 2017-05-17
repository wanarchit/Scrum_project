/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import scrum.Interface.FormScrapie;

/**
 *
 * @author Marin
 */
public class CtrlFormScrapie implements ActionListener {
        private FormScrapie myForm;
        

    
    public CtrlFormScrapie(FormScrapie form){
        
        
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(myForm.getButValider())){
            if (myForm.getPosition().getText().isEmpty()) {
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The position field is empty", "Add a position", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                
            }
        }
        else if (e.getSource().equals(myForm.getButRetour())) {
            myForm.getLeMenu().afficheMenuPrincipal();
        }
    }
    
}
