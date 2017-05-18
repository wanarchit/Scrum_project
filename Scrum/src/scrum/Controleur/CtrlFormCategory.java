package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import scrum.Interface.FormCategory;
import scrum.noyau.Customer2;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Marin
 */
public class CtrlFormCategory implements ActionListener{
    private FormCategory myForm;
    private ArrayList<SpecieCategory> listCat;
    
    public CtrlFormCategory(FormCategory form){
        myForm=form;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myForm.getButValid())){
            String Category = myForm.getCategory().getText();
            System.out.println("get field : "+Category);//test
            Category=Category.toLowerCase();
            
            boolean validation = true;
            if(Category.isEmpty()){
                JOptionPane boiteVide= new JOptionPane();
                boiteVide.showMessageDialog(null, "Empty category field, please fill it !", "Empty field", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                for(SpecieCategory cat : myForm.getLeMenuP().getLeMenu2().getListCategory()){
                    if(cat.getName().toLowerCase().equals(Category)){
                        validation = false;
                        JOptionPane boiteDial = new JOptionPane();
                        boiteDial.showMessageDialog(null, "Specie's category already exists !", "Create category", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if(validation){
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "Registering done", "Create category", JOptionPane.INFORMATION_MESSAGE);
                    SpecieCategory sp= new SpecieCategory(Category);
                    myForm.getLeMenuP().getLeMenu2().getListCategory().add(sp);
                    myForm.getLeMenuP().afficheMenuSecretary();
                }
            }
            
        }else if(e.getSource().equals(myForm.getButRetour())){
            myForm.getLeMenuP().afficheMenuSecretary();
        }
    } 
}
