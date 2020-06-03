package server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gamelogic.Game;
import gamelogic.models.Lobby;
import gamelogic.models.Room;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.models.GameRESTMessage;

import java.util.List;

@RestController
public class GameRESTController {

    Lobby lobby = new Lobby();


    @RequestMapping(value = "/getrooms", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> getRooms(){
        return new ResponseEntity(lobby.getRooms(), HttpStatus.OK);
    }

    @RequestMapping(value = "/creategame", method = RequestMethod.POST)
    public ResponseEntity addRoom() throws JsonProcessingException {
        lobby.addGame(new Game(2,2));
       // lobby.addGame(new Game(msg.getAutoBetValue(), msg.getMaxBetRounds(), msg.getUserName(), 100));
        String response = "Game created";
        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(response));
    }

}
