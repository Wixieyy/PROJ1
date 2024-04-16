import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GamesListTest {

    @Test
    public void testGetGames() {
        Ranglijst gamesList = new Ranglijst();
        List<String> expectedGames = List.of("COD", "Battlefield", "Animal Crossing", "Lethal");

        assertEquals(expectedGames, gamesList.getGames());
    }

}