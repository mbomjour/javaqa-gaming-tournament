import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotRegisteredException;

import java.util.HashMap;

public class GameTest {

    Player player1 = new Player(1, "Оля", 15);
    Player player2 = new Player(2, "Петя", 25);
    Player player3 = new Player(3, "Игорь", 28);
    Player player4 = new Player(4, "Настя", 9);
    Player player5 = new Player(5, "Олег", 28);

    Game game = new Game();

    @Test
    public void findInfoByName() {
        game.register("Настя", player4);

        Player expected = player4;
        Player actual = game.findInfo("Настя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWon() {
        game.register("Оля", player1);
        game.register("Петя", player2);

        int expected = 1;
        int actual = game.round("Петя", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWon() {
        game.register("Оля", player1);
        game.register("Петя", player2);

        int expected = 2;
        int actual = game.round("Оля", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersWereEqual() {
        game.register("Игорь", player3);
        game.register("Олег", player5);

        int expected = 0;
        int actual = game.round("Игорь", "Олег");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        game.register("Оля", player1);
        game.register("Петя", player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Оля", "Игорь");
        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register("Оля", player1);
        game.register("Петя", player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Настя");
        });
    }

    @Test
    public void bothPlayersNotRegistered() {
        game.register("Настя", player4);
        game.register("Олег", player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Петя");
        });
    }
}
