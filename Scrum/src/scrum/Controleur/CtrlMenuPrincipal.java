package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.MenuPrincipal;

/**
 *
 * @author Paul
 */
public class CtrlMenuPrincipal implements ActionListener{
    
    private MenuPrincipal leMenu;
    
    public CtrlMenuPrincipal(MenuPrincipal monMenu){
        leMenu = monMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(leMenu.getButFormCustomer())){
            leMenu.afficheFormCustomer();
        }
    }
}
