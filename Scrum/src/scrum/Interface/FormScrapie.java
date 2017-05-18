/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormScrapie;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class FormScrapie extends JPanel {
    MenuValidator myMenu;
    private CtrlFormScrapie controleur;
    public JTextField positionPeak;
    public JTextField valuePeak;
    private JButton butPeak;
    private JButton butValidate;
    private JButton retour;
    private JButton valider;
    private JComboBox<Specie> species;
    private JLabel labelRes;
    private JLabel headTitle;
    public int number = 1; 
    public JLabel peakNumber; 
    
    public FormScrapie(MenuValidator leMenu){
        myMenu=leMenu;
        controleur = new CtrlFormScrapie(this);
        
        // Title 
        headTitle= new JLabel("Create a Scrapie Test");
        headTitle.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        // 
        
        JPanel panForm = new JPanel(new BorderLayout());
        JPanel panCenterForm = new JPanel(new GridBagLayout());
        
        JPanel panSpecieExist = new JPanel();
        JPanel panPeakNumber = new JPanel(); 
        JPanel panResult = new JPanel(); 
        JPanel panPosition = new JPanel(); 
        JPanel panFieldPosition = new JPanel(); 
        JPanel panValue = new JPanel(); 
        JPanel panFieldValue = new JPanel(); 
        JPanel panSpecie = new JPanel(); 
        JPanel panPeakNumberField = new JPanel(); 
        peakNumber = new JLabel (""+number);
        JPanel panButPeak = new JPanel();

        positionPeak = new JTextField(20); 
        panPosition.add(new JLabel ("Position : "));
        panFieldPosition.add(positionPeak);
        
        valuePeak = new JTextField(20); 
        panValue.add(new JLabel ("Value : "));
        panFieldValue.add(valuePeak);
        
        panPeakNumber.add(new JLabel("Peak Number : "));
        panPeakNumberField.add(peakNumber);
        
      
        panSpecie.add(new JLabel("Species : "));
        JLabel result =new JLabel("Results : ");
        result.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 16));
        panResult.add(result);


        species = new JComboBox();
        for (Specie diffSpecies : myMenu.getLeMenu2().getListSpecie()) {
            species.addItem(diffSpecies);
        }
        panSpecieExist.add(species);
        
        butPeak = new JButton ("Add a Peak");
        butPeak.addActionListener(controleur); 
        panButPeak.add(butPeak);
        
        GridBagConstraints RightCenter = new GridBagConstraints();
        RightCenter.anchor = GridBagConstraints.LINE_END;
        RightCenter.gridx = 0;
        RightCenter.gridy = 0;
        
        GridBagConstraints LeftCenter = new GridBagConstraints();
        LeftCenter.anchor = GridBagConstraints.LINE_START;
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 0;
        
        panCenterForm.add(panSpecie, RightCenter);
        panCenterForm.add(panSpecieExist, LeftCenter);
        
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 1;
        panCenterForm.add(panResult,LeftCenter);
        
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 2;
        panCenterForm.add(panPeakNumberField,LeftCenter);
        
        RightCenter.gridx = 0;
        RightCenter.gridy = 2;
        panCenterForm.add(panPeakNumber, RightCenter);
       
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 4;
        panCenterForm.add(panFieldValue,LeftCenter);
        
        RightCenter.gridx = 0;
        RightCenter.gridy = 3;
        panCenterForm.add(panPosition, RightCenter);

        LeftCenter.gridx = 1;
        LeftCenter.gridy = 3;
        panCenterForm.add(panFieldPosition,LeftCenter);
        
        RightCenter.gridx = 0;
        RightCenter.gridy = 4;
        panCenterForm.add(panValue, RightCenter);
        
        LeftCenter.gridx = 1;
        LeftCenter.gridy = 2;
        panCenterForm.add(panPeakNumberField,LeftCenter);
       
        RightCenter.gridx = 1;
        RightCenter.gridy = 5;
        panCenterForm.add(panButPeak, RightCenter);
        panForm.add(panCenterForm,BorderLayout.CENTER);

        JPanel panButValid = new JPanel();
        valider = new JButton("Validation");
        valider.addActionListener(controleur);
        panButValid.add(valider);
        
        JPanel panButRetour = new JPanel();
        retour = new JButton("Retour");
        retour.addActionListener(controleur);
        panButRetour.add(retour);
   
        JPanel panButtons = new JPanel(new GridLayout(1,2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);
        
        this.setLayout(new BorderLayout());
        this.add(headTitle,BorderLayout.NORTH);
        this.add(panForm, BorderLayout.CENTER);
        this.add(panButtons, BorderLayout.SOUTH);
    }
    
    public JTextField getPosition(){
        return  positionPeak;
    }
    
    public JTextField getValue(){
        return  valuePeak;
    }
    
    public Specie getValCombo(){
        return species.getItemAt(species.getSelectedIndex());
    }
    
    public JButton getButValider(){
        return valider;
    }
    
    public JButton getButRetour(){
        return retour;
    }
    
    public int autoIncrementNumberPeak(){
        return number+= 1;
    }
    
    public JButton getButPeakNumber(){
        return butPeak;
    }
        
    public MenuValidator getLeMenu(){
        return myMenu;
    }
    
}
