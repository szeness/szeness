package game;
import gui.CardFramez;
import gui.Gui;

import java.util.Random;


public class Karten extends Engine {

        public static int asseCounter = 0;


        public static int karteZiehen() throws InterruptedException {

            Random r = new Random();
            int gezKarte = r.nextInt(11) + 1;
            if (gezKarte == 11) asseCounter++;
            wrr = Karten.kartenWert(gezKarte);
            String wysym = Karten.kartenSymbol();
            textArea1.append("\n                     ____\n" +
                    "                   | " + wysym + "   " + wysym + " |" +
                    "\n                       " + wrr + "  \n" +
                    "                   | " + wysym + "   " + wysym + " |" +
                    "\n                    ------");
            return gezKarte;
        }

        public static String kartenSymbol() {

            Random r = new Random();
            String[] kartenSymbole = new String[]{"\u2665", "\u2666", "\u2663", "\u2660"};
            return kartenSymbole[r.nextInt(kartenSymbole.length)];
        }

        public static String kartenWert(int a) {
            Random r = new Random();
            String[] kartenWert = new String[]{"B", "Q", "K"};
            String actCard = kartenWert[r.nextInt(kartenWert.length)];
            if (a == 11 || a == 1) {
                switch (a) {
                    case 1:
                    case 11:
                        if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.rauteAssp);
                        } else  CardFramez.cardFrameDealer(Gui.rauteAssp);
                    break;

            }
            return "A";
            }

            if (a == 10) {

                switch (actCard) {
                    case "Q":
                        if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.herzDamep);
                        } else  CardFramez.cardFrameDealer(Gui.herzDamep);

                        break;

                    case "B":
                        if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.herzBubeP);
                        } else  CardFramez.cardFrameDealer(Gui.herzBubeP);

                    break;

                    case "K":
                        if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.pickKing);
                        } else  CardFramez.cardFrameDealer(Gui.pickKing);

                    break;
                }
                return actCard;

            } else {
                switch (String.valueOf(a)) {

                    case "2":if(!dealersTurn) {
                                    CardFramez.cardFramePlayer(Gui.karo2p);
                            }else   CardFramez.cardFrameDealer(Gui.karo2p);

                        break;

                    case "3":if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.pick3p);
                    } else  CardFramez.cardFrameDealer(Gui.pick3p);

                    break;

                    case "4":if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.raute4p);
                    } else  CardFramez.cardFrameDealer(Gui.raute4p);

                    break;

                    case "5":if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.herz5p);
                    } else  CardFramez.cardFrameDealer(Gui.herz5p);

                    break;

                    case "6":if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.pick6p);
                    } else  CardFramez.cardFrameDealer(Gui.pick6p);

                    break;

                    case "7": if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.herz7p);
                    } else  CardFramez.cardFrameDealer(Gui.herz7p);

                        break;

                    case "8":if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.raute8p);
                    } else  CardFramez.cardFrameDealer(Gui.raute8p);

                    break;

                    case "9":if(!dealersTurn) {

                        CardFramez.cardFramePlayer(Gui.pick9p);
                    } else  CardFramez.cardFrameDealer(Gui.pick9p);

                    break;
                }
                return String.valueOf(a);
            }
        }
}
