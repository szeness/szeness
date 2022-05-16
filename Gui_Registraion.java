package gui;

import game.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class Gui_Registraion {


    JTextField name = new JTextField();
    JPasswordField passwordReg = new JPasswordField();
    JFrame framzzLogin = new JFrame();
    static JLabel wp1 = new JLabel();
    JLabel nameRegText = new JLabel("Name");
    JLabel usernameText = new JLabel("Username");
    JLabel passwordText = new JLabel("Password");
    JButton buttonNLogin = new JButton();
    JButton buttonNReg = new JButton();

    public void run() {



        framzzLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framzzLogin.setSize(1024, 1000);
        framzzLogin.setBackground(Color.BLACK);
        framzzLogin.setLayout(null);
        framzzLogin.addKeyListener(new KeyHandler());
        framzzLogin.setVisible(true);
        framzzLogin.setLayout(null);
        framzzLogin.toFront();
        framzzLogin.setState(Frame.NORMAL);
        framzzLogin.getContentPane().setBackground(Color.black);

        nameRegText.setLocation(150, 215);
        nameRegText.setSize(150, 25);
        nameRegText.setBackground(Color.BLACK);
        nameRegText.setForeground(Color.WHITE);
        nameRegText.setVisible(true);
        framzzLogin.add(nameRegText);

        name.setLocation(215, 215);
        name.setSize(228, 25);
        name.setVisible(true);
        framzzLogin.add(name);

        usernameText.setLocation(150, 215);
        usernameText.setSize(150, 25);
        usernameText.setBackground(Color.BLACK);
        usernameText.setForeground(Color.WHITE);
        usernameText.setVisible(true);
        framzzLogin.add(usernameText);


        passwordText.setLocation(150, 250);
        passwordText.setSize(150, 25);
        passwordText.setBackground(Color.BLACK);
        passwordText.setForeground(Color.WHITE);
        passwordText.setVisible(true);
        framzzLogin.add(passwordText);

        passwordReg.setLocation(215, 250);
        passwordReg.setSize(228, 25);
        passwordReg.setVisible(true);
        passwordReg.setEchoChar('*');
        framzzLogin.add(passwordReg);




        wp1 = new JLabel();
        wp1.setBounds(0, 0, 1024, 768);
        wp1.setIcon(Gui.icon);
        wp1.setBackground(Color.red);
        framzzLogin.add(wp1);
        wp1.setVisible(true);





    }
}