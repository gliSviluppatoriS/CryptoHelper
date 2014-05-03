/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lorenzo
 */
public class CryptoHelper extends JFrame {
    
    private JPanel contentPanel;
    private LoginPanel lp;
    
    public CryptoHelper(){
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        this.add(contentPanel);
        lp = new LoginPanel(contentPanel);
        //setSize(600,400);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("CryptoHelper 1.0");
    }
    
    public static void main(String[] args) {
        new CryptoHelper();
    }
    
}
