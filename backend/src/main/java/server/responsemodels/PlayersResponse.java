package server.responsemodels;

import gamelogic.models.Player;

import java.util.List;

public class PlayersResponse {
    String content;
    List<Player> players;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
