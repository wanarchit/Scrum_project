/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import scrum.Interface.MenuPrincipal2;
import scrum.Interface.MenuSecretary;
import scrum.Interface.MenuValidator;
import scrum.Scrum;
import scrum.noyau.IntegrationTest;

/**
 *
 * @author Jennifer
 */
public class CtrlMenuValidator implements ActionListener {
    
        
    private MenuValidator leMenu;
    
    public CtrlMenuValidator(MenuValidator monMenu){
        leMenu = monMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(leMenu.getbutExploreOrder())){
            leMenu.afficheExploreOrder();
        }else if(e.getSource().equals(leMenu.getbutFormScrapie())){
            leMenu.afficheFormScrapie();
        }else if(e.getSource().equals(leMenu.getbutFormSexingTest())){
            leMenu.afficheFormSexingTest();
        }else if (e.getSource().equals(leMenu.getButRetour())){
            leMenu.getLeMenu2().afficheMenuPrincipal2();
        }
            
    
}

}
