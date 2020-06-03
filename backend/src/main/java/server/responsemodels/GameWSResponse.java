package server.responsemodels;

import gamelogic.models.Card;
import gamelogic.models.CardDeck;

public class GameWSResponse {
    private String content;
    private Card[] hand = new Card[13];

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }
}
