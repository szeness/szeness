package gui;

import javax.swing.*;

public class CarAndOthers extends Gui {

    public static void carUp() {
        m6.setLocation(m6.getX(), m6.getY() - 10);
        explo(dot);
        explo(dot2);
    }

    public static void carDown() {

        m6.setLocation(m6.getX() - 10, m6.getY() + 10);
        explo(dot);
        explo(dot2);
    }

    public static void carRight() {

        m6.setLocation(m6.getX() + 10, m6.getY());
        explo(dot);
        explo(dot2);

    }

    public static void explo(JLabel jayL) {

        if (m6.getX() > jayL.getX()) {
            dx = (m6.getX() - jayL.getX());
        } else dx = jayL.getX() - m6.getX();
        if (m6.getY() > jayL.getY()) {
            dy = (m6.getY() - jayL.getY());
        } else dy = jayL.getY() - m6.getY();

        if (dx <= 20 && dy <= 20)
            jayL.setVisible(true);

    }

}
