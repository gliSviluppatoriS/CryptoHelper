/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author lorenzo
 */
public class NavPanel {
    private JPanel navPanel;
    private JButton navCreaCifraturaButton;
    private JButton navInviaButton;
    private JButton navControllaPostaButton;
    //private JButton spiaButton; // da aggiungere in seguito con UC2
    private JButton navEsciButton;

    public NavPanel(JPanel contentPanel) {
        navPanel = new JPanel();
        navCreaCifraturaButton = new JButton("Crea sistema di Cifratura");
        navInviaButton = new JButton("Invia msg");
        navControllaPostaButton = new JButton("Controlla Posta");
        navEsciButton = new JButton("LogOut");
        
        navPanel.setLayout(new GridLayout(4,1));
        navPanel.add(navCreaCifraturaButton);
        navPanel.add(navInviaButton);
        navPanel.add(navControllaPostaButton);
        navPanel.add(navEsciButton);
        
        contentPanel.add(navPanel, BorderLayout.WEST);
        contentPanel.validate();
    }
    
    
    
}
