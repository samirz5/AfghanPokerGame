//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic.models;

public class Room {
    private int roomId = 0;
    private double autoBetValue;
    private double maxBetRounds;
    private int amountPlayers;

    public Room(int roomId, double autoBetValue, double maxBetRounds) {
        this.roomId = roomId;
        this.autoBetValue = autoBetValue;
        this.maxBetRounds = maxBetRounds;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getAutoBetValue() {
        return this.autoBetValue;
    }

    public void setAutoBetValue(double autoBetValue) {
        this.autoBetValue = autoBetValue;
    }

    public double getMaxBetRounds() {
        return maxBetRounds;
    }

    public void setMaxBetRounds(double maxBetRounds) {
        this.maxBetRounds = maxBetRounds;
    }

    public int getAmountPlayers() {
        return amountPlayers;
    }

    public void setAmountPlayers(int amountPlayers) {
        this.amountPlayers = amountPlayers;
    }
}
