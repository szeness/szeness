package game;

import gui.Gui;

public class Bet {


    public static int bet;


    public static int getBet() {
        return bet;
    }

    public static void setBet(int bet) {
        Bet.bet = bet;
    }




    public static int checkBetz() {

        Gui.textArea5.setText("Credit: " + Credit.credit);

        if (Engine.playerWon && Engine.newGBool) {
            Credit.credit = Credit.getCredit() + (2 * Bet.getBet());
            Gui.textArea5.append(" +" + (Bet.getBet() * 2));
            return Credit.credit;
        }


        return Credit.credit;
    }

}