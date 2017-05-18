package scrum.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import scrum.Interface.FormSpecies;
import scrum.noyau.Specie;
import scrum.noyau.SpecieCategory;

/**
 *
 * @author Delphine
 */
public class CtrlFormSpecie implements ActionListener {

    private FormSpecies monFormulaire;

    public CtrlFormSpecie(FormSpecies formulaire) {
        monFormulaire = formulaire;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(monFormulaire.getButValider())) { //button validate
            if (monFormulaire.getValFieldNom().getText().isEmpty()) {
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "The specie name field is empty", "Create Specie", JOptionPane.INFORMATION_MESSAGE);
            } else { //name is not empty --> to upper case
                String SpecieName = monFormulaire.getValFieldNom().getText();
                SpecieName = SpecieName.toLowerCase();
                String[] words2 = SpecieName.split(" ");
                String finalSpecieName = "";
                for (int i = 0; i < words2.length; i++) {
                    char[] char_table = words2[i].toCharArray();
                    char_table[0] = Character.toUpperCase(char_table[0]);
                    words2[i] = new String(char_table);
                    if (i != words2.length - 1) {
                        finalSpecieName += words2[i] + " ";
                    } else {
                        finalSpecieName += words2[i];
                    }
                }
                
                boolean nameVal = true;
                for (SpecieCategory speCat : monFormulaire.getLeMenu().getLeMenu2().getListCategory()) {
                    for (Specie specy : speCat.getSpecies()) {
                        if (specy.getName().equals(finalSpecieName)) {
                            nameVal = false;
                        }
                    }
                }
                
                if (nameVal) {
                    Specie newSpecie = new Specie(finalSpecieName);
                    monFormulaire.getLeMenu().getLeMenu2().getListSpecie().add(newSpecie);

                    ArrayList<SpecieCategory> listCategory = monFormulaire.getLeMenu().getLeMenu2().getListCategory();
                    for (SpecieCategory specat : listCategory) {
                        if (specat.equals(monFormulaire.getValCombo())) {
                            specat.addSpecie(newSpecie);
                        }
                    }

                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "The new specie is registered", "Create specie", JOptionPane.INFORMATION_MESSAGE);
                    monFormulaire.getLeMenu().afficheMenuSecretary();
                } else {
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "This specie already exists in the data", "Create specie", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (e.getSource().equals(monFormulaire.getButRetour())) {
            monFormulaire.getLeMenu().afficheMenuSecretary();
        }
    }
}

