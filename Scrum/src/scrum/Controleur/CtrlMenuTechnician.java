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
import scrum.Interface.MenuTechnician;
import scrum.Scrum;
import scrum.noyau.IntegrationTest;

/**
 *
 * @author Jennifer
 */
public class CtrlMenuTechnician implements ActionListener {
    
        
    private MenuTechnician leMenu;
    
    public CtrlMenuTechnician(MenuTechnician monMenu){
        leMenu = monMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(leMenu.getButFormMicroplaque())){
          leMenu.afficheFormMicroplaque();
        }else if(e.getSource().equals(leMenu.getButFormFirstRead())){
        	leMenu.afficheFormFirstRead();
        }
        else if (e.getSource().equals(leMenu.getButRetour())){
            leMenu.getLeMenu2().afficheMenuPrincipal2();
        }
            
    
}

}
