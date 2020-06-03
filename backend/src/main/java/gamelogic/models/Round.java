//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic.models;

import java.util.List;

public class Round {
    private double roomStake;
    private double totalWinnings;

    public Round() {
    }

    public void addStake(double amount) {
        this.roomStake += amount;
    }

    public void evaluate(List<Player> players) {
        for (Player player :
                players) {
            if (threeOfAKind(player.getSet1()) != 0){
                player.setCardSetPoints(threeOfAKind(player.getSet1()));

            }
            else if (straightFlush(player.getSet1()) != 0){
                player.setCardSetPoints(straightFlush(player.getSet1()));

            }
            else if (straight((player.getSet1()))!= 0){
                player.setCardSetPoints(straight(player.getSet1()));

            }
            else if (flush(player.getSet1())!= 0){
                player.setCardSetPoints(flush((player.getSet1())));

            }
            else if (pair(player.getSet1())!= 0){
                player.setCardSetPoints(pair(player.getSet1()));

            }
            else {
                player.setCardSetPoints(highCard(player.getSet1()));
            }
        }
    }

    public int threeOfAKind(Card[] cardSet) {
        return cardSet[0].getCardNumber() == cardSet[2].getCardNumber() && cardSet[1].getCardNumber() == cardSet[2].getCardNumber() ? 5000 + cardSet[0].getCardNumber() : 0;
    }

    public int straightFlush(Card[] cardSet) {
        if (cardSet[0].getCardNumber() == 13 && cardSet[1].getCardNumber() == 2 && cardSet[2].getCardNumber() == 1 && cardSet[0].getCardGrade() == cardSet[1].getCardGrade() && cardSet[0].getCardGrade() == cardSet[2].getCardGrade()) {
            return 4013;
        } else {
            int j;
            for(j = 1; j < cardSet.length; ++j) {
                if (cardSet[0].getCardGrade() != cardSet[j].getCardGrade()) {
                    return 0;
                }
            }

            for(j = 1; j < cardSet.length; ++j) {
                if (cardSet[j - 1].getCardNumber() != cardSet[j].getCardNumber() + 1) {
                    return 0;
                }
            }

            if (cardSet[0].getCardNumber() == 13) {
                return 4014;
            } else {
                return 4000 + cardSet[0].getCardNumber();
            }
        }
    }

    public int straight(Card[] cardSet) {
        if (cardSet[0].getCardNumber() == 13 && cardSet[1].getCardNumber() == 2 && cardSet[2].getCardNumber() == 1) {
            return 3513;
        } else {
            for(int j = 1; j < cardSet.length; ++j) {
                if (cardSet[j - 1].getCardNumber() != cardSet[j].getCardNumber() + 1) {
                    return 0;
                }
            }

            if (cardSet[0].getCardNumber() == 13) {
                return 3514;
            } else {
                return 3500 + cardSet[0].getCardNumber();
            }
        }
    }

    public int flush(Card[] cardSet) {
        for(int i = 1; i < cardSet.length; ++i) {
            if (cardSet[0].getCardGrade() != cardSet[i].getCardGrade()) {
                return 0;
            }
        }
        return 2000 + cardSet[0].getCardNumber() * 100 + cardSet[1].getCardNumber() * 10 + cardSet[2].getCardNumber();
    }

    public int pair(Card[] cardSet) {
        if (cardSet[0].getCardNumber() == cardSet[1].getCardNumber()) {
            return 1500 + cardSet[2].getCardNumber();
        } else if (cardSet[0].getCardNumber() == cardSet[2].getCardNumber()) {
            return 1;
        } else {
            return cardSet[1].getCardNumber() == cardSet[2].getCardNumber() ? 1500 + cardSet[0].getCardNumber() : 0;
        }
    }

    public int highCard(Card[] cardSet) {
        return cardSet[0].getCardNumber() * 100 + cardSet[1].getCardNumber() * 10 + cardSet[2].getCardNumber();
    }
}
