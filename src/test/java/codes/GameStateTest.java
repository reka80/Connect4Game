package codes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    private GameState gameState;

    @BeforeEach
    public void setUp() {
        gameState = new GameState();
    }

    // Teszteljük, hogy a tábla megfelelően inicializálódik
    @Test
    public void testBoardInitialization() {
        assertNotNull(gameState.getBoard(), "A tábla nem lett inicializálva.");
        assertEquals(6, gameState.getBoard().split("\n").length, "A tábla sorainak száma nem megfelelő.");
    }

    // Teszteljük, hogy a játékos váltása helyesen működik
    @Test
    public void testSwitchPlayer() {
        String initialPlayer = gameState.getCurrentPlayer();
        gameState.switchPlayer();
        assertNotEquals(initialPlayer, gameState.getCurrentPlayer(), "A játékos váltás nem történt meg.");
    }

    // Teszteljük, hogy egy lépés érvényes-e
    @Test
    public void testIsValidMove() {
        assertTrue(gameState.isValidMove("a"), "Az 'a' oszlop érvénytelen.");
        assertFalse(gameState.isValidMove("z"), "A 'z' oszlop érvényes, pedig nem létezik.");
    }

    // Teszteljük, hogy a lépés valóban végrehajtódik
    @Test
    public void testMakeMove() {
        gameState.makeMove("a");
        assertEquals("Y", gameState.getBoard().split("\n")[5].charAt(1) + "", "A lépés nem történt meg megfelelően.");
    }

    // Teszteljük, hogy a nyertes keresés működik
    @Test
    public void testCheckWinner() {
        gameState.makeMove("a"); // Yellow
        gameState.switchPlayer();
        gameState.makeMove("b"); // Red
        gameState.switchPlayer();
        gameState.makeMove("a"); // Yellow
        gameState.switchPlayer();
        gameState.makeMove("b"); // Red
        gameState.switchPlayer();
        gameState.makeMove("a"); // Yellow
        gameState.switchPlayer();
        gameState.makeMove("b"); // Red
        gameState.switchPlayer();
        gameState.makeMove("a"); // Yellow (nyer)

        assertTrue(gameState.checkWinner(), "A nyertes keresés nem működik megfelelően.");
    }

    // Teszteljük, hogy a játék véget ér-e, ha tele van a tábla
    @Test
    public void testIsGameOver() {
        for (char c = 'a'; c <= 'g'; c++) {
            gameState.makeMove(String.valueOf(c));
            gameState.switchPlayer();
        }
        assertTrue(gameState.isGameOver(), "A játék nem ért véget, pedig már nincs több lépés.");
    }
}
