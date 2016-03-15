package ru.bakigoal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.bakigoal.service.PlayerService;
import ru.bakigoal.model.Player;

import java.util.List;

/**
 * Created by ilmir on 15.03.16.
 */
@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/player/", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> listAllPlayers() {
        List<Player> players = playerService.findAllPlayers();
        if(players.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    //-------------------Retrieve Single Player--------------------------------------------------------

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") long id) {
        Player player = playerService.findById(id);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    //-------------------Create a Player--------------------------------------------------------

    @RequestMapping(value = "/player/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Player player, UriComponentsBuilder ucBuilder) {
        if (playerService.isPlayerExist(player)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        playerService.savePlayer(player);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Player --------------------------------------------------------

    @RequestMapping(value = "/player/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Player> updateUser(@PathVariable("id") long id, @RequestBody Player player) {
        Player currentPlayer = playerService.findById(id);
        if (currentPlayer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentPlayer.setName(player.getName());
        currentPlayer.setAge(player.getAge());
        currentPlayer.setAmplua(player.getAmplua());

        playerService.updatePlayer(currentPlayer);
        return new ResponseEntity<>(currentPlayer, HttpStatus.OK);
    }

    //------------------- Delete a Player --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Player> deleteUser(@PathVariable("id") long id) {
        Player player = playerService.findById(id);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //------------------- Delete All Users --------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<Player> deleteAllUsers() {
        playerService.deleteAllPlayers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
