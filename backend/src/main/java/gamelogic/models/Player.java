//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic.models;

public class Player {
    private String userName;
    private double balance;
    private boolean readyToPlay = false;
    private boolean readyWithSorting = false;
    private Card[] set1 = new Card[3];
    private Card[] set2 = new Card[3];
    private Card[] set3 = new Card[3];
    private Card[] set4 = new Card[3];
    private Boolean dealer;
    private Card[] playerHand;
    private int cardSetPoints;

    public Player() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void bet(double bet) {
        this.balance -= bet;
    }

    public boolean isReadyToPlay() {
        return this.readyToPlay;
    }

    public void setReadyToPlay(boolean readyToPlay) {
        this.readyToPlay = readyToPlay;
    }

    public Card[] getSet1() {
        return this.set1;
    }

    public void setSet1(Card[] set1) {
        this.set1 = set1;
    }

    public Card[] getSet2() {
        return this.set2;
    }

    public void setSet2(Card[] set2) {
        this.set2 = set2;
    }

    public Card[] getSet3() {
        return this.set3;
    }

    public void setSet3(Card[] set3) {
        this.set3 = set3;
    }

    public Card[] getSet4() {
        return this.set4;
    }

    public void setSet4(Card[] set4) {
        this.set4 = set4;
    }

    public boolean isReadyWithSorting() {
        return this.readyWithSorting;
    }

    public void setReadyWithSorting(boolean readyWithSorting) {
        this.readyWithSorting = readyWithSorting;
    }

    public Boolean getDealer() {
        return this.dealer;
    }

    public void setDealer(Boolean dealer) {
        this.dealer = dealer;
    }

    public Card[] getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Card[] playerHand) {
        this.playerHand = playerHand;
    }

    public int getCardSetPoints() {
        return cardSetPoints;
    }

    public void setCardSetPoints(int cardSetPoints) {
        this.cardSetPoints = cardSetPoints;
    }
}
