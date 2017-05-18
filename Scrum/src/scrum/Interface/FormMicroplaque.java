package scrum.Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scrum.Controleur.CtrlFormMicroplaque;
import scrum.noyau.Analysis;
import scrum.noyau.Order;
import scrum.noyau.Sample;

/**
 *
 * @author Delphine
 */
public class FormMicroplaque extends JPanel {

    private MenuPrincipal myMenu;
    private CtrlFormMicroplaque controleur;
    private JLabel butSample1;
    private JLabel butSample2;
    private JLabel butSample3;
    private JLabel butSample4;
    private JLabel butSample5;
    private JLabel butSample6;
    private JLabel butSample7;
    private JLabel butSample8;
    private JButton validateForm;
    private JButton butRetour;
    private JTextField nameMicro;
    private JButton ajouter;
    private JComboBox<Sample> listeSamp;
    private JComboBox<Analysis> listeAna;
    private ArrayList<Sample> myListSample;

    public FormMicroplaque(MenuPrincipal leMenu) {
        myMenu = leMenu;
        controleur = new CtrlFormMicroplaque(this);

        // Title
        JLabel headLabel = new JLabel("New Microplaque");
        headLabel.setFont(new java.awt.Font(Font.DIALOG, Font.BOLD, 20));
        headLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        JLabel labName = new JLabel("Name of microplate : ");
        nameMicro = new JTextField(20);
        JPanel pan1 = new JPanel();
        pan1.add(labName);
        pan1.add(nameMicro);

        butSample1 = new JLabel("Sample 1");
        butSample1.setBorder(border);
        butSample1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample2 = new JLabel("Sample 2");
        butSample2.setBorder(border);
        butSample2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample3 = new JLabel("Sample 3");
        butSample3.setBorder(border);
        butSample3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample4 = new JLabel("Sample 4");
        butSample4.setBorder(border);
        butSample4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample5 = new JLabel("Sample 5");
        butSample5.setBorder(border);
        butSample5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample6 = new JLabel("Sample 6");
        butSample6.setBorder(border);
        butSample6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample7 = new JLabel("Sample 7");
        butSample7.setBorder(border);
        butSample7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butSample8 = new JLabel("Sample 8");
        butSample8.setBorder(border);
        butSample8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel panelGeneral = new JPanel(new GridBagLayout());
        GridBagConstraints centre = new GridBagConstraints();

        centre.gridx = 0;
        centre.gridy = 0;
        butSample1.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample1, centre);

        centre.gridx = 1;
        centre.gridy = 0;
        butSample2.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample2, centre);

        centre.gridx = 2;
        centre.gridy = 0;
        butSample3.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample3, centre);

        centre.gridx = 3;
        centre.gridy = 0;
        butSample4.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample4, centre);

        centre.gridx = 0;
        centre.gridy = 1;
        butSample5.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample5, centre);

        centre.gridx = 1;
        centre.gridy = 1;
        butSample6.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample6, centre);

        centre.gridx = 2;
        centre.gridy = 1;
        butSample7.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample7, centre);

        centre.gridx = 3;
        centre.gridy = 1;
        butSample8.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(butSample8, centre);

        JPanel panelDroite = new JPanel(new BorderLayout());
        panelDroite.add(pan1, BorderLayout.NORTH);
        panelDroite.add(panelGeneral, BorderLayout.CENTER);

        //Partie gauche
        JLabel lesAna = new JLabel("The analysis");
        lesAna.setPreferredSize(new Dimension(75, 75));

        JLabel lesSamp = new JLabel("The samples");
        lesSamp.setPreferredSize(new Dimension(75, 75));

        ArrayList<Order> myListOrder = myMenu.getListOrder();
        ArrayList<Analysis> myListAna = myMenu.getListAnalysis();

        myListSample = new ArrayList();
        for (Order or : myListOrder) {
            for (Sample samp : or.getSamples()) {
                myListSample.add(samp);
            }
        }

        //COMBO BOX ANALYSE
        listeAna = new JComboBox<Analysis>();
        for (Analysis ana : myListAna) {
            listeAna.addItem(ana);
        }
        listeAna.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox combo = (JComboBox) e.getSource();
                Analysis anaChoose = (Analysis) combo.getSelectedItem();
                majSample(anaChoose);
            }
        }
        );

        // COMBO BOX SAMPLES
        listeSamp = new JComboBox<>();

        ajouter = new JButton("Add the sample");
        ajouter.addActionListener(controleur);

        JPanel panelGauche = new JPanel(new GridBagLayout());

        centre.gridx = 0;
        centre.gridy = 0;
        panelGauche.add(lesAna, centre);

        centre.gridx = 0;
        centre.gridy = 1;
        panelGauche.add(listeAna, centre);

        centre.gridx = 0;
        centre.gridy = 2;
        panelGauche.add(lesSamp, centre);

        centre.gridx = 0;
        centre.gridy = 3;
        panelGauche.add(listeSamp, centre);

        centre.gridx = 0;
        centre.gridy = 4;
        panelGauche.add(ajouter, centre);

        // Creation of the button to return to the main menu and the validate button
        JPanel panButValid = new JPanel();
        validateForm = new JButton("Valider");
        validateForm.addActionListener(controleur);
        panButValid.add(validateForm);

        JPanel panButRetour = new JPanel();
        butRetour = new JButton("Retour");
        butRetour.addActionListener(controleur);
        panButRetour.add(butRetour);

        JPanel panButtons = new JPanel(new GridLayout(1, 2));
        panButtons.add(panButRetour);
        panButtons.add(panButValid);

        this.setLayout(new BorderLayout());
        this.add(headLabel, BorderLayout.NORTH);
        this.add(panelDroite, BorderLayout.CENTER);
        this.add(panelGauche, BorderLayout.WEST);
        this.add(panButtons, BorderLayout.SOUTH);
    }

    /**
     * Function to allow the modification
     *
     * @param anaChoose The analysis choosen
     */
    private void majSample(Analysis anaChoose) {
        listeSamp.removeAllItems();
        ArrayList<Sample> sampPrio = new ArrayList();
        ArrayList<Sample> sampAutre = new ArrayList();

        for (Sample samp : myListSample) {
            if (samp.getAnalysis().equals(anaChoose)) {
                //ResultStatut 
                if (samp.getResults().size() > 0) {
                    if (samp.getResults().get((samp.getResults().size()) - 1).getStatus().equals("UNREADABLE")) {
                        sampPrio.add(samp);
                    }
                } else {
                    sampAutre.add(samp);
                }
            }
        }
        for (Sample sample : sampPrio) {
            listeSamp.addItem(sample);
        }

        for (Sample sample : sampAutre) {
            listeSamp.addItem(sample);
        }
    }

    public MenuPrincipal getLeMenuP() {
        return myMenu;
    }

    public JButton getButValid() {
        return validateForm;
    }

    public JButton getButRetour() {
        return butRetour;
    }

    public JLabel getButS1() {
        return butSample1;
    }

    public JLabel getButS2() {
        return butSample2;
    }

    public JLabel getButS3() {
        return butSample3;
    }

    public JLabel getButS4() {
        return butSample4;
    }

    public JLabel getButS5() {
        return butSample5;
    }

    public JLabel getButS6() {
        return butSample6;
    }

    public JLabel getButS7() {
        return butSample7;
    }

    public JLabel getButS8() {
        return butSample8;
    }

    public JButton getButAdd() {
        return ajouter;
    }

    public Analysis getAnaSelect() {
        return (Analysis) listeAna.getSelectedItem();
    }

    public Sample getSampleSelect() {
        return (Sample) listeSamp.getSelectedItem();
    }
    
    public JTextField getNameMicro(){
        return nameMicro;
    }
}
