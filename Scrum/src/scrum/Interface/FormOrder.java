package scrum.Interface;

import static javax.swing.SwingConstants.LEFT;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
        
        this.add(labelTitle);
        this.add(panelField1);
        this.add(panelComboCategory);
        this.add(panelComboSpecie);
        this.add(panelComboAnalysis);
        this.add(panelField2);
        validateForm = new JButton("Valider");
        validateForm.setPreferredSize(new Dimension(200,20));
        validateForm.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        this.add(validateForm);
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
	
	/*public static void main (String[] args){
		ArrayList<SpecieCategory> lesCategories = new ArrayList<SpecieCategory>();
		ArrayList<Analysis> listAnalysis = new ArrayList<Analysis>();
		Specie s1 = new Specie("specie1");
		Specie s2 = new Specie("specie2");
		Specie s3 = new Specie("specie3");
		
		Specie s4 = new Specie("specie4");
		Specie s5 = new Specie("specie5");
		Specie s6 = new Specie("specie6");
		
		Specie s7 = new Specie("specie7");
		Specie s8 = new Specie("specie8");
		Specie s9 = new Specie("specie9");
		
		listAnalysis.add(new ScrapieTest(s1, 1, 2));
		listAnalysis.add(new SexingTest(s2, 1, 1, 1, 1));
		listAnalysis.add(new SexingTest(s3, 1, 1, 1, 1));
		listAnalysis.add(new ScrapieTest(s3, 1, 2));
		
		listAnalysis.add(new ScrapieTest(s5, 1, 2));
		listAnalysis.add(new SexingTest(s4, 1, 1, 1, 1));
		listAnalysis.add(new SexingTest(s5, 1, 1, 1, 1));
		listAnalysis.add(new ScrapieTest(s6, 1, 2));
		
		listAnalysis.add(new ScrapieTest(s7, 1, 2));
		listAnalysis.add(new SexingTest(s9, 1, 1, 1, 1));
		listAnalysis.add(new SexingTest(s9, 1, 1, 1, 1));
		listAnalysis.add(new ScrapieTest(s8, 1, 2));
		
		SpecieCategory sp1 = new SpecieCategory("Bird");
		sp1.addSpecie(s1);
		sp1.addSpecie(s2);
		sp1.addSpecie(s3);
		SpecieCategory sp2 = new SpecieCategory("Dog");
		sp2.addSpecie(s4);
		sp2.addSpecie(s5);
		sp2.addSpecie(s6);
		SpecieCategory sp3 = new SpecieCategory("Cat");
		sp3.addSpecie(s7);
		sp3.addSpecie(s8);
		sp3.addSpecie(s9);
		
		lesCategories.add(sp1);
		lesCategories.add(sp2);
		lesCategories.add(sp3);
		
		JFrame t = new JFrame();
		t.setVisible(true);
		t.setPreferredSize(new Dimension(500,500));
		t.add(new FormOrder(null, listAnalysis, lesCategories));
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
}
