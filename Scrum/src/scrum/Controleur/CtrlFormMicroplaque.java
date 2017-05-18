/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum.Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import scrum.Interface.FormMicroplaque;
import scrum.noyau.Microplaque;
import scrum.noyau.Sample;

/**
 *
 * @author Delphine
 */
public class CtrlFormMicroplaque implements ActionListener {

    private FormMicroplaque myForm;
    private Sample arrayFinalSample[];

    public CtrlFormMicroplaque(FormMicroplaque form) {
        myForm = form;
        arrayFinalSample = new Sample[8];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButAdd())) {
            int nbSampleSave = 0;
            while (arrayFinalSample[nbSampleSave] != null && nbSampleSave < 8){
                nbSampleSave++;
            }
            System.out.println("nbSample"+nbSampleSave);
            if (nbSampleSave!=0) {
                System.out.println(arrayFinalSample[0].getAnalysis());
                if (arrayFinalSample[0].getAnalysis().equals(myForm.getAnaSelect())) {
                    int i = 0;
                    while (arrayFinalSample[i] != null && i < arrayFinalSample.length) {
                        i++;
                    }
                    arrayFinalSample[i] = (myForm.getSampleSelect());
                    if (i==1){
                        myForm.getLabS2().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS2().setForeground(Color.red);
                    }else if (i==2){
                        myForm.getLabS3().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS3().setForeground(Color.red);
                    }else if (i==3){
                        myForm.getLabS4().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS4().setForeground(Color.red);
                    }else if (i==4){
                        myForm.getLabS5().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS5().setForeground(Color.red);
                    }else if (i==5){
                        myForm.getLabS6().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS6().setForeground(Color.red);
                    }else if (i==6){
                        myForm.getLabS7().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS7().setForeground(Color.red);
                    }else if (i==7){
                        myForm.getLabS8().setText("Sample "+myForm.getSampleSelect().getIdSample());
                        myForm.getLabS8().setForeground(Color.red);
                    }
                    
                } else {
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "The microplate must contain only one type of analysis", "Create microplate", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                arrayFinalSample[0] = (myForm.getSampleSelect());
                myForm.getLabS1().setText("Sample "+myForm.getSampleSelect().getIdSample());
                myForm.getLabS1().setForeground(Color.red);
            }

            if (nbSampleSave == 7) {
                myForm.getButAdd().setEnabled(false);
            }
        }

        if (e.getSource().equals(myForm.getButValid())) {
            if (myForm.getNameMicro().getText().isEmpty()) {
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The microplate must have a name", "Create microplate", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Microplaque microP = new Microplaque(myForm.getNameMicro().getText());
                myForm.getLeMenuP().getLeMenu2().getListMicroplaques().add(microP);
                int i = 0;
                while (i < arrayFinalSample.length && arrayFinalSample[i] != null) {
                    microP.addSample(arrayFinalSample[i]);
                    i++;
                }
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The microplate is registered", "Create microplate", JOptionPane.INFORMATION_MESSAGE);
                myForm.getLeMenuP().afficheMenuTechnician();
            }
        } else if (e.getSource().equals(myForm.getButRetour())) {
            myForm.getLeMenuP().afficheMenuTechnician();
        }
    }

}
