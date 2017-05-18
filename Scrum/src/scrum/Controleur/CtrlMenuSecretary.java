/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import scrum.Interface.MenuSecretary;
import scrum.Scrum;
import scrum.noyau.IntegrationTest;

/**
 *
 * @author Jennifer
 */
public class CtrlMenuSecretary implements ActionListener {
    
        
    private MenuSecretary leMenu;
    
    public CtrlMenuSecretary(MenuSecretary monMenu){
        leMenu = monMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(leMenu.getButFormCustomer())){
            leMenu.afficheFormCustomer();
        }else if(e.getSource().equals(leMenu.getButFormOrder())){
            leMenu.afficheFormOrder();
        }else if(e.getSource().equals(leMenu.getButFormSpecie())){
            leMenu.afficheFormSpecie();
        }else if(e.getSource().equals(leMenu.getButFormCategory())){
            leMenu.afficheFormCategory();
        }else if (e.getSource().equals(leMenu.getButRetour())){
            leMenu.getLeMenu2().afficheMenuPrincipal2();
        }
            
    
}

}
