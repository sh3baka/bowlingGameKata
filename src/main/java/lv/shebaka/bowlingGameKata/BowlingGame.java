package lv.shebaka.bowlingGameKata;

import java.util.Scanner;

public class BowlingGame {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        while (game.inGame) {
            System.out.println("Score: " + game.score());
            System.out.println("Roll: ");
            game.roll(scanner.nextInt());
        }
    }
}
