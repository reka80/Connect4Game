package codes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMain() {
        String[] args = {};
        assertDoesNotThrow(() -> Main.main(args), "A program indításakor hiba történt.");
    }
}
