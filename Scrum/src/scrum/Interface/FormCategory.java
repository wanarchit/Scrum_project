package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormCategory;

/**
 *
 * @author Marin
 */
public class FormCategory extends JPanel {
     MenuPrincipal myMenu;
    private CtrlFormCategory controleur;
    private JTextField nameCategory;
    private JButton butValidate;
    private JButton butRetour;
    
    public FormCategory(MenuPrincipal leMenu){
        myMenu = leMenu;
        controleur = new CtrlFormCategory(this);//A creer 
        
        JLabel headLabel = new JLabel("New Customer");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        nameCategory = new JTextField(20);
        JPanel panField1 = new JPanel();
        panField1.add(new JLabel("Category name :  "));
        panField1.add(nameCategory);
                
        JPanel panForm = new JPanel(new GridLayout(1,1));
        panForm.add(panField1);
        
        JPanel panButValid = new JPanel();
        butValidate = new JButton("Validation");
        butValidate.addActionListener(controleur);
        panButValid.add(butValidate);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.setLayout(new BorderLayout());
        this.add(headLabel,BorderLayout.NORTH);
        this.add(panForm,BorderLayout.CENTER);
        this.add(panButtons,BorderLayout.SOUTH);
        
    }
    
    public MenuPrincipal getLeMenuP(){
        return myMenu;
    }
    
    public JTextField getCategory(){
        return nameCategory;
    }
    
    public JButton getButValid(){
        return butValidate;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
}
