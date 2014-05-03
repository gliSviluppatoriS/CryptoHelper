/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;



/**
 *
 * @author lorenzo
 */
public class RegisterPanel extends JPanel{
    
    private JPanel registerPanel;
    private JPanel registerNickPanel;
    private JLabel registerNickLabel;
    private JTextField registerNickTField;
    private JPanel registerPwdPanel;
    private JLabel registerPwdLabel;
    private JPasswordField registerPwdTField;
    private JPanel registerAgainPwdPanel;
    private JLabel registerAgainPwdLabel;
    private JPasswordField registerAgainPwdTField;
    private JPanel registerNamePanel;
    private JLabel registerNameLabel;
    private JTextField registerNameTField;
    private JPanel registerSurnamePanel;
    private JLabel registerSurnameLabel;
    private JTextField registerSurnameTField;
    private JButton registerButton;
    
    public RegisterPanel(JPanel contentPanel){
        
        registerPanel = new JPanel();
        registerNickPanel = new JPanel();
        registerNickLabel = new JLabel("Inserisci il tuo Username");
        registerNickTField = new JTextField(16);
        registerPwdPanel = new JPanel();
        registerPwdLabel = new JLabel("Inserisci una Password");
        registerPwdTField = new JPasswordField(16);
        registerAgainPwdPanel = new JPanel();
        registerAgainPwdLabel = new JLabel("Reinserisci la Password");
        registerAgainPwdTField = new JPasswordField(16);
        registerNamePanel = new JPanel();
        registerNameLabel = new JLabel("Inserisci il tuo nome");
        registerNameTField = new JTextField(16);
        registerSurnamePanel = new JPanel();
        registerSurnameLabel = new JLabel("Inserisci il tuo cognome");
        registerSurnameTField = new JTextField(16);
        registerButton = new JButton("Registrati");
        registerPanel.setLayout(new GridLayout(6,1));
        registerNickPanel.add(registerNickLabel);
        registerNickPanel.add(registerNickTField);
        registerPanel.add(registerNickPanel);
        
        registerPwdPanel.add(registerPwdLabel);
        registerPwdPanel.add(registerPwdTField);
        registerPanel.add(registerPwdPanel);
        
        registerAgainPwdPanel.add(registerAgainPwdLabel);
        registerAgainPwdPanel.add(registerAgainPwdTField);
        registerPanel.add(registerAgainPwdPanel);
        
        registerNamePanel.add(registerNameLabel);
        registerNamePanel.add(registerNameTField);
        registerPanel.add(registerNamePanel);
        
        registerSurnamePanel.add(registerSurnameLabel);
        registerSurnamePanel.add(registerSurnameTField);
        registerPanel.add(registerSurnamePanel);
        registerPanel.add(registerButton);
        
        contentPanel.add(registerPanel, BorderLayout.CENTER);
        contentPanel.validate();
        System.out.println("e qui ci arriva!!");
    }
    
    private class RegisterAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
