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
public class NavPanel {
    private JPanel navPanel;
    private JPanel navScegliPanel;
    private JLabel navScegliLabel;
    private JPanel navCreaCifraturaPanel;
    private JButton navCreaCifraturaButton;
    private JPanel navInviaPanel;
    private JButton navInviaButton;
    private JPanel navControllaPostaPanel;
    private JButton navControllaPostaButton;
    //private JPanel navSpiaPanel; 
    //private JButton navSpiaButton; // da aggiungere in seguito con UC2
    private JPanel navEsciPanel;
    private JButton navEsciButton;

    public NavPanel(JPanel contentPanel, Studente st) {
        navPanel = new JPanel();
        navScegliPanel = new JPanel();
        navCreaCifraturaPanel = new JPanel();
        navInviaPanel = new JPanel();
        navControllaPostaPanel = new JPanel();
        navEsciPanel = new JPanel();
        navScegliLabel = new JLabel("Benvenuto "+ st.getNome() +" Scegli cosa vuoi fare");
        navCreaCifraturaButton = new JButton("Crea sistema di Cifratura");
        navInviaButton = new JButton("Invia msg");
        navControllaPostaButton = new JButton("Controlla Posta");
        navEsciButton = new JButton("LogOut");
        
        navPanel.setLayout(new GridLayout(5,1));
        navScegliPanel.add(navScegliLabel); 
        
        navCreaCifraturaPanel.add(navCreaCifraturaButton);
        navInviaPanel.add(navInviaButton);
        navControllaPostaPanel.add(navControllaPostaButton);
        navEsciPanel.add(navEsciButton);
        
        navPanel.add(navScegliPanel);
        navPanel.add(navCreaCifraturaPanel);
        navPanel.add(navInviaPanel);
        navPanel.add(navControllaPostaPanel);
        navPanel.add(navEsciPanel);
        
        contentPanel.add(navPanel, BorderLayout.CENTER);
        contentPanel.validate();
    }
    
    
    
}
