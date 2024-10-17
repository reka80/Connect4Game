package codes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player("Player 1", 'Y', true);

        assertEquals("Player 1", player.getName(), "A játékos neve helytelen.");
        assertEquals('Y', player.getDisc(), "A játékos korongja helytelen.");
        assertTrue(player.isHuman(), "A játékosnak humánnak kell lennie.");
    }

    @Test
    public void testChooseColumnAI() {
        Player player = new Player("AI Player", 'R', false);

        int column = player.chooseColumn();
        assertTrue(column >= 0 && column < 7, "A gépnek egy oszlopot kellett választania 0 és 6 között.");
    }
}
