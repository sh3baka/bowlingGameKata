package lv.shebaka.bowlingGameKata;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    Game game = new Game();

    @Test
    public void testGame() {

        rollMany(20, 0);

        assertEquals(0, game.score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);

        assertEquals(20, game.score());
    }

    @Test
    public void testOnSpare() {
        rollSpare();
        game.roll(3);

        assertEquals(16 , game.score());
    }

    @Test
    public void testStrike() {
        rollStrike();
        game.roll(1);
        game.roll(8);
        rollMany(16, 0);

        assertEquals(28, game.score());

    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);

        assertEquals(300, game.score());
    }

    @Test
    public void testViablePinCount() {
        game.roll(5);

        assertEquals(5, game.score());
    }

    @Test
    public void testErrorMessageWhenPinCountNotViable() {
        game.roll(15);

        assertEquals("Wrong number", game.errorMsg);
        assertEquals(0, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int rolls, int pins) {
        for (int i=0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}