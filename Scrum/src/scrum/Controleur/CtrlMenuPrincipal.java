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
        }else if(e.getSource().equals(leMenu.getButFormOrder())){
            leMenu.afficheFormOrder();
        }else if(e.getSource().equals(leMenu.getButFormSpecie())){
            leMenu.afficheFormSpecie();
        }else if(e.getSource().equals(leMenu.getButFormCategory())){
            leMenu.afficheFormCategory();
        }else if(e.getSource().equals(leMenu.getButExploreOrder())){
            leMenu.afficheExploreOrder();
        }else if(e.getSource().equals(leMenu.getButFormScrapie())){
            leMenu.afficheFormScrapie();
        }
    }
}
