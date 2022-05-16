package game;
import gui.CardFramez;
import gui.Gui;
import java.util.Scanner;


public class Engine extends Gui {

    public static boolean passedDealer = false;
    public static boolean newGame21 = false;
    public static boolean newGBool = true;
    public static boolean checkedNoSplit = false;
    public static boolean xOffdueSplitt = false;
    public static boolean checkWonBool = false;
    public static boolean newGBoolAni = false;
    public static boolean playerWon = false;
    public static boolean dealersTurn = false;
    public static boolean doubleDownb = false;
    public static boolean split2Turn = false;
    public static boolean splitBool = false;
    public static int karteSplit1;
    public static int karteSplit2;
    public static int karteExtra;
    public static int kartenSumSpieler = 0;
    public static int kartenSumDealer = 0;
    public static int c_ = 0;
    public static int karte1;
    public static int karte2;
    public static String wrr;

///////////////////////// DEALER EXTRA CARD  /////////////////////
    public static void dealerExtraCard() throws InterruptedException {

        Runnable r = new Runnable() {
            public void run() {


                while (!newGBool && newGBoolAni) {


                 runoutFix();
                    try {
                        karteExtra = Karten.karteZiehen();



                    if (karteExtra == 1 && kartenSumDealer == 10) {
                        karteExtra = 11;
                    }

                    kartenSumDealer += karteExtra;

                    if (kartenSumDealer > 21 && Karten.asseCounter > 0) {
                        kartenSumDealer -= 10;
                        Karten.asseCounter -= 1;
                    }


                    textArea1.append(" Dealer Handz : " + kartenSumDealer);
                    textArea4.setText(" Dealer: " + kartenSumDealer);
                    Thread.sleep(900);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        ifWin();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r).start();
    }
///////////////////////// PASS TO DEALER ////////////////////////
    public static void passToDealer() throws InterruptedException {

        split2Turn = false;


        if (splitBool) { Gui.buttonS.setVisible(false);
            if (karteSplit2 > 21 && karteSplit1 > 21) {
                Gui.textArea4.setText("\nlost, start new game (n)");
                newGBool = true;
            }
            if (karteSplit2 == 21 || karteSplit1 == 21) {
                kartenSumSpieler = 21;
            }else if (karteSplit2 < 21 && karteSplit1 < 21) {
                kartenSumSpieler = Math.max(karteSplit1, karteSplit2);
            }else if (karteSplit1 > 21 && karteSplit2 < 21) {
                kartenSumSpieler = karteSplit2;
            }else if (karteSplit2 > 21 && karteSplit1 < 21) {
                kartenSumSpieler = karteSplit1;
            }
        }
        splitBool = false;
        if (!newGBool && !xOffdueSplitt &&!passedDealer) {

            passedDealer = true;

            doubleDownb = true;
            Karten.asseCounter = 0;
            dealersTurn = true;


            Gui.cardsCounterDealer = 0;


            Gui.textArea1.append("\n        ->>> Dealers Turn <<<- ");

            c_++;

            runoutFix();
            karte1 = Karten.karteZiehen();
            if (karte1 == 1) {karte1 = 11;Karten.asseCounter++;}

            runoutFix();
            karte2 = Karten.karteZiehen();
            if (karte2 == 1 && karte1 != 11) {karte2 = 11;Karten.asseCounter++;}


            kartenSumDealer = karte1 + karte2;



            textArea1.append(" Dealer Handz: " + kartenSumDealer);
            textArea4.setText(" Dealer: " + kartenSumDealer);

            ifWin();

            newGBoolAni = true;

        } else {
            textArea1.append("\n(n) New Game\n");
            textArea4.append("\n(n) New Game");

        }


    }
///////////////////////// NEW GAME ////////////////////////////////
    public static void newGame() throws InterruptedException {

        if (!Engine.newGame21) {

            textArea4.setText("");

            checkWonBool = false;
            newGBoolAni = false;
            passedDealer = false;
            Karten.asseCounter = 0;
            CardFramez.cardCounterPLayer = 0;
            Gui.cardsCounterDealer = 0;
            karteSplit2 = 0;
            karteSplit1 = 0;
            splitBool = false;
            split2Turn = false;
            checkedNoSplit = false;
            doubleDownb = false;
            newGBool = false;
            xOffdueSplitt = false;
            dealersTurn = false;
            Gui.buttonS.setVisible(false);
            cardFire.setVisible(false);


            CardFramez.clearCardFrames();
            Bet.setBet(50);
            Credit.setCredit(Credit.getCredit() - Bet.getBet());
            Bet.checkBetz();

           // Gui.textArea4.setText("\u2660B\u2660O\u2663N\u2666N\u2665E\u2660C\u2663H\u2666A\u2665N\u2660C\u2663E\u2666  ");

            runoutFix();
            karte1 = Karten.karteZiehen();
            if (karte1 == 1) {karte1 = 11;Karten.asseCounter++;}

            runoutFix();
            karte2 = Karten.karteZiehen();
            if (karte2 == 1 && karte1 != 11) {karte2 = 11;Karten.asseCounter++;}


            kartenSumSpieler = karte1 + karte2;


            textArea1.append(" Hand total: " + kartenSumSpieler + "\n");
            textArea3.setText(" Hand total: " + kartenSumSpieler + "\n");


            if (kartenSumSpieler == 21) {
                checkWonBool = true;
                newGame21 = true;
                KeyHandler.xButton();
            }

            if (karte1 == karte2 && kartenSumSpieler < 21){
                Gui.textArea3.append("\npress (s) for split ");
                Gui.textArea4.append("\n(s) for split ");
                Gui.buttonS.setVisible(true);

            }



        } else Gui.textArea4.append("\n-wait-");


    }
///////////// CHECK ////////CHECK SPLIT 1////CHECK SPLIT 2///////////
    public static void check() throws InterruptedException {

        if (!checkWonBool) {

            if (!newGBool && !doubleDownb && !splitBool) {

                checkedNoSplit = true;
                runoutFix();
                karteExtra = Karten.karteZiehen();

                if (karteExtra == 1 && Engine.kartenSumSpieler == 10) {
                    karteExtra = 11;
                }

                kartenSumSpieler += karteExtra;

                if (kartenSumSpieler > 21 && Karten.asseCounter > 0) {
                    kartenSumSpieler -= 10;
                    Karten.asseCounter -= 1;
                }
                textArea1.append(" Hand total: " + kartenSumSpieler + "\n");
                textArea3.setText(" Hand total: " + kartenSumSpieler + "\n");


                if (kartenSumSpieler == 21) {
                    checkWonBool = true;
                    doubleDownb = true;
                    KeyHandler.xButton();
                }

                if (kartenSumSpieler > 21) {
                    textArea3.setText(" Hand total: " +
                            kartenSumSpieler + "\n");
                    textArea3.append("\n-  no win  -");
                    newGBool = true;
                }


/////////////////////// CHECK SPLIT 1  ////////////////////////////
            } else if (!newGBool && !doubleDownb && splitBool && !split2Turn) {

                xOffdueSplitt = true;
                if (Karten.asseCounter == 2) Karten.asseCounter--;
                runoutFix();
                karteExtra = Karten.karteZiehen();



                if (karteExtra == 1 && karteSplit1 == 10) {
                    karteExtra = 11;
                }
                karteSplit1 += karteExtra;

                if (karteSplit1 > 21 && Karten.asseCounter > 0) {
                    karteSplit1 -= 10;
                    Karten.asseCounter -= 1;
                }

                if (karteSplit1 == 21) {
                    textArea3.setText(" Split 1 total: " + karteSplit1);
                    splitCards();

                } else if (karteSplit1 > 21) {
                    textArea3.setText(" Split 1 total: " + karteSplit1);
                    splitCards();

                } else
                    textArea3.setText(" Split 1 total: " + karteSplit1 + "\n" +
                            "\n" +
                            "press (s) for stand split 1\n");


/////////////////////// CHECK SPLIT 2 TURN  ////////////////////////////
            } else if (!newGBool && !doubleDownb && split2Turn) {

                checkedNoSplit = true;

                Gui.textArea4.setText("(c) hit next card\n" +
                        "(x) stand");
                xOffdueSplitt = false;
                runoutFix();
                karteExtra = Karten.karteZiehen();


                if (karteExtra == 1 && karteSplit2 == 10) {
                    karteExtra = 11;
                }
                karteSplit2 += karteExtra;


                if (karteSplit2 > 21 && Karten.asseCounter > 0) {
                    karteSplit2 -= 10;
                    Karten.asseCounter -= 1;
                }
                textArea3.setText("(Split1:" + karteSplit1 + ")\nSplit 2 total: " + karteSplit2 + "\n");

                if (karteSplit2 == 21) {
                    checkWonBool= true;
                    KeyHandler.xButton();
                } else if (karteSplit2 > 21) {
                    checkWonBool= true;
                    KeyHandler.xButton();
                }

            } else {
                textArea1.setText("start New Game");
                textArea3.append("\n(n) New Game");
            }
        }else { textArea3.append("\n-wait-");}
    }
//////////////////////// DOUBLE DOWN //////////////////////////
    public static void doubleDown() throws InterruptedException {


        if (!newGBool && !doubleDownb) {
            Gui.textArea5.append(" -"+ Bet.getBet());
            Credit.setCredit(Credit.getCredit()-Bet.getBet());
            Bet.setBet(Bet.getBet()*2);

            Gui.textArea3.setText(" Double Down!\n");
            doubleDownb = true;
            runoutFix();
            karteExtra = Karten.karteZiehen();

            kartenSumSpieler += karteExtra;

            if (kartenSumSpieler > 21 && Karten.asseCounter > 0) {
                kartenSumSpieler -= 10;
                Karten.asseCounter -= 1;
            }

            textArea1.append(" Hand total: " + kartenSumSpieler + "\n");
            textArea3.append(" Hand total: " + kartenSumSpieler + "\n");


            if (kartenSumSpieler > 21) {
                textArea3.setText(" Hand total: " + kartenSumSpieler + "\n");
                textArea3.append(" no win ");
                newGBool = true;
            } else
                KeyHandler.xButton();



        } else {
            textArea1.setText("start New Game");
            textArea3.append("\n wait for next round");
        }
    }
//////////////////////// SPLIT ////////////////////////////////
    public static void splitCards() {

            if (!newGBool && !doubleDownb && !splitBool && !checkedNoSplit) {


                if (karte1 == karte2 || karte1 == 1 && karte2 == 11 || karte2 == 1 && karte1 == 11) {

                    splitBool = true;

                    karteSplit1 = karte1;
                    karteSplit2 = karte2;
                    CardFramez.cardsPlayerArray.get(1).setVisible(false);
                    CardFramez.cardsPlayerArray.remove(1);
                    CardFramez.cardCounterPLayer = 1;


                    textArea3.setText(" Karte 1: " + karteSplit1 + "\n Karte 2: " + karteSplit2);

                }
                Gui.textArea4.setText("(c) hit next card\n" +
                                      "(s) for stand split 1\n");
//////////////////////// 2ND SPLIT ////////////////////////
            }else if (!newGBool && !doubleDownb && !checkedNoSplit) {


                    for (int i = 1; i < CardFramez.cardsPlayerArray.size(); i++) {
                        CardFramez.cardsPlayerArray.get(i).setVisible(false);
                    }

                CardFramez.cardCounterPLayer = 1;
                split2Turn = true;


                textArea3.setText("(Split1:"+karteSplit1 + ")\n\nSplit 2 total: " + karteSplit2 + "\n");


                checkedNoSplit = true;
            }
            }

    public static void intro() {


        textArea1.selectAll();
        textArea1.replaceSelection("");

        textArea1.append("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Scanner in = new Scanner(System.in);
        int b = 0;
        int b2 = 0;
        int c4 = 0;

        for (int c = 0; c < 20; c++) {
            String a = "🂢";
            String bb = Karten.kartenSymbol();
            String leer = "   ";


            textArea1.append(Karten.kartenSymbol() + leer + a +
                    leer + Karten.kartenSymbol() + " " + Karten.kartenSymbol() + leer + a + " ");
            b++;
            b2++;
            if (b == 2) {
                for (int c2 = 0; c2 < 1; c2++) {


                    b = 0;
                    textArea1.append(leer + Karten.kartenSymbol() +
                            leer + Karten.kartenSymbol() + leer + a + leer + Karten.kartenSymbol() + " " + "\n");

                }
            }
            if (b2 == 3) {
                for (int cc = 0; cc < 2; cc++) {
                    b2 = 0;
                    textArea1.append(Karten.kartenSymbol() + leer);


                }
            }
            String x = "Z K C A J K c A L B";
            int i = 20;

            c4++;
            if (c4 == 5) {
                for (int c3 = 0; c3 <= 8; c3++) {
                    i -= 2;
                    textArea1.append(Character.toString(x.charAt(i)));

                }


            }
            c_ += 20;
        }
    }



    public static void ifWin() throws InterruptedException {

        if (kartenSumDealer >= kartenSumSpieler && kartenSumDealer <= 21) {
            textArea1.append("\n\n       - - - Dealer Winz - - -\n\n" +
                    " Player: " + kartenSumSpieler + " vs Bank: " + kartenSumDealer);
            textArea4.setText(" dealer: " +kartenSumDealer +
                    "\n\n  \u2663  \u2660                        " +
                    "\u2663  \u2660  \n         DEALER WInz           \n\u2665  \u2663                 " +
                            "           \u2665  \u2666");
            //   77   77  77
            newGBool = true;
            playerWon = false;
            passedDealer = false;
            newGame21 = false;
            cardFire.setVisible(false);
            kartenSumDealer = 0;kartenSumSpieler = 0;

        }
        if (kartenSumDealer > 21) {
            textArea1.append(
                    "- - -YOU WIN GZ- - -      \n " +
                    "              Player: " + kartenSumSpieler + " vs Bank: " + kartenSumDealer);
            textArea3.setText("\n" +
                    "  \u2660  \u2665                        " +
                    "\u2663  \u2660  \n         YOU WIN Gz           \n\u2666  \u2663                 " +
                    "          \u2665  \u2666\n\n  "+"Player: " + kartenSumSpieler + " \n\n");
            if (kartenSumSpieler == 21) {
                cardFire.setVisible(true);
                Clock.run21();
            }

            newGBool = true;
            playerWon = true;
            passedDealer = false;
            newGame21 = false;
            kartenSumDealer = 0;kartenSumSpieler = 0;

        }
        Bet.checkBetz();
    }

    public static void runoutFix() {

        c_++;
        if (c_ > 6) {
            textArea1.selectAll();
            textArea1.replaceSelection("");
            c_ = 0;

        }
    }
}
