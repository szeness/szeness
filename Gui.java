package gui;

import database.DbConnection;
import game.Credit;
import game.Engine;
import game.KeyHandler;
import game.Profil_LoginEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class Gui extends JFrame implements MouseListener, FocusListener {



    public static ImageIcon iconwp = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/explo.png")));
    public static ImageIcon rauteAssp = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/RauteAss.png")));
    public static ImageIcon karo2p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Karo2.png")));
    public static ImageIcon pick3p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Pick3.png")));
    public static ImageIcon raute4p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Karo4.png")));
    public static ImageIcon herz5p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Herz5.png")));
    public static ImageIcon pick6p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Pick6.png")));
    public static ImageIcon herz7p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Herz7.png")));
    public static ImageIcon raute8p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Raute8.png")));
    public static ImageIcon pick9p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/Pick9.png")));
    public static ImageIcon pickKing = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/PickKing.png")));
    public static ImageIcon herzBubeP = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/HerzBube.png")));
    public static ImageIcon herzDamep = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/HerzDame.png")));
    public static ImageIcon exlpo2 = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/firez.png")));
    public static ImageIcon womanp = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/bj.png")));
    public static ImageIcon m6p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/m6.png")));
    public static ImageIcon icon = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/242002505_1252775645170726_3784503533134612784_n.jpg")));
    public static ImageIcon bg2p = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/bg2.png")));
    public static ImageIcon bgP = new ImageIcon(Objects.requireNonNull(Gui.class.getResource("img/bgP.png")));

    public static Gui framzz;
    public static JButton buttonNLogin = new JButton("Anmelden");
    public static JButton buttonN;
    public static JButton buttonC;
    public static JButton buttonX;
    public static JButton buttonD;
    public static JButton buttonS;
    public static JTextArea textArea5 = new JTextArea();
    public static JTextArea textArea4 = new JTextArea();
    public static JTextArea textArea3 = new JTextArea();

    public static JLabel dot = new JLabel();
    public static JLabel cardFire = new JLabel();
    public static JLabel dot2 = new JLabel();
    public static JLabel wp;
    public static JLabel m6;
    public static JLabel label;

    public static JTextArea textArea1;
    public static JTextArea textArea2;

    public static int cardsCounterDealer = 0;
    public static int dx;
    public static int dy;
    public static int bX = 600;
    JButton buttonBacktoLogin = new JButton("Zurueck");

    JTextField usernameL = new JTextField();
    JPasswordField passwordL = new JPasswordField();

    static JLabel wp1 = new JLabel();
    JLabel usernameText = new JLabel("Benutzername");
    JLabel passwordText = new JLabel("Passwort");
    JLabel passwordText2 = new JLabel("Passwort wiederholen");

    JButton buttonNReg = new JButton();
    JButton createUser = new JButton();

    JLabel nameRegText = new JLabel("Vorname");
    JTextField nameReg = new JTextField();
    JLabel lastNameRegText = new JLabel("Nachname");
    JTextField lastNameReg = new JTextField();
    JLabel usernameRegText = new JLabel("Benutzername");
    JTextField usernameReg = new JTextField();
    JLabel passwordRegText = new JLabel("Passwort");
    JPasswordField passwordReg = new JPasswordField();
    //#####################################################################
    JLabel passwordRegText2 = new JLabel("Passwort wiederholen");
    JPasswordField passwordReg2 = new JPasswordField();
    //#####################################################################
    JTextArea konsoleArea = new JTextArea();


    public void run() {

        framzz = new Gui();

        framzz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framzz.setSize(1024, 1000);
        framzz.setLayout(null);
        framzz.addKeyListener(new KeyHandler());
        framzz.setVisible(true);
        framzz.setLayout(null);
        framzz.toFront();
        framzz.setState(Frame.NORMAL);


        textArea1 = new JTextArea();
        textArea1.setSize(400, 1000);
        textArea1.setBackground(Color.BLACK);
        textArea1.setLocation(10, 10);
        textArea1.setForeground(new Color(10, 80, 200));
        textArea1.setFont(new Font("Arial", Font.BOLD, 18));
        textArea1.setFocusable(false);
        textArea1.setVisible(false);
        textArea1.requestFocus(false);
        framzz.add(textArea1);


        label = new JLabel();
        label.setBounds(0, 0, 90, 768);
        label.setBackground(Color.red);
        framzz.add(label);
        framzz.setVisible(true);


        buttonD = new JButton("(d)Double");
        buttonD.setSize(90,20);
        buttonD.setLocation(bX,750);
        buttonD.setFocusable(false);
        buttonD.setBackground(new Color(0, 17, 52, 255));
        buttonD.setForeground(new Color(154, 147, 154, 255));
        framzz.add(buttonD);
        buttonD.setVisible(false);
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JButton) e.getSource()).getText().equals("(d)Double")) {
                    try {
                        Engine.doubleDown();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        buttonS = new JButton("(s)Split");
        buttonS.setSize(90,30);
        buttonS.setLocation(bX+125,770);
        buttonS.setFocusable(false);
        buttonS.setBackground(new Color(19, 43, 223, 255));
        buttonS.setForeground(new Color(252, 104, 108, 255));
        framzz.add(buttonS);
        buttonS.setVisible(false);
        buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JButton) e.getSource()).getText().equals("(s)Split")) {
                    Engine.splitCards();
                }
            }
        });


        buttonX = new JButton("(x)Stand");
        buttonX.setSize(120,30);
        buttonX.setLocation(bX,800);
        buttonX.setBackground(new Color(192, 0, 0, 203));
        buttonX.setForeground(new Color(178, 178, 153, 255));
        buttonX.setFocusable(false);
        framzz.add(buttonX);
        buttonX.setVisible(false);
        buttonX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JButton) e.getSource()).getText().equals("(x)Stand")) {
                    KeyHandler.xButton();
                }
            }
        });

        buttonC = new JButton("(c)Hit");
        buttonC.setSize(120,30);
        buttonC.setLocation(bX,770);
        buttonC.setBackground(new Color(49, 15, 72, 255));
        buttonC.setForeground(new Color(173, 123, 127, 255));
        buttonC.setFocusable(false);
        framzz.add(buttonC);
        buttonC.setVisible(false);
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((JButton) e.getSource()).getText().equals("(c)Hit")) {
                    try {
                        Engine.check();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


        buttonN = new JButton("(n)New Round");
        buttonN.setSize(120,35);
        buttonN.setLocation(bX,832);
        buttonN.setFont(new Font("Arial", Font.BOLD, 12));
        buttonN.setFocusable(false);
        framzz.add(buttonN);
        buttonN.setVisible(false);
        buttonN.addActionListener(new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {
                  if (((JButton) e.getSource()).getText().equals("(n)New Round")) {
                      try {
                          Engine.newGame();
                      } catch (InterruptedException ex) {
                          ex.printStackTrace();
                      }

                  }

              }

          });


        dot2 = new JLabel();
        dot2.setBounds(0, 0, 200, 320);
        dot2.setLocation(800, 600);
        dot2.setIcon(womanp);
        dot2.setBackground(Color.red);
        framzz.add(dot2);
        dot2.setVisible(false);


        cardFire = new JLabel();
        cardFire.setBounds(0, 0, 200, 66);
        cardFire.setLocation(740, 285);
        cardFire.setIcon(exlpo2);
        cardFire.setBackground(Color.red);
        framzz.add(cardFire);
        cardFire.setVisible(false);


        dot = new JLabel();
        dot.setBounds(0, 0, 200, 150);
        dot.setLocation(263, 320);
        dot.setIcon(iconwp);
        dot.setBackground(Color.red);
        framzz.add(dot);
        dot.setVisible(false);


        m6 = new JLabel();
        m6.setBounds(0, 0, 190, 150);
        m6.setLocation(520, 160);
        m6.setIcon(m6p);
        m6.setBackground(Color.red);
        framzz.add(m6);
        m6.setVisible(false);


        textArea2 = new JTextArea();
        textArea2.setSize(300, 65);
        textArea2.setBackground(Color.BLACK);
        textArea2.setCaretColor(Color.RED);
        textArea2.setLocation(750, 650);
        textArea2.setOpaque(false);
        textArea2.setText("HotKeys\n - v - Screen   i - Intro  c - Hit  d - Double\n" +
                "s - Split  x - Stand  n - New game \no - Background");
        textArea2.setFocusable(false);
        framzz.getContentPane().setBackground(Color.black);
        framzz.add(textArea2);
        textArea2.setVisible(false);







        textArea3 = new JTextArea();
        textArea3.setForeground(new Color(10, 80, 200));
        textArea3.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea3.setSize(270, 140);
        textArea3.setBackground(Color.BLACK);
        textArea3.setCaretColor(Color.RED);
        textArea3.setFocusable(false);
        textArea3.setOpaque(false);
        textArea3.setLocation(740, 180);
        framzz.getContentPane().setBackground(Color.black);
        framzz.add(textArea3);
        textArea3.setVisible(false);



        textArea4 = new JTextArea();
        textArea4.setForeground(new Color(10, 80, 200));
        textArea4.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea4.setSize(270, 120);
        textArea4.setBackground(Color.BLACK);
        textArea4.setCaretColor(Color.RED);
        textArea4.setFocusable(false);
        textArea4.setLocation(740, 340+190);
        framzz.getContentPane().setBackground(Color.black);
        textArea4.setOpaque(false);
        framzz.add(textArea4);
        textArea4.setVisible(false);
        textArea4.setText("press (n) for new game");



        textArea5 = new JTextArea();
        textArea5.setForeground(new Color(10, 80, 200));
        textArea5.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea5.setSize(150, 120);
        textArea5.setBackground(Color.BLACK);
        textArea5.setFocusable(false);
        textArea5.setCaretColor(Color.RED);
        textArea5.setLocation(320, 770);
        framzz.getContentPane().setBackground(Color.black);
        textArea5.setOpaque(false);
        framzz.add(textArea5);
        textArea5.setVisible(false);
        textArea5.setVisible(false);
        
        //###################################################################################################################
        
        JButton buttonProfilbearbeiten = new JButton("Profil");
        buttonProfilbearbeiten.setSize(120,35);
        buttonProfilbearbeiten.setLocation(5,900); //5,900
        buttonProfilbearbeiten.setFont(new Font("Arial", Font.BOLD, 12));
        buttonProfilbearbeiten.setBackground(new Color(49, 15, 72, 255));
        buttonProfilbearbeiten.setForeground(new Color(173, 123, 127, 255));
        framzz.add(buttonProfilbearbeiten);
        buttonProfilbearbeiten.setVisible(false);
        buttonProfilbearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "Select * from Users where Username LIKE ?";

                Connection connectToDataBase = DbConnection.connect();
                PreparedStatement ps = null;
                ResultSet rs;
                try {
                    ps = connectToDataBase.prepareStatement(sql);
                    ps.setString(1, Profil_LoginEngine.momentanerUser);
                    rs = ps.executeQuery();

                    while(rs.next()) {
                        textArea5.setText("Name: " + rs.getString(1) + "\n");
                        textArea5.append("Vorname: " + rs.getString(2)+ "\n");
                        textArea5.append("Username: " + rs.getString(3)+ "\n");

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }



            }
        });
        
        //##########################################################################################################################
        
        
        
      //##########################################################################################################################
        
        
        JButton LogoutButon = new JButton("Logout");
        LogoutButon.setSize(120,35);
        LogoutButon.setLocation(300,900);
        LogoutButon.setFont(new Font("Arial", Font.BOLD, 12));
        LogoutButon.setBackground(new Color(49, 15, 72, 255));
        LogoutButon.setForeground(new Color(173, 123, 127, 255));
        framzz.add(LogoutButon);
        LogoutButon.setVisible(false);
        LogoutButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	usernameText.setVisible(true);
                usernameL.setVisible(true);
                passwordText.setVisible(true);
                passwordL.setVisible(true);
                buttonNReg.setVisible(true);
                buttonNLogin.setVisible(true);
                konsoleArea.setText("");
                konsoleArea.setVisible(true);

                nameReg.setVisible(false);
                nameRegText.setVisible(false);
                lastNameReg.setVisible(false);
                lastNameRegText.setVisible(false);
                usernameReg.setVisible(false);
                usernameRegText.setVisible(false);
                passwordReg.setVisible(false);
                passwordRegText.setVisible(false);
                passwordRegText2.setVisible(false);
                passwordReg2.setVisible(false);
                createUser.setVisible(false);
                //checkboxTry.setVisible(false);
                //scrollPane.setVisible(false);
                //textAreaDS.setVisible(false);
                //checkBoxLabel.setVisible(false);
                buttonBacktoLogin.setVisible(false);
                //##########################################
                buttonX.setVisible(false);
                buttonN.setVisible(false);
                buttonC.setVisible(false);
                buttonD.setVisible(false);
                buttonS.setVisible(false);
                buttonProfilbearbeiten.setVisible(false);
                LogoutButon.setVisible(false);


                textArea2.setVisible(false);
                textArea4.setVisible(false);
                textArea3.setVisible(false);
                textArea5.setVisible(false);

                buttonS.setVisible(false);

                m6.setVisible(false);

                try {
                    Engine.newGame();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                textArea4.setText("");
                textArea3.setText("");
                textArea2.setText("");
                textArea1.setText("");
                textArea5.setText("");

                Credit.setCredit(500);
                Gui.textArea5.setText("Credit: " + Credit.credit);
                m6.setLocation(520, 160);
                CardFramez.clearCardFrames();

                //##########################################
                
                
                
                nameReg.setText("");
                lastNameReg.setText("");
                usernameReg.setText("");
                passwordReg.setText("");
                passwordReg2.setText("");
                
                usernameL.setText("");
                passwordL.setText("");
                

                wp1.setVisible(false);
                wp1.setVisible(true);
                



            }
        });
        
        
        
        
      //##########################################################################################################################





///////////////////////////////LOGINZ/////////////////////////////////////


        usernameText.setLocation(130,215);
        usernameText.setSize(150,25);
        usernameText.setBackground(Color.BLACK);
        usernameText.setForeground(Color.WHITE);
        usernameText.setVisible(true);
        framzz.add(usernameText);


        passwordText.setLocation(158,250);
        passwordText.setSize(150,25);
        passwordText.setBackground(Color.BLACK);
        passwordText.setForeground(Color.WHITE);
        passwordText.setVisible(true);
        framzz.add(passwordText);

        passwordL.setLocation(218, 250);
        passwordL.setSize(228, 25);
        passwordL.setVisible(true);
        passwordL.setEchoChar('*');
        framzz.add(passwordL);

        usernameL.setLocation(218, 215);
        usernameL.setSize(228, 25);
        usernameL.setVisible(true);
        framzz.add(usernameL);




        buttonNLogin.setSize(120,35);
        buttonNLogin.setLocation(205,285);
        buttonNLogin.setFont(new Font("Arial", Font.BOLD, 12));
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
                        Profil_LoginEngine.momentanerUser = usernameL.getText();

                        usernameText.setVisible(false);
                        usernameL.setVisible(false);
                        passwordText.setVisible(false);
                        passwordL.setVisible(false);
                        buttonNReg.setVisible(false);
                        buttonNLogin.setVisible(false);
                        buttonBacktoLogin.setVisible(false);
                        konsoleArea.setVisible(false);
                        konsoleArea.setText("");


                        label.setVisible(true);
                        buttonN.setVisible(true);
                        buttonC.setVisible(true);
                        buttonD.setVisible(true);
                        buttonX.setVisible(true);
                        textArea3.setVisible(true);
                        textArea4.setVisible(true);
                        textArea2.setVisible(true);
                        textArea5.setVisible(true);
                        dot.setVisible(false);
                        m6.setVisible(true);
                        dot2.setVisible(true);
                        buttonProfilbearbeiten.setVisible(true);
                        LogoutButon.setVisible(true);

                        framzz.toFront();
                        framzz.requestFocus();


                        
                        Profil_LoginEngine.loginSecureBoolean = true;

                        //JOptionPane.showMessageDialog(null, "Welcome "+ nameField);
                    } else {
                        //System.out.println("Falsche anmelde daten");
                        konsoleArea.append("Falsche Anmeldedaten\n");
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(142, 370, 440, 256);
        scrollPane.setVisible(false);
        framzz.add(scrollPane);

        JTextArea textAreaDS = new JTextArea(20, 20);
        textAreaDS.setWrapStyleWord(true);
        textAreaDS.setLineWrap(true);
        textAreaDS.setEditable(false);
        textAreaDS.setVisible(false);
        scrollPane.setViewportView(textAreaDS);
        textAreaDS.setText("Datenschutzerklärung\n" +
                "\n" +
                "In dieser Datenschutzerklärung informieren wir Sie über die Verarbeitung personenbezogener Daten im zuge der Profilerstellung.\n\n" +
                "Personenbezogene Daten\n" +
                "\nDie bei uns gespeicherten Daten werden keinem dritten weitergegeben\nund dienen ausschliesslich zur Identifikation des Benutzerprofils.\n" +
                "Personenbezogene Daten sind alle Informationen, die sich\nauf eine identifizierte oder identifizierbare natürliche\nPerson " +
                "(im Folgenden \"betroffene Person\") beziehen. Als identifizierbar wird eine natürliche Person angesehen, die direkt oder indirekt, " +
                "insbesondere mittels Zuordnung zu\neiner Kennung wie einem Namen, zu einer Kennnummer, zu Standortdaten, zu einer Online-Kennung oder " +
                "zu einem oder mehreren besonderen\nMerkmalen identifiziert werden kann, die Ausdruck der physischen, physiologischen, genetischen, " +
                "psychischen, wirtschaftlichen, kulturellen oder sozialen\nIdentität dieser natürlichen Person sind.\n" +
                "" +
                "" +
                "Ihre Rechte\n" +
                "\n" +
                "Als betroffene Person haben Sie folgende Rechte:\n" +
                "\n" +
                "Sie haben ein Auskunftsrecht bezüglich der Sie betreffenden personenbezogenen Daten, die der Verantwortliche verarbeitet (Art. 15 DSGVO),\n" +
                "Sie haben das Recht auf Berichtigung der Sie betreffenden Daten, wenn diese unrichtig oder unvollständig gespeichert werden (Art. 16 DSGVO),\n" +
                "Sie haben das Recht auf Löschung (Art. 17 DSGVO),\n" +
                "Sie haben das Recht, die Einschränkung der Verarbeitung Ihrer personenbezogenen Daten zu verlangen (Art. 18 DSGVO),\n" +
                "Sie haben das Recht auf Datenübertragbarkeit (Art. 20 DSGVO),\n" +
                "Sie haben ein Widerspruchsrecht gegen die Verarbeitung Sie betreffender personenbezogener Daten (Art. 21 DSGVO),\n" +
                "Sie haben das Recht nicht einer ausschließlich auf einer automatisierten Verarbeitung – einschließlich Profiling – beruhenden Entscheidung unterworfen zu werden, die Ihnen gegenüber rechtliche Wirkung entfaltet oder sie in ähnlicher Weise erheblich beeinträchtigt (Art. 22 DSGVO),\n" +
                "Sie haben das Recht, sich bei einem vermuteten Verstoß gegen das Datenschutzrecht bei der zuständigen Aufsichtsbehörde zu beschweren\n" +
                "(Art. 77 DSGVO). Zuständig ist die Aufsichtsbehörde an Ihrem üblichen Aufenthaltsort, Arbeitsplatz oder am Ort des vermuteten Verstoßes.\n");

        JLabel checkBoxLabel = new JLabel("Einwilligung zur Datenverarbeitung gemaess DSVGO");
        checkBoxLabel.setLocation(202,340);
        checkBoxLabel.setSize(350,25);
        checkBoxLabel.setBackground(Color.BLACK);
        checkBoxLabel.setForeground(Color.WHITE);
        checkBoxLabel.setVisible(false);
        framzz.add(checkBoxLabel);


        JCheckBox checkboxTry = new JCheckBox("Akzeptieren");
        checkboxTry.setLocation(182,342);
        checkboxTry.setSize(18,20);
        checkboxTry.setOpaque(false);
        checkboxTry.setVisible(false);
        framzz.add(checkboxTry);

        buttonNReg = new JButton("Registrierung");
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
                passwordRegText2.setVisible(true);
                passwordReg2.setVisible(true);
                createUser.setVisible(true);
                checkboxTry.setVisible(true);
                scrollPane.setVisible(true);
                textAreaDS.setVisible(true);
                checkBoxLabel.setVisible(true);
                buttonBacktoLogin.setVisible(true);
                
                usernameL.setText("");
                passwordL.setText("");

                wp1.setVisible(false);
                wp1.setVisible(true);

                konsoleArea.setText("Benutzerprofil erstellen");

            }
        });





/////////////////////////////////////////// REG ///////////////////////////

        nameRegText.setLocation(150, 170); //150, 215
        nameRegText.setSize(150, 25);
        nameRegText.setBackground(Color.BLACK);
        nameRegText.setForeground(Color.WHITE);
        nameRegText.setVisible(false);
        framzz.add(nameRegText);

        nameReg.setLocation(280, 170); // 237, 215
        nameReg.setSize(228, 25);
        nameReg.setVisible(false);
        framzz.add(nameReg);

        lastNameRegText.setLocation(150, 200);	//150, 245
        lastNameRegText.setSize(150, 25);
        lastNameRegText.setBackground(Color.BLACK);
        lastNameRegText.setForeground(Color.WHITE);
        lastNameRegText.setVisible(false);
        framzz.add(lastNameRegText);

        lastNameReg.setLocation(280, 200);	//237, 160
        lastNameReg.setSize(228, 25);
        lastNameReg.setVisible(false);
        framzz.add(lastNameReg);

        usernameRegText.setLocation(150, 230);	//150, 225
        usernameRegText.setSize(150, 25);
        usernameRegText.setBackground(Color.BLACK);
        usernameRegText.setForeground(Color.WHITE);
        usernameRegText.setVisible(false);
        framzz.add(usernameRegText);

        usernameReg.setLocation(280, 230);
        usernameReg.setSize(228, 25);
        usernameReg.setVisible(false);
        framzz.add(usernameReg);

        passwordRegText.setLocation(150, 260);	//150, 220
        passwordRegText.setSize(150, 25);
        passwordRegText.setBackground(Color.BLACK);
        passwordRegText.setForeground(Color.WHITE);
        passwordRegText.setVisible(false);
        framzz.add(passwordRegText);

        passwordReg.setLocation(280, 260); //237, 220     237, 250
        passwordReg.setSize(228, 25);
        passwordReg.setVisible(false);
        passwordReg.setEchoChar('*');
        framzz.add(passwordReg);
        
        //###########################################
        passwordRegText2.setLocation(150, 290);
        passwordRegText2.setSize(150, 25);
        passwordRegText2.setBackground(Color.BLACK);
        passwordRegText2.setForeground(Color.WHITE);
        passwordRegText2.setVisible(false);
        framzz.add(passwordRegText2);
        
        passwordReg2.setLocation(280, 290);	//237, 250
        passwordReg2.setSize(228, 25);
        passwordReg2.setVisible(false);
        passwordReg2.setEchoChar('*');
        framzz.add(passwordReg2);
        
        //###########################################

        buttonBacktoLogin.setSize(90,35);
        buttonBacktoLogin.setLocation(370,660);
        buttonBacktoLogin.setFont(new Font("Arial", Font.BOLD, 12));
        buttonBacktoLogin.setBackground(new Color(49, 15, 72, 255));
        buttonBacktoLogin.setForeground(new Color(173, 123, 127, 255));
        buttonBacktoLogin.setFocusable(false);
        framzz.add(buttonBacktoLogin);
        buttonBacktoLogin.setVisible(false);
        buttonBacktoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                passwordRegText2.setVisible(false);
                passwordReg2.setVisible(false);
                createUser.setVisible(false);
                checkboxTry.setVisible(false);
                scrollPane.setVisible(false);
                textAreaDS.setVisible(false);
                checkBoxLabel.setVisible(false);
                buttonBacktoLogin.setVisible(false);
                
                nameReg.setText("");
                lastNameReg.setText("");
                usernameReg.setText("");
                passwordReg.setText("");
                passwordReg2.setText("");
                

                wp1.setVisible(false);
                wp1.setVisible(true);

            }
        });

        createUser = new JButton("Registrieren");
        createUser.setSize(120,35);
        createUser.setLocation(230,660);
        createUser.setFont(new Font("Arial", Font.BOLD, 12));
        createUser.setFocusable(false);
        createUser.setBackground(new Color(49, 15, 72, 255));
        createUser.setForeground(new Color(173, 123, 127, 255));
        framzz.add(createUser);
        createUser.setVisible(false);
        createUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usernameReg.getText().length() != 0 && nameReg.getText().length() != 0 &&
                        lastNameReg.getText().length() != 0 && passwordReg.getText().length() != 0) {
                    if (checkboxTry.isSelected()) {
                        if (passwordReg.getText().length() >= 6) {
                        	if(passwordReg.getText().equals(passwordReg2.getText())) {
                        


                            String query = "insert into Users values(?,?,?,?)";
                            Connection con = DbConnection.connect();
                            PreparedStatement ps = null;
                            try {
                                String sql = "INSERT INTO Users(Name, Vorname, Username, Kennwort) VALUES(?,?,?,?) ";
                                ps = con.prepareStatement(sql);
                                ps.setString(1, lastNameReg.getText());
                                ps.setString(2, nameReg.getText());
                                ps.setString(3, usernameReg.getText());
                                ps.setString(4, passwordReg.getText());
                                ps.execute();
                                konsoleArea.setText("Erfolgreich registriert!");

                                usernameText.setVisible(true);
                                usernameL.setVisible(true);
                                passwordText.setVisible(true);
                                passwordL.setVisible(true);
                                buttonNReg.setVisible(true);
                                buttonNLogin.setVisible(true);
                                usernameL.setText("");
                                passwordL.setText("");


                                nameReg.setVisible(false);
                                nameRegText.setVisible(false);
                                lastNameReg.setVisible(false);
                                lastNameRegText.setVisible(false);
                                usernameReg.setVisible(false);
                                usernameRegText.setVisible(false);
                                passwordReg.setVisible(false);
                                passwordRegText.setVisible(false);
                                passwordRegText2.setVisible(false);
                                passwordReg2.setVisible(false);
                                createUser.setVisible(false);
                                checkboxTry.setVisible(false);
                                checkBoxLabel.setVisible(false);
                                scrollPane.setVisible(false);
                                textAreaDS.setVisible(false);
                                buttonBacktoLogin.setVisible(false);

                                wp1.setVisible(false);
                                wp1.setVisible(true);


                            } catch (Exception a) {
                                //konsoleArea.setText(a.toString());
                                konsoleArea.append("\nDer Benutzername ist bereits vergeben");
                            }
                            
                        } else { konsoleArea.setText("Passw�rter stimmen nicht �berein");                        
                        }
                      } else {
                            konsoleArea.setText("Das Passwort muss mindestens 6 Zeichen lang sein");
                        }
                    } else {
                        konsoleArea.setText("Bitte der Datenschutzvereinbarung zustimmen");
                    }
                } else {
                    konsoleArea.setText("Alle Felder muessen gefuellt sein");
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


    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void focusGained(FocusEvent e) {

    }
    @Override
    public void focusLost(FocusEvent e) {

    }
}

