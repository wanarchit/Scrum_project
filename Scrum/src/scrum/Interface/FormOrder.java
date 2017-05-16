package scrum.Interface;

import static javax.swing.SwingConstants.LEFT;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import scrum.Controleur.CtrlFormOrder;
import scrum.noyau.Analysis;
import scrum.noyau.ScrapieTest;
import scrum.noyau.SexingTest;
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

    public FormOrder(MenuPrincipal menu,ArrayList<Analysis> listAnalysis, ArrayList<SpecieCategory> listCategory){
        myMenu = menu;
        controleur = new CtrlFormOrder(this);
        this.listAnalysis = listAnalysis;
        
        analysis = new JComboBox<Analysis>();
        
        
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
        
        
        category = new JComboBox<SpecieCategory>();
        for (SpecieCategory specieCategory : listCategory) {
        	category.addItem(specieCategory);
		}
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
        panelComboSpecie.add(new JLabel("Specie"));
        panelComboSpecie.add(species);
        
        JPanel panelComboAnalysis = new JPanel();
        panelComboAnalysis.add(new JLabel("Analysis"));
        panelComboAnalysis.add(analysis);
        
        
        JPanel panelForm = new JPanel(new FlowLayout(LEFT));
        
        this.add(panelComboCategory);
        this.add(panelComboSpecie);
        this.add(panelComboAnalysis);
        
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
	
	public static void main (String[] args){
		ArrayList<SpecieCategory> lesCategories = new ArrayList<SpecieCategory>();
		ArrayList<Analysis> listAnalysis = new ArrayList<Analysis>();
		Specie s1 = new Specie("specie1");
		Specie s2 = new Specie("specie2");
		Specie s3 = new Specie("specie3");
		listAnalysis.add(new ScrapieTest(s1, 1, 2));
		listAnalysis.add(new SexingTest(s2, 1, 1, 1, 1));
		listAnalysis.add(new ScrapieTest(s3, 1, 2));
		
		SpecieCategory sp1 = new SpecieCategory("Bird");
		sp1.addSpecie(s1);
		sp1.addSpecie(s2);
		sp1.addSpecie(s3);
		SpecieCategory sp2 = new SpecieCategory("Dog");
		sp2.addSpecie(s1);
		sp2.addSpecie(s2);
		sp2.addSpecie(s3);
		SpecieCategory sp3 = new SpecieCategory("Cat");
		sp2.addSpecie(s1);
		sp2.addSpecie(s2);
		sp2.addSpecie(s3);
		
		lesCategories.add(sp1);
		lesCategories.add(sp2);
		lesCategories.add(sp3);
		
		JFrame t = new JFrame();
		t.setVisible(true);
		t.setPreferredSize(new Dimension(500,500));
		t.add(new FormOrder(null, listAnalysis, lesCategories));
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
