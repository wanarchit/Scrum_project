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
            if (arrayFinalSample.length > 0) {
                System.out.println(arrayFinalSample[1].getAnalysis());
                System.out.println(myForm.getAnaSelect());
                if (arrayFinalSample[1].getAnalysis().equals(myForm.getAnaSelect())) {
                    int i = 1;
                    while (arrayFinalSample[i] != null && i < arrayFinalSample.length) {
                        i++;
                    }
                    arrayFinalSample[i] = (myForm.getSampleSelect());
                    
                    if (i==1){
                        myForm.getButS1().setBackground(Color.WHITE);
                    }
                    
                } else {
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "The microplate must contain only one type of analysis", "Create microplate", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                arrayFinalSample[1] = (myForm.getSampleSelect());
            }

            if (arrayFinalSample.length == 8) {
                myForm.getButAdd().setEnabled(false);
            }
        }

        if (e.getSource().equals(myForm.getButValid())) {
            if (myForm.getNameMicro().getText().isEmpty()) {
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The microplate must have a name", "Create microplate", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Microplaque microP = new Microplaque(myForm.getNameMicro().getText());
                myForm.getLeMenuP().getListMicroplaques().add(microP);
                int i = 0;
                while (arrayFinalSample[i] != null && i < arrayFinalSample.length) {
                    i++;
                    microP.addSample(arrayFinalSample[i]);
                }
            }

        } else if (e.getSource().equals(myForm.getButRetour())) {
            myForm.getLeMenuP().afficheMenuPrincipal();
        }
    }

}
