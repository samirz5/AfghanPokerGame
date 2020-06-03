package gamelogic.models;

import gamelogic.Game;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    /**
     * HashMap maken ipv list
     */
    private static List<Game> games = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();


    public void addGame(Game game){
        games.add(game);
    }

    public List<Game> getGames(){
        return games;
    }

    public List<Room> getRooms(){
        rooms.clear();
        for (Game game :
                games) {
            rooms.add(game.getRoom());
        }
        return rooms;
    }
}
