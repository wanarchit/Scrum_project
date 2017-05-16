/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.FormExploreOrder;
/**
 *
 * @author SERAZIN
 */
public class CtrlFormExploreOrder implements ActionListener {
    
    private FormExploreOrder formulaire;
    
    public CtrlFormExploreOrder (FormExploreOrder formulaire){
        formulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formulaire.getValidate())){
        	formulaire.validation();
        }else if(e.getSource().equals(formulaire.getRetour())){
            formulaire.getMenuPrincipal().afficheMenuPrincipal();
        }
    }
}
