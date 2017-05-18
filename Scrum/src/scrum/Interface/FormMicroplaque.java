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
import scrum.noyau.Customer;
import scrum.noyau.Order;
import scrum.noyau.ResultStatus;
import scrum.noyau.Sample;

/**
 *
 * @author Delphine
 */
public class FormMicroplaque extends JPanel {

    private MenuTechnician myMenu;
    private CtrlFormMicroplaque controleur;
    private JLabel labSample1;
    private JLabel labSample2;
    private JLabel labSample3;
    private JLabel labSample4;
    private JLabel labSample5;
    private JLabel labSample6;
    private JLabel labSample7;
    private JLabel labSample8;
    private JButton validateForm;
    private JButton butRetour;
    private JTextField nameMicro;
    private JButton ajouter;
    private JComboBox<Sample> listeSamp;
    private JComboBox<Analysis> listeAna;
    private ArrayList<Sample> myListSample;

    public FormMicroplaque(MenuTechnician leMenu) {
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

        labSample1 = new JLabel("Pos 1 empty");
        labSample1.setBorder(border);
        labSample1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample2 = new JLabel("Pos 2 empty");
        labSample2.setBorder(border);
        labSample2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample3 = new JLabel("Pos 3 empty");
        labSample3.setBorder(border);
        labSample3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample4 = new JLabel("Pos 4 empty");
        labSample4.setBorder(border);
        labSample4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample5 = new JLabel("Pos 5 empty");
        labSample5.setBorder(border);
        labSample5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample6 = new JLabel("Pos 6 empty");
        labSample6.setBorder(border);
        labSample6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample7 = new JLabel("Pos 7 empty");
        labSample7.setBorder(border);
        labSample7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labSample8 = new JLabel("Pos 8 empty");
        labSample8.setBorder(border);
        labSample8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JPanel panelGeneral = new JPanel(new GridBagLayout());
        GridBagConstraints centre = new GridBagConstraints();

        centre.gridx = 0;
        centre.gridy = 0;
        labSample1.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample1, centre);

        centre.gridx = 1;
        centre.gridy = 0;
        labSample2.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample2, centre);

        centre.gridx = 2;
        centre.gridy = 0;
        labSample3.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample3, centre);

        centre.gridx = 3;
        centre.gridy = 0;
        labSample4.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample4, centre);

        centre.gridx = 0;
        centre.gridy = 1;
        labSample5.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample5, centre);

        centre.gridx = 1;
        centre.gridy = 1;
        labSample6.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample6, centre);

        centre.gridx = 2;
        centre.gridy = 1;
        labSample7.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample7, centre);

        centre.gridx = 3;
        centre.gridy = 1;
        labSample8.setPreferredSize(new Dimension(100, 75));
        panelGeneral.add(labSample8, centre);

        JPanel panelDroite = new JPanel(new BorderLayout());
        panelDroite.add(pan1, BorderLayout.NORTH);
        panelDroite.add(panelGeneral, BorderLayout.CENTER);

        //Partie gauche
        JLabel lesAna = new JLabel("The analysis");
        lesAna.setPreferredSize(new Dimension(75, 75));

        JLabel lesSamp = new JLabel("The samples");
        lesSamp.setPreferredSize(new Dimension(75, 75));
        
        ArrayList<Analysis> myListAna = myMenu.getLeMenu2().getListAnalysis();

        myListSample = new ArrayList<Sample>();
        for (Customer cust : myMenu.getLeMenu2().getListCustomer()) {
            for (Order order : cust.getOrders()) {
                if(order.getSamples() != null){
                    for (Sample samp : order.getSamples()) {
                        myListSample.add(samp);
                    }
                }
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
        ArrayList<Sample> sampPrio = new ArrayList<Sample>();
        ArrayList<Sample> sampAutre = new ArrayList<Sample>();
        for (Sample sample : myListSample) {
            if (sample.getAnalysis().equals(anaChoose)) {
                if (!sample.getResults().isEmpty()) {
                    if(sample.getResults().get((sample.getResults().size()) - 1).getStatus() != null){
                        if (sample.getResults().get((sample.getResults().size()) - 1).getStatus().equals(ResultStatus.UNREADABLE))
                            sampPrio.add(sample);
                        else
                            sampAutre.add(sample);
                    }
                    else
                        sampAutre.add(sample);
                }
            }
        }
        for (Sample sample : sampPrio) {
            System.out.println("for sampPrio");
            listeSamp.addItem(sample);
        }

        for (Sample sample : sampAutre) {
            System.out.println("for sampAutre");
            listeSamp.addItem(sample);
        }
    }

    public MenuTechnician getLeMenuP() {
        return myMenu;
    }

    public JButton getButValid() {
        return validateForm;
    }

    public JButton getButRetour() {
        return butRetour;
    }

    public JLabel getLabS1() {
        return labSample1;
    }

    public JLabel getLabS2() {
        return labSample2;
    }

    public JLabel getLabS3() {
        return labSample3;
    }

    public JLabel getLabS4() {
        return labSample4;
    }

    public JLabel getLabS5() {
        return labSample5;
    }

    public JLabel getLabS6() {
        return labSample6;
    }

    public JLabel getLabS7() {
        return labSample7;
    }

    public JLabel getLabS8() {
        return labSample8;
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
