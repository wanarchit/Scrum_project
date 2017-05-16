/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.FormOrder;

/**
 *
 * @author Delphine
 */
public class CtrlFormOrder implements ActionListener {
    
    private FormOrder monFormulaire;
    
    public CtrlFormOrder(FormOrder formulaire){
        monFormulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
