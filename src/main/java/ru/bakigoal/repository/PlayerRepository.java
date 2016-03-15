package ru.bakigoal.repository;

import org.springframework.stereotype.Repository;
import ru.bakigoal.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilmir on 15.03.16.
 */
@Repository
public class PlayerRepository {

    private static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player(1, "Baki", 28, "Forward"));
        players.add(new Player(2, "Baki Junior", 19, "Midfielder"));
        players.add(new Player(3, "Baki Middle", 26, "Defender"));
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public Player findById(long id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    public boolean isPlayerExist(Player player) {
        for (Player p : players) {
            if (p.equals(player)) {
                return true;
            }
        }
        return false;
    }

    public void savePlayer(Player player) {
        if (player != null) {
            players.add(player);
        }
    }

    public void updatePlayer(Player currentPlayer) {
        for(Player player: players){
            if(player.equals(currentPlayer)){
                player.setName(currentPlayer.getName());
                player.setAge(currentPlayer.getAge());
                player.setAmplua(currentPlayer.getAmplua());
            }
        }
    }

    public void deletePlayer(long id) {
        for (Player player: players){
            if(player.getId() == id){
                players.remove(player);
                break;
            }
        }
    }

    public void deleteAllPlayers() {
        players.clear();
    }
}
