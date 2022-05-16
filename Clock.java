package game;

import gui.CarAndOthers;
import gui.Gui;

public class Clock extends Thread{

public static int fortsch21 = 0;



    public static void run21() throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(400);

                    if (fortsch21 <5) {
                        for (int i = 0; i < 5; i++) {

                            try {
                                sleep(50);


                                CarAndOthers.carDown();


                            } catch (InterruptedException ex) {ex.printStackTrace();
                            }

                        }
                    }else if (fortsch21 >= 5 && fortsch21 < 7) {

                        try {
                            sleep(400);
                        } catch (InterruptedException ex) {ex.printStackTrace();
                        }
                        for (int i = 0; i < 6; i++) {
                            try {sleep(40);} catch (InterruptedException ex) {ex.printStackTrace();
                            }

                            CarAndOthers.carUp();

                        }

                    } else if (fortsch21 >= 7 && fortsch21 < 9) {

                        for (int i = 0; i < 4; i++) {
                            try {
                                sleep(50);
                            } catch (InterruptedException ex) {ex.printStackTrace();}


                            CarAndOthers.carDown();

                        }
                        if (fortsch21 == 8) {

                            runIntro();
                            fortsch21 = 0;
                        }
                    }
                  } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        };
        fortsch21++;
        new Thread(r).start();



    }

    public static void runIntro() throws InterruptedException {


        sleep(1000);for (int i = 0; i < 25; i++) {sleep(50);


                CarAndOthers.carDown();

        }
        sleep(400);for (int i = 0; i < 12; i++) {sleep(40);


               CarAndOthers.carUp();
        }

        for (int i = 0; i < 4; i++) {sleep(50);


                CarAndOthers.carDown();

        }

        sleep(500);for (int i = 0; i < 42; i++) {sleep(40);


                  CarAndOthers.carRight();
        }

        Gui.textArea1.setVisible(true);
        sleep(400);
        for (int i = 0; i < 30; i++) {sleep(80);


              Engine.intro();
        }

        Gui.textArea1.setVisible(false);
        Gui.dot.setVisible(false);

        sleep(400);for (int i = 0; i < 30; i++) {sleep(50);


            CarAndOthers.carDown();

        }
        for (int i = 0; i < 10; i++) {sleep(20);


            CarAndOthers.carUp();
        }

        for (int i = 0; i < 10; i++) {sleep(20);


            CarAndOthers.carDown();

        }
        for (int i = 0; i < 12; i++) {sleep(20);


            CarAndOthers.carUp();
        }

        for (int i = 0; i < 12; i++) {sleep(20);


            CarAndOthers.carDown();

        }
        for (int i = 0; i < 12; i++) {sleep(20);


            CarAndOthers.carUp();
        }

        for (int i = 0; i < 10; i++) {sleep(20);


            CarAndOthers.carDown();

        }

        sleep(400);

           CarAndOthers.m6.setLocation(550, 160);


        sleep(400);



    }
}
