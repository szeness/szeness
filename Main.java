import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rn = new Random();

        ArrayList<Integer> allZahlen = new ArrayList<>();
        ArrayList<Integer> top6Freq = new ArrayList<>();

        int[] tempZahlen = new int[6];
        int dFreq;

        for (int i = 0; i < 1000; i++) {

            tempZahlen[0] = rn.nextInt(49) + 1;
            tempZahlen[1] = rn.nextInt(49) + 1;
            tempZahlen[2] = rn.nextInt(49) + 1;
            tempZahlen[3] = rn.nextInt(49) + 1;
            tempZahlen[4] = rn.nextInt(49) + 1;
            tempZahlen[5] = rn.nextInt(49) + 1;

            for (int j = 0; j < tempZahlen.length; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j != k) {
                       if(tempZahlen[j] == tempZahlen[k]) {

                        /*System.out.println("\nduplikate");
                        System.out.println(tempZahlen[0] + " " + tempZahlen[1] + " " + tempZahlen[2] + " "
                                + tempZahlen[3] + " " + tempZahlen[4] + "  " + tempZahlen[5]);*/

                        tempZahlen[j] = rn.nextInt(49) + 1;

              /*          System.out.println(tempZahlen[0] + " " + tempZahlen[1] + " " + tempZahlen[2] + " " +
                                tempZahlen[3] +" " + tempZahlen[4] + "  " + tempZahlen[5]);
                        System.out.println("-");*/

                           k = -1;
                        }
                    }
                }
            }

            allZahlen.add(tempZahlen[0]);
            allZahlen.add(tempZahlen[1]);
            allZahlen.add(tempZahlen[2]);
            allZahlen.add(tempZahlen[3]);
            allZahlen.add(tempZahlen[4]);
            allZahlen.add(tempZahlen[5]);

          System.out.println(tempZahlen[0] + " " + tempZahlen[1] + " " + tempZahlen[2] + " " + tempZahlen[3] +
                    " " + tempZahlen[4] + "  " + tempZahlen[5]);
        }

        for (int i = 1; i < allZahlen.size(); i++) {
            dFreq = Collections.frequency(allZahlen, i);
            if (i < 50) {
                System.out.println(i + " " + dFreq + "x");
                top6Freq.add(dFreq);
            }
        }

        ArrayList<Integer> copyTop6 = new ArrayList<>(top6Freq);

        Collections.sort(top6Freq);

        /*System.out.println(top6Freq);
        System.out.println(copyTop6);*/

        System.out.println("\n TOP ZAHLEN \n");


        for (int o = 48; o > 42; o--) {
            for (int i = 0; i < copyTop6.size(); i++) {
                if (copyTop6.get(i) == top6Freq.get(o)) {
                    System.out.println(i + 1 + " " + top6Freq.get(o) + "x");
                    copyTop6.set(i, 0);

                }
            }
        }

    }

}

