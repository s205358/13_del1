package Game;

import java.util.Scanner;

public class DiceGame {
    private Die d1, d2;
    private Player p1, p2;
    private boolean turn = true, gameOver = false;
    private Scanner sc = new Scanner(System.in);

    public DiceGame() {
        this.d1 = new Die();
        this.d2 = new Die();
        this.p1 = new Player("Player 1");
        this.p2 = new Player("Player 2");
    }

    public void shuffle(int n) {
        if (n <= 0 || n > 10) {
            n = intInput("Error! Please enter a valid number [1 - 10]: ");
            shuffle(n);
        } else {
            for (int i = 0; i < n; i++) {
                this.d1.roll();
                this.d2.roll();
            }
        }
    }

    public int getSum() {
        return this.d1.getFaceVale() + this.d2.getFaceVale();
    }

    public boolean isEqual() {
        if (this.d1.getFaceVale() == this.d2.getFaceVale()) {
            return true;
        } else {
            return false;
        }
    }

    public Player getPlayer() {
        if (turn) {
            return p1;
        } else {
            return p2;
        }
    }

    public void updateScore() {
        int score = getPlayer().getScore() + getSum();
        getPlayer().setScore(score);
    }

    public void special() {
        if (!(getSum() == 12) && getPlayer().getStreak() > 0) {
            getPlayer().resetStreak();
            System.out.println("Streak have been reset!");
        }

        if (getPlayer().getScore() > 40 && isEqual() && !(getSum() == 2)) {
            gameOver = !gameOver;
        } else if (getSum() == 12) {
            getPlayer().setStreak(getPlayer().getStreak() + 1);
            if (getPlayer().getStreak() == 2) {
                gameOver = !gameOver;
            } else {
                System.out.println("You get another turn!");
            }
        } else if (getSum() == 2) {
            getPlayer().resetScore();
            System.out.println("Score have been reset! Try again!");
        } else if (isEqual()) {
            System.out.println("You get another turn!");
        } else {
            turn = !turn;
        }
    }

    public String stringInput(String label) {
        System.out.print(label);
        return sc.nextLine();
    }

    public int intInput(String label) {
        System.out.print(label);
        return sc.nextInt();
    }

    public void play() {
        System.out.println("\tWelcome!" +
                "\nThe rules are simple:" +
                "\nYou win by getting 40 points and rolling an equal." +
                "\nYou can also win by getting two equals of sum 12 in a row." +
                "\nYou will be reset by getting two equals of sum 2." +
                "\nPlayer 1 starts." +
                "\n\nEnter the name of players following the instructions below:");
        p1.setName(stringInput("Enter name of player 1: "));
        p2.setName(stringInput("Enter name of player 2: "));
        do {
            String name = getPlayer().getName();
            System.out.println("\nIt's " + name + " (Score: " + getPlayer().getScore() + ") turn: ");
            shuffle(intInput(name + " enter how many times you'd like to shuffle [1 - 10]: "));
            System.out.println(name + " rolls: "+ d1.getFaceVale() + " + " + d2.getFaceVale() + " = " + getSum());
            updateScore();
            System.out.println(name + " now has a score of " +  getPlayer().getScore());
            special();
        } while (!gameOver);
        System.out.println("\nGame over!\n" + getPlayer().getName() + " wins!");
    }
}