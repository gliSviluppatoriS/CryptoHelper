/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import cryptohelper.Studente;
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
import model.DBController;



/**
 *
 * @author lorenzo
 */
public class RegisterPanel extends JPanel{
    
    private JPanel registerPanel;
    private JPanel registerInfoPanel;
    private JLabel registerInfoLabel;
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
        registerInfoPanel = new JPanel();
        registerInfoLabel = new JLabel("");
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
        
        registerButton.addActionListener(new RegisterAction(contentPanel));
        
        registerPanel.setLayout(new GridLayout(7,1));
        registerInfoPanel.add(registerInfoLabel);
        registerPanel.add(registerInfoPanel);
        
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
    }
    
    private class RegisterAction implements ActionListener{
        
        private JPanel contentPanel;
        
        public RegisterAction(JPanel cp){
            contentPanel = cp;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String user = registerNickTField.getText();
            String pwd = registerPwdTField.getText();
            String rePwd = registerAgainPwdTField.getText();
            String nome = registerNameTField.getText();
            String cognome = registerSurnameTField.getText();
            if(user.equals("") || pwd.equals("") || rePwd.equals("") || nome.equals("") || cognome.equals(""))
                registerInfoLabel.setText("ERRORE, Almeno uno dei campi vuoto");
            else if(!pwd.equals(rePwd))
                registerInfoLabel.setText("ERRORE, Le due PassWord non coincidono");
            else{
                Studente st = DBController.inserisciStudente(user, pwd, nome, cognome);
                if(st == null)
                    registerInfoLabel.setText("ERRORE, Username o PassWord errati");
                        else{
                            contentPanel.remove(registerPanel);
                            new HomePanel(contentPanel, st);
                        }
            }
        }
        
    }
}
