package scrum.Interface;

import java.awt.BorderLayout;
import static javax.swing.SwingConstants.LEFT;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import scrum.noyau.Customer2;
import scrum.noyau.Order;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 * Class to represent the form to add an Order
 *
 * @author Delphine & Aurelien
 */
public class FormOrder extends JPanel {

    MenuPrincipal myMenu;
    private CtrlFormOrder controleur;
    private JTextField nameOrder;
    private JTextField numberSample;

    private JComboBox<SpecieCategory> category;
    private JComboBox<Specie> species;
    private JComboBox<Analysis> analysis;
    private JComboBox<Customer2> customers;
    private ArrayList<Analysis> listAnalysis;

    private JButton validateForm;
    private JButton butRetour;
	

    /**
     * The constructor of the class
     *
     * @param menu The main menu of our interface, to allow the redirection
     * @param listAnalysis All the analysys available on the application
     * @param listCategory All the categories available on the application
     */
    public FormOrder(MenuPrincipal menu,ArrayList<Analysis> listAnalysis, ArrayList<SpecieCategory> listCategory, ArrayList<Customer2> listCustomer){
    	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    	this.myMenu = menu;
        this.controleur = new CtrlFormOrder(this);
        this.listAnalysis = listAnalysis;
        
        // Title of the panel
        JLabel labelTitle = new JLabel("New order");
        labelTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        //CREATION GRIDBAG
        JPanel panGeneral = new JPanel(new GridBagLayout());
        GridBagConstraints centreADroite = new GridBagConstraints();
        centreADroite.anchor = GridBagConstraints.LINE_END;

        GridBagConstraints centreAGauche = new GridBagConstraints();
        centreAGauche.anchor = GridBagConstraints.LINE_START;
        
        // Creation of the JCombobox for all the customer
        customers = new JComboBox<Customer2>();
        for (Customer2 customer2 : listCustomer) {
        	customers.addItem(customer2);
		}
        
        JLabel titleCust = new JLabel("Customer : ");
        titleCust.setPreferredSize(new Dimension(200,100));

        centreADroite.gridx = 0;
        centreADroite.gridy = 5;
        centreAGauche.gridx = 1;
        centreAGauche.gridy = 5;

        panGeneral.add(titleCust, centreADroite);
        panGeneral.add(customers, centreAGauche);
        
      

        // The field for the name
        nameOrder = new JTextField(20);
        JLabel labelNom = new JLabel("Name of the order : ");
        labelNom.setPreferredSize(new Dimension(200,100));

        //AJOUT PANEL
        centreADroite.gridx = 0;
        centreADroite.gridy = 0;
        panGeneral.add(labelNom, centreADroite);

        centreAGauche.gridx = 1;
        centreAGauche.gridy = 0;
        panGeneral.add(nameOrder, centreAGauche);

        // The field for the number of sample
        numberSample = new JTextField(20);
        JLabel titleSample = new JLabel("Number of samples : ");
        titleSample.setPreferredSize(new Dimension(200,100));

        centreADroite.gridx = 0;
        centreADroite.gridy = 4;
        centreAGauche.gridx = 1;
        centreAGauche.gridy = 4;

        panGeneral.add(titleSample, centreADroite);
        panGeneral.add(numberSample, centreAGauche);

        // Creation of the JCombobox for all the category
        category = new JComboBox<SpecieCategory>();
        category.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox combo = (JComboBox) e.getSource();
                SpecieCategory categoryChoose = (SpecieCategory) combo.getSelectedItem();
                FormOrder.this.majSpecies(categoryChoose);
            }
        }
        );

        JLabel labelCat = new JLabel("Category : ");
        labelCat.setPreferredSize(new Dimension(200,100));

        centreADroite.gridx = 0;
        centreADroite.gridy = 1;
        centreAGauche.gridx = 1;
        centreAGauche.gridy = 1;

        panGeneral.add(labelCat, centreADroite);
        panGeneral.add(category, centreAGauche);

        // Creation of the JCombobox for all the species
        species = new JComboBox<Specie>();
        species.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox combo = (JComboBox) e.getSource();
                Specie specieChoose = (Specie) combo.getSelectedItem();
                FormOrder.this.majAnalysis(specieChoose);
            }
        }
        );

        JLabel labelSpec = new JLabel("Specie : ");
        labelSpec.setPreferredSize(new Dimension(200,100));

        centreADroite.gridx = 0;
        centreADroite.gridy = 2;
        centreAGauche.gridx = 1;
        centreAGauche.gridy = 2;

        panGeneral.add(labelSpec, centreADroite);
        panGeneral.add(species, centreAGauche);

        // Creation of the JCombobox for all the analysis
        analysis = new JComboBox<Analysis>();
        
        JLabel labelAna = new JLabel("Analysis : ");
        labelAna.setPreferredSize(new Dimension(200,100));
        
        centreADroite.gridx = 0;
        centreADroite.gridy = 3;
        centreAGauche.gridx = 1;
        centreAGauche.gridy = 3;

        panGeneral.add(labelAna, centreADroite);
        panGeneral.add(analysis, centreAGauche);
        
        // Initialization of the field
        int compteur = 0;
        for (SpecieCategory specieCategory : listCategory) {
            if (compteur == 0) {
                majSpecies(specieCategory);
                majAnalysis((Specie) species.getSelectedItem());
            }
            compteur++;
            category.addItem(specieCategory);
        }

        // Creation of the button to return to the main menu and the validate button
        JPanel panButValid = new JPanel();
        validateForm = new JButton("Valider");
        validateForm.addActionListener(controleur);
        panButValid.add(validateForm);

        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);

        JPanel panButtons = new JPanel(new GridLayout(1, 2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);

        // Add all the components
        this.setLayout(new BorderLayout());
        this.add(labelTitle,BorderLayout.NORTH);
        this.add(panGeneral, BorderLayout.CENTER);
        this.add(panButtons, BorderLayout.SOUTH);
    }


    /**
     * Function to allow the modification of the analysis according to the specie
     * @param specieChoose The specie choosen
     */
	private void majAnalysis(Specie specieChoose) {
		analysis.removeAllItems();
		for (Analysis analys : listAnalysis) {
			if(analys.getSpecie().equals(specieChoose))
				analysis.addItem(analys);
		}
	}

	/**
	 * Function to allow the modification of the species according to the category
	 * @param categoryChoose The category choosen
	 */
	private void majSpecies(SpecieCategory categoryChoose) {
		species.removeAllItems();
		for (Specie spec : categoryChoose.getSpecies()) {
			species.addItem(spec);
		}
	}
        
	/**
	 * Function to get the main menu
	 * @return The main menu
	 */
    public MenuPrincipal getLeMenuP(){
        return myMenu;
    }
    
    /**
     * Function to get the validating button
     * @return The button to validate
     */
    public JButton getButValider(){
        return validateForm;
    }
    
    /**
     * Function to get the return button
     * @return The button to return to the main menu
     */
    public JButton getButRetour(){
        return butRetour;
    }

    /**
     * Function to validate all the forms according to the specification
     */
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
				else{
					myMenu.addOrder((Customer2) customers.getSelectedItem(),new Order((Customer2) customers.getSelectedItem()));
					myMenu.afficheMenuPrincipal();
				}
					
	        }
	        catch(NumberFormatException e)
	        {
	        	JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The number of analysis needs to be a numeric value", "Create order", JOptionPane.INFORMATION_MESSAGE);
	        } 
		}
		
	}
}
