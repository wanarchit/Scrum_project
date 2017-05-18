/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.MenuPrincipal2;

/**
 *
 * @author Jennifer
 */
public class CtrlMenuPrincipal2 implements ActionListener{
    private MenuPrincipal2 leMenu;
    
    public CtrlMenuPrincipal2(MenuPrincipal2 monMenu){
        leMenu = monMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(leMenu.getButSecretary())){
            leMenu.afficheMenuSecretary();
        }else if(e.getSource().equals(leMenu.getButTechnician())){
            leMenu.afficheMenuTechnician();
        }else if(e.getSource().equals(leMenu.getButValidator())){
            leMenu.afficheMenuValidator();
        }else if(e.getSource().equals(leMenu.getButCustomer())){
            leMenu.afficheFormConnexionCustomer();
        }
        }
    
}
    
