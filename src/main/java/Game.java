import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String name1, String name2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(name1)) {
                player1 = player;
            }
            if (player.getName().equals(name2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(name1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(name2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
