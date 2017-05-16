package scrum.Interface;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.Controleur.CtrlMenuPrincipal;
import scrum.Scrum;
import scrum.noyau.Customer2;

/**
 *
 * @author Paul
 */
public class MenuPrincipal extends JPanel{
    
    private Scrum fenetreMain;
    private JButton butFormCustomer;
    private CtrlMenuPrincipal controleur;
    
    private ArrayList<Customer2> listCustomer;
    
    public MenuPrincipal(Scrum laFenetre){
        fenetreMain = laFenetre;
        controleur = new CtrlMenuPrincipal(this);
        
        // Import of data
        listCustomer = new ArrayList();
        
        JLabel textMenu = new JLabel("Main menu");
        butFormCustomer = new JButton("Create a customer");
        butFormCustomer.addActionListener(controleur);
        
        this.add(textMenu);
        this.add(butFormCustomer);
    }
    
    public Scrum getFenetreMain(){
        return fenetreMain;
    }
    
    public JButton getButFormCustomer(){
        return butFormCustomer;
    }
    
    public void afficheFormCustomer(){
        FormCustomer newForm = new FormCustomer(this);
        fenetreMain.setContentPane(newForm);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public ArrayList<Customer2> getListCustomer(){
        return listCustomer;
    }
}
