package gui;

import javax.swing.*;
import java.util.ArrayList;

public class CardFramez extends Gui {


    public static ArrayList<JLabel> cardsDealerArray = new ArrayList<>();
    public static ArrayList<JLabel> cardsPlayerArray = new ArrayList<>();
    public static JLabel cardDealer;
    public static JLabel cardPlayer;
    public static int cardLocationDealer;
    public static int cardLocationPlayer;
    public static int cardCounterPLayer = 0;



    public static void cardFramePlayer(ImageIcon xIcnz) {


        cardLocationPlayer = cardCounterPLayer * 100;

        cardPlayer = new JLabel();
        cardPlayer.setBounds(0, 0, 89, 185);
        cardPlayer.setLocation(860- cardLocationPlayer, 10);
        cardPlayer.setIcon(xIcnz);
        Gui.framzz.add(cardPlayer,1);
        cardPlayer.setVisible(false);
        cardPlayer.setVisible(true);

        cardsPlayerArray.add(cardCounterPLayer, cardPlayer);

        cardCounterPLayer++;
    }

    public static void cardFrameDealer(ImageIcon xIcn) {


        cardLocationDealer = Gui.cardsCounterDealer * 100;

        cardDealer = new JLabel();
        cardDealer.setBounds(860- cardLocationDealer, 330, 89, 185);
        cardDealer.setIcon(xIcn);
        Gui.framzz.add(cardDealer,1);
        cardDealer.setVisible(false);
        cardDealer.setVisible(true);

        cardsDealerArray.add(Gui.cardsCounterDealer, cardDealer);

        Gui.cardsCounterDealer++;
    }

    public static void clearCardFrames() {


        if (cardsPlayerArray.size() > 0) {
            for (int i = 0; i < cardsPlayerArray.size(); i++) {
                cardsPlayerArray.get(i).setVisible(false);
            }
            cardsPlayerArray.clear();
        }

        if (cardsDealerArray.size() > 0) {
            for (int i = 0; i < cardsDealerArray.size(); i++) {
                cardsDealerArray.get(i).setVisible(false);
            }
            cardsDealerArray.clear();
        }
    }
}
