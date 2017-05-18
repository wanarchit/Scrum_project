package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import scrum.Controleur.CtrlFormSecondRead;
import scrum.noyau.Microplaque;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class FormSecondRead extends JPanel {
       
    private MenuValidator myMenu;
    private CtrlFormSecondRead controleur;
    private JButton butValidate;
    private JButton butRetour;
    private JRadioButton jr1;
    private JRadioButton jr2;
    
    public FormSecondRead(MenuValidator leMenu){
        myMenu = leMenu;
        controleur = new CtrlFormSecondRead(this);//A creer 
        JPanel panForm = new JPanel(new BorderLayout());
        JPanel panChoix= new JPanel(new BorderLayout());
        JLabel headLabel = new JLabel("Second read");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPanel headPanel = new JPanel(new BorderLayout());
        headPanel.add(headLabel, BorderLayout.NORTH);
        JLabel title1 = new JLabel("Type de test:");
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headPanel.add(title1, BorderLayout.SOUTH);
        jr1 = new JRadioButton("Sexing Test");
        jr1.addActionListener(controleur);
        panChoix.add(jr1, BorderLayout.NORTH);
        jr2 = new JRadioButton("Scrapie Test");
        jr2.addActionListener(controleur);
        panChoix.add(jr2);
        headPanel.add(panChoix, BorderLayout.WEST);
        JComboBox listPlate = new JComboBox();
        for (Microplaque plates : myMenu.getLeMenu2().getListMicroplaques()) {
            listPlate.addItem(plates.getName());
        }
        listPlate.setSize(100, 100);
        JPanel panCombo= new JPanel();
        panCombo.add(listPlate);
        panForm.add(panCombo,BorderLayout.EAST);
        JLabel title2 = new JLabel("Result's iteration" );//
        panForm.add(title2);
              
        JPanel panButValid = new JPanel();
        butValidate = new JButton("Validation");
       // butValidate.addActionListener(controleur);
        panButValid.add(butValidate);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
       
        this.setLayout(new BorderLayout());
        this.add(headPanel,BorderLayout.NORTH);
        this.add(panForm,BorderLayout.CENTER);
        this.add(panButtons,BorderLayout.SOUTH);
    } 
    public JButton getButValider(){
        return butValidate;
    } 
    
    public JButton getButRetour(){
        return butRetour;
    }
    
    public MenuValidator getLeMenu(){
        return myMenu;
    }
}