package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.FormOrder;

/**
 *
 * @author Delphine
 */
public class CtrlFormOrder implements ActionListener {
    
    private FormOrder monFormulaire;
    
    public CtrlFormOrder(FormOrder formulaire){
        monFormulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(monFormulaire.getButValider())){
        	monFormulaire.validationForm();
        }else if(e.getSource().equals(monFormulaire.getButRetour())){
            monFormulaire.getLeMenuP().afficheMenuSecretary();
        }
    }
}
