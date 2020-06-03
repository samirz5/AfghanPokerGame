package gamelogic.models;

public class Card implements Comparable<Card> {
    private int cardNumber;
    private int cardGrade;

    public Card() {
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardGrade() {
        return this.cardGrade;
    }

    public void setCardGrade(int cardGrade) {
        this.cardGrade = cardGrade;
    }

    public int compareTo(Card o) {
        if (this.cardGrade == o.cardGrade) {
            return 0;
        } else {
            return this.cardNumber > this.cardNumber ? 1 : -1;
        }
    }
}