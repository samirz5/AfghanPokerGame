//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic;

import gamelogic.models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Game {

    private static int roomId = 0;
    private Room room;
    private Round round;
    List<Player> players = new ArrayList();
    private int dealer = 0;
    private CardDeck cardDeck;
    private boolean allReadyToPlayRounds = false;

    public Room getRoom() {
        return room;
    }
    public boolean isAllReadyToPlayRounds(){return allReadyToPlayRounds;}
    public List<Player> getPlayers(){return players;}

    public Game(double autoBetValue, double maxBetRounds) {

        roomId++;
        room = new Room(roomId, autoBetValue, maxBetRounds);
        cardDeck = new CardDeck();
        round = new Round();
        cardDeck.fillDeck();
        //joinGame(userName, balance);
    }

    public void joinGame(String userName, double balance) {
        if (players.stream()
                .anyMatch(t -> t.getUserName().equals(userName))){
            return;
        }
        Player player = new Player();
        player.setUserName(userName);
        player.setBalance(balance);
        this.players.add(player);
        if (players.size()!= 0)room.setAmountPlayers(players.size());

    }

    public boolean readyToPlayGame(String userName) {
        int counter = 0;
        Iterator var3 = this.players.iterator();

        while(var3.hasNext()) {
            Player player = (Player)var3.next();
            if (player.getUserName().equals(userName)) {
                player.setReadyToPlay(true);
            }

            if (player.isReadyToPlay()) {
                ++counter;
                if (counter == 4) {
                   playGame();
                   return true;
                }
            }
        }
        return false;

    }

    private void playGame(){
        allReadyToPlayRounds = true;
        cardDeck.shuffleDeck();
        this.setDealer();
        this.setPlayerCardsAndBet();
    }

    public boolean readyWithCardSorting(String userName, Card[] set1, Card[] set2, Card[] set3, Card[] set4) {
        int counter = 0;
        Iterator var7 = this.players.iterator();

        while(var7.hasNext()) {
            Player player = (Player)var7.next();
            if (player.getUserName().equals(userName)) {
                player.setReadyWithSorting(true);
                player.setSet1(set1);
                player.setSet2(set2);
                player.setSet3(set3);
                player.setSet4(set4);
            }

            if (player.isReadyWithSorting()) {
                ++counter;
                if (counter == 4) {
                    return true;
                }
            }
        }

        return false;
    }

    public String getRoundWinner(){
        round.evaluate(players);
        Player player = players.stream().max(Comparator.comparingInt(Player::getCardSetPoints)).get();
        return player.getUserName();
    }

    public void setPlayerCardsAndBet() {
        Iterator var1 = this.players.iterator();

        while(var1.hasNext()) {
            Player player = (Player)var1.next();
            player.bet(this.room.getAutoBetValue());
            player.setPlayerHand(cardDeck.dealCards());

        }

    }

    public void placeBet(String userName, double betAmount) {
        Iterator var4 = this.players.iterator();

        while(var4.hasNext()) {
            Player player = (Player)var4.next();
            if (player.getUserName().equals(userName)) {
                player.bet(betAmount);
            }
        }

        this.round.addStake(betAmount);
    }


    public void setDealer() {
        Iterator var1 = this.players.iterator();

        while(var1.hasNext()) {
            Player player = (Player)var1.next();
            player.setDealer(false);
        }

        ((Player)this.players.get(this.dealer)).setDealer(true);
        ++this.dealer;
        if (this.dealer == 4) {
            this.dealer = 0;
        }

    }
}
