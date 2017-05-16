package scrum.Interface;

import static javax.swing.SwingConstants.LEFT;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import scrum.Controleur.CtrlFormOrder;
import scrum.noyau.Analysis;
import scrum.noyau.Specie;
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
    
    private JComboBox<SpecieCategory> category;
    private JComboBox<Specie> species;
    private JComboBox<Analysis> analysis;
    
    private ArrayList<Analysis> listAnalysis;
    
    private JButton validateForm;
    private JButton butRetour;

    public FormOrder(MenuPrincipal menu,ArrayList<Analysis> listAnalysis, ArrayList<SpecieCategory> listCategory){
    	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        myMenu = menu;
        controleur = new CtrlFormOrder(this);
        this.listAnalysis = listAnalysis;
        
        analysis = new JComboBox<Analysis>();
        
        JLabel labelTitle = new JLabel("New order");
        labelTitle.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        nameOrder = new JTextField(20);
        JPanel panelField1 = new JPanel();
        panelField1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelField1.add(new JLabel("Name of the order"));
        panelField1.add(nameOrder);
        
        numberSample = new JTextField(20);
        JPanel panelField2 = new JPanel();
        panelField2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelField2.add(new JLabel("Number of samples"));
        panelField2.add(numberSample);
        
        
        category = new JComboBox<SpecieCategory>();
        category.addActionListener(
        		new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        SpecieCategory categoryChoose = (SpecieCategory) combo.getSelectedItem();
                        FormOrder.this.majSpecies(categoryChoose);
                    }
                }            
        );
        JPanel panelComboCategory = new JPanel();
        panelComboCategory.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelComboCategory.add(new JLabel("Category"));
        panelComboCategory.add(category);
        
        
        species = new JComboBox<Specie>();
        species.addActionListener(
        		new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JComboBox combo = (JComboBox)e.getSource();
                        Specie specieChoose = (Specie) combo.getSelectedItem();
                        FormOrder.this.majAnalysis(specieChoose);
                    }
                }            
        );
        JPanel panelComboSpecie = new JPanel();
        panelComboSpecie.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelComboSpecie.add(new JLabel("Specie"));
        panelComboSpecie.add(species);
        
        JPanel panelComboAnalysis = new JPanel();
        panelComboAnalysis.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelComboAnalysis.add(new JLabel("Analysis"));
        panelComboAnalysis.add(analysis);
        
        
        JPanel panelForm = new JPanel(new FlowLayout(LEFT));
        
        int compteur = 0;
        for (SpecieCategory specieCategory : listCategory) {
        	if(compteur == 0){
        		majSpecies(specieCategory);
        		majAnalysis((Specie) species.getSelectedItem());
        	}
        	compteur++;
        	category.addItem(specieCategory);
		}
        
        JPanel panButValid = new JPanel();
        validateForm = new JButton("Valider");
        validateForm.setPreferredSize(new Dimension(200,20));
        validateForm.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        validateForm.addActionListener(controleur);
        panButValid.add(validateForm);
        
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);
        
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.add(labelTitle);
        this.add(panelField1);
        this.add(panelComboCategory);
        this.add(panelComboSpecie);
        this.add(panelComboAnalysis);
        this.add(panelField2);
        
        this.add(panButtons);
    }

	private void majAnalysis(Specie specieChoose) {
		analysis.removeAllItems();
		for (Analysis analys : listAnalysis) {
			if(analys.getSpecie().equals(specieChoose))
				analysis.addItem(analys);
		}
	}

	private void majSpecies(SpecieCategory categoryChoose) {
		species.removeAllItems();
		for (Specie spec : categoryChoose.getSpecies()) {
			species.addItem(spec);
		}
	}
        
        public MenuPrincipal getLeMenuP(){
            return myMenu;
        }
        
        public JButton getButValider(){
            return validateForm;
        }
        
        public JButton getButRetour(){
            return butRetour;
        }

		public void validationForm() {
			if(numberSample.getText().isEmpty() || nameOrder.getText().isEmpty()){
				JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "One field is empty", "Create order", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				try
		        {
		            int i= Integer.parseInt(numberSample.getText());
		            if(i <= 0){
						JOptionPane boiteDial = new JOptionPane();
		                boiteDial.showMessageDialog(null, "The number of analysis needs to be upper than 0", "Create order", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						myMenu.afficheMenuPrincipal();
		        }
		        catch(NumberFormatException e)
		        {
		        	JOptionPane boiteDial = new JOptionPane();
	                boiteDial.showMessageDialog(null, "The number of analysis needs to be a numeric value", "Create order", JOptionPane.INFORMATION_MESSAGE);
		        } 
			}
			
		}
}
