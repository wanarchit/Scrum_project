package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormFirstRead;

/**
 *
 * @author Paul
 */
public class FormFirstRead extends JPanel{
    
    private MenuTechnician myMenu;
    private SelectMicroplate choixMP;
    
    private JTextField xValue;
    private JTextField xInterp;
    private JButton saveAnalyse;
    
    private JButton butRetour;
    private JButton butValider;
    private CtrlFormFirstRead controleur;
    
    public FormFirstRead (MenuTechnician leMenu){
        myMenu = leMenu;
        controleur = new CtrlFormFirstRead(this);
        JPanel panHead = new JPanel();
        panHead.add(new JLabel("FIRST READ"));
        
        //choixMP = new SelectMicroplate(myMenu);
        
        
        // info sample
        JLabel labelTypeTest = new JLabel();
        labelTypeTest.setText("Type de test : "+"Scrapie Test"); // mettre nom test selon sample
        JPanel panTypeTest = new JPanel();
        panTypeTest.add(labelTypeTest);
        
        JLabel labelIdSample = new JLabel();
        labelIdSample.setText("Sample : "+"1"); // mettre ID selon sample
        JPanel panIdSample = new JPanel();
        panIdSample.add(labelIdSample);
        
        JLabel labelValNorm1 = new JLabel();
        labelValNorm1.setText("Valeur normale position: "+"10"); // mettre valeur normale selon test
        JLabel labelValNorm2 = new JLabel();
        labelValNorm2.setText("Valeur normale pic: "+"50"); // mettre valeur normale selon test
        JPanel panValNorm = new JPanel(new GridLayout(2,1));
        panValNorm.add(labelValNorm1);
        panValNorm.add(labelValNorm2);
        
        JLabel labelValX = new JLabel("Sample value : ");
        xValue = new JTextField(20);
        JPanel panValX = new JPanel();
        panValX.add(labelValX);
        panValX.add(xValue);
        
        JLabel labelInterpX = new JLabel("Interpretation : ");
        xInterp = new JTextField(20);
        JPanel panInterpX = new JPanel();
        panInterpX.add(labelInterpX);
        panInterpX.add(xInterp);
        
        
        JPanel panStatut = new JPanel();
        //panStatut.add();
        
        saveAnalyse = new JButton("Next Sample");
        saveAnalyse.addActionListener(controleur);
        //JPanel panButVal() = new JPanel();
        
        
        JPanel panDroite = new JPanel();
        
        panDroite.add(new JLabel("toto"));
        // fin info sample
        
        
        JPanel centerPan = new JPanel(new GridLayout(1,2));
        centerPan.add(choixMP);
        centerPan.add(panDroite);
        
        
       
        JPanel panButton = new JPanel(new GridLayout(1,2));
        JPanel panButVal = new JPanel();
        butValider = new JButton("Terminer");
        panButVal.add(butValider);
        butValider.addActionListener(controleur);
        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        panButRetour.add(butRetour);
        butRetour.addActionListener(controleur);
        panButton.add(panButRetour);
        panButton.add(panButVal);
        
        this.setLayout(new BorderLayout());
        this.add(panHead,BorderLayout.NORTH);
        this.add(centerPan,BorderLayout.CENTER);
        this.add(panButton,BorderLayout.SOUTH);
        
        
    }
    
    public MenuTechnician getMenuPrincipal(){
        return myMenu;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
    
    public JButton getButValider(){
        return butRetour;
    }
    
    public JButton getButNextAnalyse(){
        return saveAnalyse;
    }
}
