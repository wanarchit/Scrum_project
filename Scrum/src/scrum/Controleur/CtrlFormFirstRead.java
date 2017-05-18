package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scrum.Interface.FormFirstRead;

/**
 *
 * @author Paul
 */
public class CtrlFormFirstRead implements ActionListener{
    
    private FormFirstRead leForm;
    
    public CtrlFormFirstRead(FormFirstRead form){
        leForm = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(leForm.getButRetour())){
            leForm.getMenuPrincipal().afficheMenuTechnician();
        }else if (e.getSource().equals(leForm.getButValider())){
            //
        }else if(e.getSource().equals(leForm.getButNextAnalyse())){
            //
        }
    }
}
