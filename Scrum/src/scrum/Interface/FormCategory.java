package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import scrum.Controleur.CtrlFormCategory;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class FormCategory extends JPanel {
     
    MenuSecretary myMenu;
    private CtrlFormCategory controleur;
    private JTextField nameCategory;
    private JButton butValidate;
    private JButton butRetour;
    
    public FormCategory(MenuSecretary leMenu){
        myMenu = leMenu;
        controleur = new CtrlFormCategory(this);//A creer 
        
        JLabel headLabel = new JLabel("New Category");
        headLabel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JPanel panForm = new JPanel(new BorderLayout());
        JPanel panCenterForm = new JPanel(new GridBagLayout());
        
        JPanel panCategory = new JPanel(); 
        JPanel panCategoryField = new JPanel();
        
        JPanel panCatExist = new JPanel();
        

        nameCategory = new JTextField(20);
        panCategory.add(new JLabel("Category name :  "));
        panCategoryField.add(nameCategory);
        
                
        panCatExist.add(new JLabel("Categories already exist :  "));
        JComboBox listeCat = new JComboBox();
        for (SpecieCategory diffCat : myMenu.getLeMenu2().getListCategory()) {
            listeCat.addItem(diffCat.getName());
        }
        listeCat.setSize(100, 100);
        JPanel panComboBox = new JPanel();
        panComboBox.add(listeCat);
        
        GridBagConstraints RightCenter = new GridBagConstraints();
        RightCenter.anchor = GridBagConstraints.LINE_END;
        RightCenter.gridx = 0;
        RightCenter.gridy = 0;
        
        GridBagConstraints LeftCenter = new GridBagConstraints();
        LeftCenter.anchor = GridBagConstraints.LINE_START;
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 0;
        
        panCenterForm.add(panCategory,RightCenter);
        panCenterForm.add(panCategoryField,LeftCenter);
        
        RightCenter.gridx = 0;
        RightCenter.gridy = 1;
        
        panCenterForm.add(panCatExist,RightCenter);
        
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 1;
        panCenterForm.add(panComboBox,LeftCenter);
        
        panForm.add(panCenterForm,BorderLayout.CENTER);
        
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
    
    public MenuSecretary getLeMenuP(){
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
