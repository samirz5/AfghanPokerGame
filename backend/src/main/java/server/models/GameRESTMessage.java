package server.models;

public class GameRESTMessage {
    private int roomId;
    private double autoBetValue;
    private double maxBetRounds;
    private String userName;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public double getAutoBetValue() {
        return autoBetValue;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
