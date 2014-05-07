/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import cryptohelper.Studente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lorenzo
 */
public class HomePanel {
    
    
   
    private JLabel welcomeLabel;
    private JPanel homePanel;
    
    public HomePanel(JPanel contentPanel, Studente student){
        welcomeLabel = new JLabel("Benvenuto "+student.getNome());
        homePanel = new JPanel();
        
        contentPanel.add(welcomeLabel, BorderLayout.NORTH);
        new NavPanel(contentPanel);
        contentPanel.add(homePanel, BorderLayout.CENTER);
        contentPanel.validate();
    }
}
