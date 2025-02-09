package GamePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerNotRegistered() {
        Player cris = new Player(22, "Cris", 15);
        Player felix = new Player(13, "Felix", 18);
        Game game = new Game();
        game.register(cris);
        game.register(felix);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Masha", "Felix"));
    }

    @Test
    public void testSecondPlayerNotRegistered() {
        Player cris = new Player(22, "Cris", 15);
        Player felix = new Player(13, "Felix", 18);
        Game game = new Game();
        game.register(cris);
        game.register(felix);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Cris", "Sasha"));
    }

    @Test
    public void testFirstPlayerWin() {
        Player cris = new Player(22, "Cris", 15);
        Player felix = new Player(13, "Felix", 18);
        Game game = new Game();
        game.register(cris);
        game.register(felix);

        int actual = game.round("Felix", "Cris");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSecondPlayerWin() {
        Player cris = new Player(22, "Chris", 15);
        Player felix = new Player(13, "Felix", 18);
        Game game = new Game();
        game.register(cris);
        game.register(felix);

        int actual = game.round("Chris", "Felix");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDraw() {
        Player cris = new Player(22, "Cris", 15);
        Player felix = new Player(13, "Felix", 15);
        Game game = new Game();
        game.register(cris);
        game.register(felix);

        int actual = game.round("Cris", "Felix");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }


}
