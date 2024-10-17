package codes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    @Test
    public void testDropPiece() {
        Player player1 = new Player("Player 1", 'Y', true);
        Player player2 = new Player("Player 2", 'R', false);
        GameState gameState = new GameState(player1, player2);

        assertTrue(gameState.dropPiece(0), "A korongot le kellett volna helyezni az első oszlopba.");
        gameState.printBoard();
        for (int i = 0; i < 5; i++) {
            assertTrue(gameState.dropPiece(0), "A korongokat le kellett volna helyezni az első oszlopba.");
        }

        assertFalse(gameState.dropPiece(0), "Az első oszlop tele van, nem lehet korongot lehelyezni.");
    }

    @Test
    public void testCheckWinHorizontal() {
        Player player1 = new Player("Player 1", 'Y', true);
        Player player2 = new Player("Player 2", 'R', false);
        GameState gameState = new GameState(player1, player2);

        for (int i = 0; i < 4; i++) {
            gameState.dropPiece(i);
        }

        assertTrue(gameState.checkWin(), "A játékosnak nyernie kellett volna vízszintesen.");
    }

    @Test
    public void testSwitchPlayer() {
        Player player1 = new Player("Player 1", 'Y', true);
        Player player2 = new Player("Player 2", 'R', false);
        GameState gameState = new GameState(player1, player2);

        assertEquals(player1, gameState.getCurrentPlayer(), "Az első játékosnak kell kezdenie.");
        gameState.switchPlayer();
        assertEquals(player2, gameState.getCurrentPlayer(), "A játékosnak váltania kellett volna a másodikra.");
    }

    @Test
    public void testBoardFull() {
        Player player1 = new Player("Player 1", 'Y', true);
        Player player2 = new Player("Player 2", 'R', false);
        GameState gameState = new GameState(player1, player2);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                assertTrue(gameState.dropPiece(i));
            }
        }

        assertTrue(gameState.isBoardFull(), "A táblának tele kellene lennie.");
    }
}
