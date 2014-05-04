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
import javax.swing.JTextField;
import model.DBController;

/**
 *
 * @author lorenzo
 */
public class LoginPanel extends JPanel {
    
    private JPanel loginPanel;
    private JPanel loginInfoPanel;
    private JLabel loginInfoLabel;
    private JPanel loginNickPanel;
    private JLabel loginNickLabel;
    private JTextField loginNickTField;
    private JPanel loginPwdPanel;
    private JLabel loginPwdLabel;
    private JPasswordField loginPwdTField;
    private JPanel loginButtonPanel;
    private JButton loginButton;
    private JPanel loginRegistratiPanel;
    private JButton loginRegistratiButton;
    
    public LoginPanel(JPanel contentPanel){
        loginPanel = new JPanel();
        loginNickPanel = new JPanel();
        loginInfoPanel = new JPanel();
        loginInfoLabel = new JLabel("");
        loginNickLabel = new JLabel("Inserisci il tuo Username");
        loginNickTField = new JTextField(16);
        loginPwdPanel = new JPanel();
        loginPwdLabel = new JLabel("Inserisci la tua Password");
        loginPwdTField = new JPasswordField(16);
        loginButtonPanel = new JPanel();
        loginButton = new JButton("Login");
        loginRegistratiPanel = new JPanel();
        loginRegistratiButton = new JButton("Registrati");
        loginPanel.setLayout(new GridLayout(5,1));
        loginInfoPanel.add(loginInfoLabel);
        loginPanel.add(loginInfoPanel);
        
        loginNickPanel.add(loginNickLabel);
        loginNickPanel.add(loginNickTField);
        loginPanel.add(loginNickPanel);
        
        loginPwdPanel.add(loginPwdLabel);
        loginPwdPanel.add(loginPwdTField);
        loginPanel.add(loginPwdPanel);
        
        loginButtonPanel.add(loginButton);
        loginPanel.add(loginButtonPanel);
        
        loginRegistratiPanel.add(loginRegistratiButton);
        loginPanel.add(loginRegistratiPanel);
        loginButton.addActionListener((ActionListener) new LoginAction(contentPanel));
        loginRegistratiButton.addActionListener((ActionListener) new LoginAction(contentPanel));
        contentPanel.add(loginPanel, BorderLayout.CENTER);
        contentPanel.validate(); 
    }
    
    private class LoginAction implements ActionListener{
        
        private JPanel contentPanel;
        
        public LoginAction(JPanel cp){
            contentPanel = cp;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Login")){
                    String user = loginNickTField.getText();
                    String pwd = loginPwdTField.getText();
                    if(user.equals("") || pwd.equals(""))
                        loginInfoLabel.setText("ERRORE, Username o PassWord mancanti");
                    else{
                        Studente st = DBController.analizeLogin(user, pwd);
                        if(st == null)
                            loginInfoLabel.setText("ERRORE, Username o PassWord errati");
                        else{
                            contentPanel.remove(loginPanel);
                            new HomePanel(contentPanel, st);
                        }
                    }
            }
            if (command.equals("Registrati")){
                contentPanel.remove(loginPanel);
                new RegisterPanel(contentPanel);   
            }
        }
        
    }
}

/*
ImageIcon icon = new ImageIcon("images/icon.gif");
JButton button2 = new JButton(icon);
*/
