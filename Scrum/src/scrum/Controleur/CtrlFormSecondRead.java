package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.FormSecondRead;

/**
 *
 * @author Marin
 */
public class CtrlFormSecondRead implements ActionListener {
    private FormSecondRead myForm;
    
    
    public CtrlFormSecondRead(FormSecondRead form){
        myForm=form;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButRetour())){
            myForm.getLeMenu().afficheMenuTechnician();
        }
    }
}