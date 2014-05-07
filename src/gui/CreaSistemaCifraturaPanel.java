/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import cryptohelper.Studente;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author lorenzo
 */
public class CreaSistemaCifraturaPanel {
    
    
    private JPanel creaSistemaCifraturaPanel;
    private JPanel cscChiavePanel;
    private JLabel cscChiaveLabel;
    private JPanel cscChiaveTFPanel;
    private JTextField cscChiaveTField;
    private JPanel cscGroupPanel;
    private JRadioButton cscParolaChiaveJTButton;
    private JRadioButton cscPseudoJRButton;
    private JRadioButton cscCesareJRButton;
    private JPanel cscCreaPanel;
    private JButton cscCreaButton;
    
    public CreaSistemaCifraturaPanel(JPanel contentPanel, Studente student){
        
        creaSistemaCifraturaPanel = new JPanel();
        
        cscChiaveLabel = new JLabel("Inserisci la chiave per calcolare il sistema di cifratura e poi scegli il sistema di cifratura che vuoi usare");
        cscChiaveTField = new JTextField(16);
        cscParolaChiaveJTButton = new JRadioButton("Calcolatore a ParolaChiave");
        cscPseudoJRButton = new JRadioButton("Calcolatore PseudoCasuale");
        cscCesareJRButton = new JRadioButton("Calcolatore di Cesare");
        cscCreaPanel = new JPanel();
        cscCreaButton = new JButton("Crea");
        cscChiavePanel = new JPanel();
        cscChiaveTFPanel = new JPanel();
        cscGroupPanel = new JPanel();
        
        
        ButtonGroup group = new ButtonGroup();
        group.add(cscParolaChiaveJTButton);
        group.add(cscPseudoJRButton);
        group.add(cscCesareJRButton);

        
        creaSistemaCifraturaPanel.setLayout(new GridLayout(4,1));
        cscChiavePanel.add(cscChiaveLabel);
        cscChiaveTFPanel.add(cscChiaveTField);
        cscGroupPanel.add(cscParolaChiaveJTButton);
        cscGroupPanel.add(cscPseudoJRButton);
        cscGroupPanel.add(cscCesareJRButton);
        cscCreaPanel.add(cscCreaButton);
        
        creaSistemaCifraturaPanel.add(cscChiavePanel);
        creaSistemaCifraturaPanel.add(cscChiaveTFPanel);
        creaSistemaCifraturaPanel.add(cscGroupPanel);
        creaSistemaCifraturaPanel.add(cscCreaPanel);
        contentPanel.add(creaSistemaCifraturaPanel);
        contentPanel.validate();
    }
}
