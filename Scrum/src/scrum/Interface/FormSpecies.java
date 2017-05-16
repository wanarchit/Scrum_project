package scrum.Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scrum.noyau.SpecieCategory;

public class FormSpecies extends JPanel{
	
	private JTextField fieldNom;
	private JComboBox<SpecieCategory> combo;
	
	
	public FormSpecies (ArrayList<SpecieCategory> lesCategories){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setAlignmentX(LEFT_ALIGNMENT);
		
		JPanel nom = new JPanel();
		nom.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titreNom = new JLabel("Nom :");
		fieldNom = new JTextField();
		fieldNom.setPreferredSize(new Dimension(150,50));
		nom.add(titreNom);
		nom.add(fieldNom);
		
		JPanel categorie = new JPanel();
		categorie.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel titreCategorie = new JLabel("Catégorie :");
		combo = new JComboBox<SpecieCategory>();
		for (SpecieCategory specieCategory : lesCategories) {
			combo.addItem(specieCategory);
		}
		categorie.add(titreCategorie);
		categorie.add(combo);
		JButton valider = new JButton("Valider");
		
		this.add(nom);
		this.add(categorie);
		this.add(valider);
	}
	
	public static void main (String[] args){
		ArrayList<SpecieCategory> lesCategories = new ArrayList<SpecieCategory>();
		
		lesCategories.add(new SpecieCategory("Bird"));
		lesCategories.add(new SpecieCategory("Dog"));
		lesCategories.add(new SpecieCategory("Cat"));
		
		JFrame t = new JFrame();
		t.setVisible(true);
		t.setPreferredSize(new Dimension(500,500));
		t.add(new FormSpecies(lesCategories));
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
