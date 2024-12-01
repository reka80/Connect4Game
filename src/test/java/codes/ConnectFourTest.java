package codes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectFourTest {

    private ConnectFour game;

    @BeforeEach
    public void setUp() {
        game = new ConnectFour();
    }

    // Teszteljük, hogy a játék elindul
    @Test
    public void testStartGame() {
        game.startGame();
        assertNotNull(game.getGameState().getBoard(), "A tábla nem lett inicializálva.");
        assertFalse(game.getGameState().isGameOver(), "A játék véget ért, pedig nem kellett volna.");
    }

    // Teszteljük, hogy a játékos váltása helyesen történik
    @Test
    public void testSwitchPlayer() {
        String currentPlayer = game.getGameState().getCurrentPlayer();
        game.getGameState().switchPlayer();
        assertNotEquals(currentPlayer, game.getGameState().getCurrentPlayer(), "A játékos váltás nem történt meg.");
    }

    // Teszteljük, hogy a nyertes keresése helyesen működik
    @Test
    public void testCheckWinner() {
        game.getGameState().makeMove("a"); // Yellow
        game.getGameState().makeMove("b"); // Red
        game.getGameState().makeMove("a"); // Yellow
        game.getGameState().makeMove("b"); // Red
        game.getGameState().makeMove("a"); // Yellow
        game.getGameState().makeMove("b"); // Red
        game.getGameState().makeMove("a"); // Yellow (nyer)

        assertTrue(game.getGameState().checkWinner(), "A nyertes keresés nem működik megfelelően.");
    }

    // Teszteljük, hogy a játék vége megfelelően van kezelve
    @Test
    public void testGameOver() {
        for (char c = 'a'; c <= 'g'; c++) {
            game.getGameState().makeMove(String.valueOf(c));
            game.getGameState().switchPlayer();
        }
        assertTrue(game.getGameState().isGameOver(), "A játék nem ért véget, pedig már nincs több lépés.");
    }
}

