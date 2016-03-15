package ru.bakigoal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bakigoal.model.Player;
import ru.bakigoal.repository.PlayerRepository;

import java.util.List;

/**
 * Created by ilmir on 15.03.16.
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> findAllPlayers() {
        return repository.getAllPlayers();
    }

    public Player findById(long id) {
        return repository.findById(id);
    }

    public boolean isPlayerExist(Player player) {
        return repository.isPlayerExist(player);
    }

    public void savePlayer(Player player) {
        repository.savePlayer(player);
    }

    public void updatePlayer(Player currentPlayer) {
        repository.updatePlayer(currentPlayer);
    }

    public void deletePlayerById(long id) {
        repository.deletePlayer(id);
    }

    public void deleteAllPlayers() {
        repository.deleteAllPlayers();
    }
}
