//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gamelogic.Game;
import gamelogic.models.Lobby;
import gamelogic.models.Player;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import server.models.WebSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import server.responsemodels.GameWSResponse;
import server.responsemodels.PlayersResponse;
import server.responsemodels.WebSocketResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller

public class WebSocketController {

    Lobby lobby = new Lobby();
    Game game;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping({"/joingame"})
    public void joingGame(@Payload WebSocketMessage message){
        if (getGameById(message.getRoomId())!= null){
            game = getGameById(message.getRoomId());
            game.joinGame(message.getUserName(), message.getBalance());

            PlayersResponse response = new PlayersResponse();
            response.setContent("JOINED");
            List<Player> tempList = new ArrayList<>(game.getPlayers());
            Collections.reverse(tempList);

            for (Player player:
                        game.getPlayers()) {
               // if (!player.getUserName().equals(message.getUserName())){
                    tempList.remove(player);
                    int index2 = 0 ;
                    tempList.add(index2, player);
                    response.setPlayers(tempList);
                    simpMessagingTemplate.convertAndSend("/topic/game/" + player.getUserName() , response);
                //}
            }

        }
    }

    @MessageMapping("/setready")
    public void playerReady(@Payload WebSocketMessage message){
        if (getGameById(message.getRoomId())!= null){
            game = getGameById(message.getRoomId());
            game.readyToPlayGame(message.getUserName());

            if (game.isAllReadyToPlayRounds()){
                GameWSResponse response = new GameWSResponse();
                for (Player player :
                        game.getPlayers()) {
                    response.setContent("READY");
                    response.setHand(player.getPlayerHand());
                    simpMessagingTemplate.convertAndSend("/topic/game/" + player.getUserName(), response);
                }
            }
        }
    }

    @MessageMapping("/setcardsets")
    public void setCardSets(@Payload WebSocketMessage message){
        if (getGameById(message.getRoomId()) != null){
            game = getGameById(message.getRoomId());
            //game.readyWithCardSorting(message.getUserName(), )
        }
    }

    @MessageMapping("/placebet")
    public void placeBet(){

    }


    private Game getGameById(int roomId){
        for (Game game :
                lobby.getGames()) {
            if (game.getRoom().getRoomId() == roomId)
                return game;
        }
        return null;
    }
}
