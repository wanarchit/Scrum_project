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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import scrum.Controleur.CtrlFormCreateSexingTest;
import scrum.noyau.Analysis;
import scrum.noyau.SexingTest;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

public class FormCreateSexingTest extends JPanel{
	
	private JComboBox<Specie> species;
	private JTextField valueFemale;
	private JTextField valueMale;
	private JTextField positionFemale;
	private JTextField positionMale;
	private JButton validateForm;
	private JButton butRetour;
	private MenuPrincipal myMenu;
	
	public FormCreateSexingTest(MenuPrincipal myMenu){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        CtrlFormCreateSexingTest controler = new CtrlFormCreateSexingTest(this);
        this.myMenu = myMenu;
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
		positionFemale = new JTextField(20);
		panelFemale.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelFemale.add(new JLabel("Value "));
		panelFemale.add(valueFemale);
		panelFemale.add(new JLabel("    Position "));
		panelFemale.add(positionFemale);
		
		JPanel panelMale = new JPanel();
		title = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Male");
		title.setTitleJustification(TitledBorder.CENTER);
		panelMale.setBorder(title);
		valueMale = new JTextField(20);
		positionMale = new JTextField(20);
		panelMale.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelMale.add(new JLabel("Value "));
		panelMale.add(valueMale);
		panelMale.add(new JLabel("    Position "));
		panelMale.add(positionMale);
		
		// Creation of the button to return to the main menu and the validate button
        JPanel panButValid = new JPanel();
        validateForm = new JButton("Validate");
        validateForm.addActionListener(controler);
        panButValid.add(validateForm);

        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Return");
        butRetour.addActionListener(controler);
        panButRetour.add(butRetour);

        JPanel panButtons = new JPanel(new GridLayout(1, 2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.add(labelTitle);
        this.add(panelSpecies);
        this.add(panelFemale);
        this.add(panelMale);
        this.add(panButtons);
	}

	public JButton getButtonValid() {
		return validateForm;
	}
	
	public JButton getButtonReturn() {
		return butRetour;
	}

	public MenuPrincipal getMenu() {
		return myMenu;
	}
	
	public void validation() {
		if(valueFemale.getText().isEmpty() || valueMale.getText().isEmpty() ||
				positionFemale.getText().isEmpty() || positionMale.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "One field is empty", "Field empty", JOptionPane.INFORMATION_MESSAGE);
		}
		else{
		    try
		    {
		        int femaleVal= Integer.parseInt(valueFemale.getText());
		        int femalePos= Integer.parseInt(positionFemale.getText());
		        int maleVal= Integer.parseInt(valueMale.getText());
		        int malePos= Integer.parseInt(positionMale.getText());
		        if(femaleVal <= 0){
		        	JOptionPane.showMessageDialog(null, "The female value needs to be upper than 0", "Error number", JOptionPane.INFORMATION_MESSAGE);
		        } else if(maleVal <= 0){
		        	JOptionPane.showMessageDialog(null, "The male value needs to be upper than 0", "Error number", JOptionPane.INFORMATION_MESSAGE);
		        } else if(femalePos <= 0){
		        	JOptionPane.showMessageDialog(null, "The female distance needs to be upper than 0", "Error number", JOptionPane.INFORMATION_MESSAGE);
		        } else if(malePos <= 0){
		        	JOptionPane.showMessageDialog(null, "The male distance needs to be upper than 0", "Error number", JOptionPane.INFORMATION_MESSAGE);
		        }
		        else{
		        	myMenu.getListAnalysis().add(new SexingTest((Specie) species.getSelectedItem(), malePos, maleVal, femalePos, femaleVal));
		        	JOptionPane.showMessageDialog(null, "Sexing test created", "Success", JOptionPane.INFORMATION_MESSAGE);
		            myMenu.afficheMenuPrincipal();
		        }	
		    }
		    catch(NumberFormatException e)
		    {
		        JOptionPane.showMessageDialog(null, "The value and the distance needs to be a numeric value", "Number format", JOptionPane.INFORMATION_MESSAGE);
		    } 
		}
	}

}
