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
    
    private JPanel navPanel;
    private JButton navInviaButton;
    private JButton navControllaPostaButton;
    //private JButton spiaButton; // da aggiungere in seguito con UC2
    private JButton navEsciButton;
    private JLabel welcomeLabel;
    private JPanel homePanel;
    
    public HomePanel(JPanel contentPanel, Studente student){
        welcomeLabel = new JLabel("Benvenuto "+student.getNome());
        navPanel = new JPanel();
        navInviaButton = new JButton("Invia msg");
        navControllaPostaButton = new JButton("Controlla Posta");
        navEsciButton = new JButton("Esci");
        homePanel = new JPanel();
        
        navPanel.setLayout(new GridLayout(3,1));
        navPanel.add(navInviaButton);
        navPanel.add(navControllaPostaButton);
        navPanel.add(navEsciButton);
        
        contentPanel.add(welcomeLabel, BorderLayout.NORTH);
        contentPanel.add(navPanel, BorderLayout.WEST);
        contentPanel.add(homePanel, BorderLayout.CENTER);
        contentPanel.validate();
    }
}
