/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import scrum.Interface.MenuPrincipal;

/**
 *
 * @author Paul
 */
public class Scrum extends JFrame{
    
    private MenuPrincipal menuPrincipal;
    
    public Scrum(){
        menuPrincipal = new MenuPrincipal(this);
        
        this.add(menuPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Genindexe");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Scrum();
            }
        });
    }
    
}
