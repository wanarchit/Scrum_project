package scrum.Interface;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.Controleur.CtrlFormCustomer;

/**
 *
 * @author Delphine
 */
public class FormMicroplaque extends JPanel {
    
    MenuPrincipal myMenu;
    CtrlFormMicroplaque controleur; //A CREER
    
    
    public FormMicroplaque(MenuPrincipal leMenu){
        myMenu = leMenu;
        controleur = new CtrlFormCustomer(this);
        
        // Title
        JLabel headLabel = new JLabel("New Microplaque");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    }
}