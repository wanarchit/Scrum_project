package scrum.Interface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import scrum.noyau.Analysis;
import scrum.noyau.SexingTest;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

public class FormCreateSexingTest extends JPanel{
	
	private JComboBox<Specie> species;
	private JTextField valueFemale;
	private JTextField valueMale;
	private JTextField distanceFemale;
	private JTextField distanceMale;
	
	public FormCreateSexingTest(MenuPrincipal myMenu){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        // Title of the panel
        JLabel labelTitle = new JLabel("New Sexing Test");
        labelTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panelSpecies = new JPanel();
        panelSpecies.setLayout(new FlowLayout(FlowLayout.LEFT));
		species = new JComboBox<Specie>();
		boolean present;
		for (SpecieCategory speCateg : myMenu.getListCategory()) {
			for (Specie specie : speCateg.getSpecies()) {
				present = false;
				for (Analysis analys : myMenu.getListAnalysis()) {
					if(analys instanceof SexingTest && analys.getSpecie().equals(specie)){
						present = true;
						break;
					}
				}
				if(!present)
					species.addItem(specie);
			}
		}
		panelSpecies.add(new JLabel("Specie "));
		panelSpecies.add(species);
		
		JPanel panelFemale = new JPanel();
		TitledBorder title;
		title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Female");
		title.setTitleJustification(TitledBorder.CENTER);
		panelFemale.setBorder(title);
		valueFemale = new JTextField(20);
		distanceFemale = new JTextField(20);
		panelFemale.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelFemale.add(new JLabel("Value "));
		panelFemale.add(valueFemale);
		panelFemale.add(new JLabel("    Distance "));
		panelFemale.add(distanceFemale);
		
		JPanel panelMale = new JPanel();
		title.setTitle("Male");
		panelMale.setBorder(title);
		valueMale = new JTextField(20);
		distanceMale = new JTextField(20);
		panelMale.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelMale.add(new JLabel("Value "));
		panelMale.add(valueMale);
		panelMale.add(new JLabel("    Distance "));
		panelMale.add(distanceMale);
		
		// Creation of the button to return to the main menu and the validate button
        JPanel panButValid = new JPanel();
        JButton validateForm = new JButton("Valider");
        validateForm.addActionListener(controleur);
        panButValid.add(validateForm);

        JPanel panButRetour = new JPanel();
        JButton butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);

        JPanel panButtons = new JPanel(new GridLayout(1, 2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
	}

}
