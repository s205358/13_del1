package Test;

import Game.*;

public class DiceGameTest {
    private DiceGame g1 = new DiceGame();
    private int s2 = 0, s3 = 0, s4 = 0, s5 = 0, s6 = 0, s7 = 0, s8 = 0, s9 = 0, s10 = 0, s11 = 0, s12 = 0, un = 0;
    private int equals = 0;

    public DiceGameTest() {
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            g1.shuffle(1);
            switch(g1.getSum()) {
                case 2:
                    s2++;
                    break;
                case 3:
                    s3++;
                    break;
                case 4:
                    s4++;
                    break;
                case 5:
                    s5++;
                    break;
                case 6:
                    s6++;
                    break;
                case 7:
                    s7++;
                    break;
                case 8:
                    s8++;
                    break;
                case 9:
                    s9++;
                    break;
                case 10:
                    s10++;
                    break;
                case 11:
                    s11++;
                    break;
                case 12:
                    s12++;
                    break;
                default:
                    un++;
                    break;
            }

            if (g1.isEqual()) {
                equals++;
            }
        }
    }

    public void print() {
        System.out.println("\tEquals Probability Test:\n" +
                equals/10.0 + "%");
        System.out.println("\tSums Probability Test:" +
                "\n2," +  s2/10.0 + "%" +
                "\n3," +  s3/10.0 + "%" +
                "\n4," +  s4/10.0 + "%" +
                "\n5," +  s5/10.0 + "%" +
                "\n6," +  s6/10.0 + "%" +
                "\n7," +  s7/10.0 + "%" +
                "\n8," +  s8/10.0 + "%" +
                "\n9," +  s9/10.0 + "%" +
                "\n10," + s10/10.0 + "%" +
                "\n11," + s11/10.0 + "%" +
                "\n12," + s12/10.0 + "%\n");
    }
}
