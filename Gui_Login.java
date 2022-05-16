package gui;

import database.DbConnection;
import game.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Gui_Login {

    JTextField usernameL = new JTextField();
    JPasswordField passwordL = new JPasswordField();
    JFrame framzz = new JFrame();
    static JLabel wp1 = new JLabel();
    JLabel usernameText = new JLabel("Username");
    JLabel passwordText = new JLabel("Password");
    JButton buttonNLogin = new JButton();
    JButton buttonNReg = new JButton();
    JButton createUser = new JButton();

    JLabel nameRegText = new JLabel("Name");
    JTextField nameReg = new JTextField();
    JLabel lastNameRegText = new JLabel("Last Name");
    JTextField lastNameReg = new JTextField();
    JLabel usernameRegText = new JLabel("Username");
    JTextField usernameReg = new JTextField();
    JLabel passwordRegText = new JLabel("Password");
    JPasswordField passwordReg = new JPasswordField();
    JTextArea konsoleArea = new JTextArea();


    public void run() {


        framzz = new Gui();

        framzz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framzz.setSize(1024, 1000);
        framzz.setBackground(Color.BLACK);
        framzz.setLayout(null);
        framzz.addKeyListener(new KeyHandler());
        framzz.setVisible(true);
        framzz.setLayout(null);
        framzz.toFront();
        framzz.setState(Frame.NORMAL);
        framzz.getContentPane().setBackground(Color.black);

        usernameText.setLocation(150,215);
        usernameText.setSize(150,25);
        usernameText.setBackground(Color.BLACK);
        usernameText.setForeground(Color.WHITE);
        usernameText.setVisible(true);
        framzz.add(usernameText);


        passwordText.setLocation(150,250);
        passwordText.setSize(150,25);
        passwordText.setBackground(Color.BLACK);
        passwordText.setForeground(Color.WHITE);
        passwordText.setVisible(true);
        framzz.add(passwordText);

        passwordL.setLocation(215, 250);
        passwordL.setSize(228, 25);
        passwordL.setVisible(true);
        passwordL.setEchoChar('*');
        framzz.add(passwordL);

        usernameL.setLocation(215, 215);
        usernameL.setSize(228, 25);
        usernameL.setVisible(true);
        framzz.add(usernameL);

        buttonNLogin = new JButton("Login");
        buttonNLogin.setSize(120,35);
        buttonNLogin.setLocation(205,285);
        buttonNLogin.setFont(new Font("Arial", Font.BOLD, 12));
        buttonNLogin.setFocusable(false);
        buttonNLogin.setBackground(new Color(49, 15, 72, 255));
        buttonNLogin.setForeground(new Color(173, 123, 127, 255));
        framzz.add(buttonNLogin);
        buttonNLogin.setVisible(true);
        buttonNLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "Select * from Users where Username LIKE ? AND Kennwort like ?;";

                Connection connectToDataBase = DbConnection.connect();
                PreparedStatement ps = null;
                ResultSet rs;

                try {
                    ps = connectToDataBase.prepareStatement(sql);
                    ps.setString(1, usernameL.getText());
                    ps.setString(2, passwordL.getText());
                    rs = ps.executeQuery();

                    if(rs.next()) {
                        System.out.println("Welcome " + usernameL.getText());
                        //JOptionPane.showMessageDialog(null, "Welcome "+ nameField);
                    } else {
                        //System.out.println("Falsche anmelde daten");
                        JOptionPane.showMessageDialog(null, "Falsche anmelde daten");
                    }

                    //while(rs.next()) {
                    //	String Name = rs.getString("Name");
                    //JOptionPane.showMessageDialog(null, Name);
                    //	System.out.println("Name :" + Name);
                    //}
                } catch(Exception a) {
                    System.out.println(a.toString());
                } finally {
                    try {
                        //rs.close();
                        ps.close();
                        connectToDataBase.close();
                    } catch(Exception a) {
                        System.out.println(a.toString());
                    }
                }

                //System.out.println("Login Button Testen");
            }
        });


        buttonNReg = new JButton("New User");
        buttonNReg.setSize(120,35);
        buttonNReg.setLocation(330,285);
        buttonNReg.setFont(new Font("Arial", Font.BOLD, 12));
        buttonNReg.setFocusable(false);
        buttonNReg.setBackground(new Color(49, 15, 72, 255));
        buttonNReg.setForeground(new Color(173, 123, 127, 255));
        framzz.add(buttonNReg);
        buttonNReg.setVisible(true);
        buttonNReg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            usernameText.setVisible(false);
            usernameL.setVisible(false);
            passwordText.setVisible(false);
            passwordL.setVisible(false);
            buttonNReg.setVisible(false);
            buttonNLogin.setVisible(false);

            nameReg.setVisible(true);
            nameRegText.setVisible(true);
            lastNameReg.setVisible(true);
            lastNameRegText.setVisible(true);
            usernameReg.setVisible(true);
            usernameRegText.setVisible(true);
            passwordReg.setVisible(true);
            passwordRegText.setVisible(true);
            createUser.setVisible(true);


            wp1.setVisible(false);
            wp1.setVisible(true);

            konsoleArea.setText("Create User");

            }
        });





///////////////////////////////////////////

        nameRegText.setLocation(150, 215);
        nameRegText.setSize(150, 25);
        nameRegText.setBackground(Color.BLACK);
        nameRegText.setForeground(Color.WHITE);
        nameRegText.setVisible(false);
        framzz.add(nameRegText);

        nameReg.setLocation(215, 215);
        nameReg.setSize(228, 25);
        nameReg.setVisible(false);
        framzz.add(nameReg);

        lastNameRegText.setLocation(150, 245);
        lastNameRegText.setSize(150, 25);
        lastNameRegText.setBackground(Color.BLACK);
        lastNameRegText.setForeground(Color.WHITE);
        lastNameRegText.setVisible(false);
        framzz.add(lastNameRegText);

        lastNameReg.setLocation(215, 245);
        lastNameReg.setSize(228, 25);
        lastNameReg.setVisible(false);
        framzz.add(lastNameReg);

        usernameRegText.setLocation(150, 275);
        usernameRegText.setSize(150, 25);
        usernameRegText.setBackground(Color.BLACK);
        usernameRegText.setForeground(Color.WHITE);
        usernameRegText.setVisible(false);
        framzz.add(usernameRegText);

        usernameReg.setLocation(215, 275);
        usernameReg.setSize(228, 25);
        usernameReg.setVisible(false);
        framzz.add(usernameReg);

        passwordRegText.setLocation(150, 305);
        passwordRegText.setSize(150, 25);
        passwordRegText.setBackground(Color.BLACK);
        passwordRegText.setForeground(Color.WHITE);
        passwordRegText.setVisible(false);
        framzz.add(passwordRegText);


        passwordReg.setLocation(215, 305);
        passwordReg.setSize(228, 25);
        passwordReg.setVisible(false);
        passwordReg.setEchoChar('*');
        framzz.add(passwordReg);


        createUser = new JButton("Create User");
        createUser.setSize(120,35);
        createUser.setLocation(260,340);
        createUser.setFont(new Font("Arial", Font.BOLD, 12));
        createUser.setFocusable(false);
        createUser.setBackground(new Color(49, 15, 72, 255));
        createUser.setForeground(new Color(173, 123, 127, 255));
        framzz.add(createUser);
        createUser.setVisible(false);
        createUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "insert into Users values(?,?,?,?)";
                Connection con = DbConnection.connect();	//	Verbindung zur Datenbank wird hier erstellt
                PreparedStatement ps = null;
                try{
                    String sql = "INSERT INTO Users(Name, Vorname, Username, Kennwort) VALUES(?,?,?,?) ";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, lastNameReg.getText());
                    ps.setString(2, nameReg.getText());
                    ps.setString(3, usernameReg.getText());
                    ps.setString(4, passwordReg.getText());
                    //	if(textFieldName == null)
                    ps.execute();
                    konsoleArea.setText("Erfolgreich registriert!");

                    usernameText.setVisible(true);
                    usernameL.setVisible(true);
                    passwordText.setVisible(true);
                    passwordL.setVisible(true);
                    buttonNReg.setVisible(true);
                    buttonNLogin.setVisible(true);

                    nameReg.setVisible(false);
                    nameRegText.setVisible(false);
                    lastNameReg.setVisible(false);
                    lastNameRegText.setVisible(false);
                    usernameReg.setVisible(false);
                    usernameRegText.setVisible(false);
                    passwordReg.setVisible(false);
                    passwordRegText.setVisible(false);
                    createUser.setVisible(false);

                    wp1.setVisible(false);
                    wp1.setVisible(true);



                } catch (Exception a) {
                    //konsoleArea.setText(a.toString());
                    konsoleArea.append("\nThis username is already in use");
                }
            }
        });




        konsoleArea = new JTextArea();
        konsoleArea.setForeground(new Color(199, 18, 18));
        konsoleArea.setFont(new Font("Arial", Font.PLAIN, 18));
        konsoleArea.setSize(800, 250);
        konsoleArea.setBackground(Color.BLACK);
        konsoleArea.setFocusable(false);
        konsoleArea.setCaretColor(Color.RED);
        konsoleArea.setLocation(100, 770);
        framzz.getContentPane().setBackground(Color.black);
        konsoleArea.setOpaque(false);
        framzz.add(konsoleArea);
        konsoleArea.setVisible(false);
        konsoleArea.setVisible(true);




        wp1 = new JLabel();
        wp1.setBounds(0, 0, 1024, 768);
        wp1.setIcon(Gui.icon);
        wp1.setBackground(Color.red);
        framzz.add(wp1);
        wp1.setVisible(true);
        wp1.setVisible(false);
        wp1.setVisible(true);




    }
}