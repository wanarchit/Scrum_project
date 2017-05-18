package scrum.Interface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scrum.noyau.Microplaque;

/**
 *
 * @author Paul
 */
public class SelectMicroplate extends JPanel implements ActionListener{
    
    private ArrayList<Microplaque> listMicroplates;
    private JComboBox<Microplaque> listMPCombo;
    private MenuTechnician myMenu;
    private JButton butSamp1,butSamp2,butSamp3,butSamp4,butSamp5,butSamp6,butSamp7,butSamp8;
    
    public SelectMicroplate(MenuTechnician leMenu){
        myMenu = leMenu;
        //listMicroplates = lesMP;
        
        
        JPanel panListMP = new JPanel();
        listMPCombo = new JComboBox();
        for (Microplaque microPl : myMenu.getLeMenu2().getListMicroplaques()) {
        	listMPCombo.addItem(microPl);
        }
        panListMP.add(listMPCombo);
        
        JPanel panChoixMPGlobal = new JPanel();
        panChoixMPGlobal.add(new JLabel("Microplaque : "));
        panChoixMPGlobal.add(panListMP);
        
        if (myMenu.getLeMenu2().getListMicroplaques().isEmpty()){
            // Mettre message comme quoi il n'y a pas de microplaques
        }else{
            
        }
        
        
        JPanel panelButMP = new JPanel(new GridLayout(2,4));
        butSamp1 = new JButton("Sample 1");
        butSamp2 = new JButton("Sample 2");
        butSamp3 = new JButton("Sample 3");
        butSamp4 = new JButton("Sample 4");
        butSamp5 = new JButton("Sample 5");
        butSamp6 = new JButton("Sample 6");
        butSamp7 = new JButton("Sample 7");
        butSamp8 = new JButton("Sample 8");
        
        panelButMP.add(butSamp1);
        panelButMP.add(butSamp2);
        panelButMP.add(butSamp3);
        panelButMP.add(butSamp4);
        panelButMP.add(butSamp5);
        panelButMP.add(butSamp6);
        panelButMP.add(butSamp7);
        panelButMP.add(butSamp8);
        
        this.setLayout(new GridLayout(2,1));
        this.add(panChoixMPGlobal);
        this.add(panelButMP);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(butSamp1)){
            
        }else if(e.getSource().equals(butSamp2)){
            
        }else if(e.getSource().equals(butSamp3)){
            
        }else if(e.getSource().equals(butSamp4)){
            
        }else if(e.getSource().equals(butSamp5)){
            
        }else if(e.getSource().equals(butSamp6)){
            
        }else if(e.getSource().equals(butSamp7)){
            
        }else if(e.getSource().equals(butSamp8)){
            
        }
    }
    
    
}
