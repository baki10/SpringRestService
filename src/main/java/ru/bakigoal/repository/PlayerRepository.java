package ru.bakigoal.repository;

import org.springframework.stereotype.Repository;
import ru.bakigoal.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ilmir on 15.03.16.
 */
@Repository
public class PlayerRepository {

    private AtomicLong counter;
    private List<Player> players;

    public PlayerRepository() {
        players = new ArrayList<>();
        counter = new AtomicLong();
        initDefaultPlayers();
    }

    private void initDefaultPlayers() {
        savePlayer(new Player("Baki", 28, "Forward"));
        savePlayer(new Player("Baki Middle", 26, "Defender"));
        savePlayer(new Player("Baki Junior", 19, "Midfielder"));
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
            player.setId(counter.incrementAndGet());
            players.add(player);
        }
    }

    public void updatePlayer(Player currentPlayer) {
        for (Player player : players) {
            if (player.equals(currentPlayer)) {
                player.setName(currentPlayer.getName());
                player.setAge(currentPlayer.getAge());
                player.setAmplua(currentPlayer.getAmplua());
            }
        }
    }

    public void deletePlayer(long id) {
        for (Player player : players) {
            if (player.getId() == id) {
                players.remove(player);
                break;
            }
        }
    }

    public void deleteAllPlayers() {
        players.clear();
    }
}
