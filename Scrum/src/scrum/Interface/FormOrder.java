package scrum.Interface;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.LEFT;
import scrum.Controleur.CtrlFormOrder;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Delphine
 */
public class FormOrder extends JPanel {
    
    MenuPrincipal myMenu;
    private CtrlFormOrder controleur;
    private JTextField nameOrder;
    private JTextField numberSample;
    private JComboBox<SpecieCategory> species;
    private JComboBox<SpecieCategory> category;
    private JComboBox<SpecieCategory> analysis;
    
    private JButton validateForm;

    public FormOrder(MenuPrincipal menu){
        myMenu = menu;
        controleur = new CtrlFormOrder(this);
        
        JLabel labelTitle = new JLabel("New order");
        labelTitle.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        nameOrder = new JTextField(20);
        JPanel panelField1 = new JPanel();
        panelField1.add(new JLabel("Name of the order"));
        panelField1.add(nameOrder);
        
        numberSample = new JTextField(20);
        JPanel panelField2 = new JPanel();
        panelField2.add(new JLabel("Number of samples"));
        panelField2.add(numberSample);
        
        
        
        JPanel panelForm = new JPanel(new FlowLayout(LEFT));
        
    }
}
