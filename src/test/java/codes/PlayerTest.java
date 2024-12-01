package codes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("John", "Yellow");
    }

    // Teszteljük, hogy a játékos neve és színe helyesen van tárolva
    @Test
    public void testPlayerInitialization() {
        assertEquals("John", player.getName(), "A játékos neve nem megfelelő.");
        assertEquals("Yellow", player.getColor(), "A játékos színe nem megfelelő.");
    }

    // Teszteljük, hogy a Player osztály megfelelően hoz létre egy játékost
    @Test
    public void testPlayerCreation() {
        Player newPlayer = new Player("Alice", "Red");
        assertNotNull(newPlayer, "A játékos létrehozása nem sikerült.");
        assertEquals("Alice", newPlayer.getName(), "A játékos neve nem megfelelő.");
        assertEquals("Red", newPlayer.getColor(), "A játékos színe nem megfelelő.");
    }
}
