package game;

import gui.Gui;

public class Credit extends Bet {


    public Credit() {


    }
    public static int credit = 500;


    public static int getCredit() {
        return credit;
    }

    public static void setCredit(int credit) {
        Credit.credit = credit;
    }




    public static void resetCreditz() {
        setCredit(500);
        Gui.textArea5.setText("Credit: " + Credit.credit+"\n - credit reset -");
    }

}
