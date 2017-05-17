package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.Controleur.CtrlFormCustomer;
import scrum.Controleur.CtrlFormMicroplaque;

/**
 *
 * @author Delphine
 */
public class FormMicroplaque extends JPanel {

    MenuPrincipal myMenu;
    CtrlFormMicroplaque controleur;
    JButton butSample1;
    JButton butSample2;
    JButton butSample3;
    JButton butSample4;
    JButton butSample5;
    JButton butSample6;
    JButton butSample7;
    JButton butSample8;

    public FormMicroplaque(MenuPrincipal leMenu) {
        myMenu = leMenu;
        controleur = new CtrlFormMicroplaque(this);

        // Title
        JLabel headLabel = new JLabel("New Microplaque");
        headLabel.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        butSample1 = new JButton ("Sample 1");
        butSample2 = new JButton ("Sample 2");
        butSample3 = new JButton ("Sample 3");
        butSample4 = new JButton ("Sample 4");
        butSample5 = new JButton ("Sample 5");
        butSample6 = new JButton ("Sample 6");
        butSample7 = new JButton ("Sample 7");
        butSample8 = new JButton ("Sample 8");
        
        JPanel panelGeneral = new JPanel (new GridBagLayout());
        panelGeneral.add(butSample1);
        panelGeneral.add(butSample2);
        panelGeneral.add(butSample3);
        panelGeneral.add(butSample4);
        panelGeneral.add(butSample5);
        panelGeneral.add(butSample6);
        panelGeneral.add(butSample7);
        panelGeneral.add(butSample8);
        
        
        this.setLayout(new BorderLayout());
        this.add(headLabel,BorderLayout.NORTH);
        this.add(panelGeneral,BorderLayout.CENTER);
    }
}
