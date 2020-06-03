//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic.models;

import java.util.Random;

public class CardDeck {
    private final int deckSize = 52;
    private final int shuffleAmount = 2000;
    private final int handSize = 13;
    Card[] deck = new Card[52];
    Random rnd = new Random();
    private int counterDealed = 0;

    public CardDeck() {
    }

    public Card[] getDeck() {
        return this.deck;
    }

    public void fillDeck() {
        int counter = 0;

        for(int cardGrade = 1; cardGrade <= 4; ++cardGrade) {
            for(int cardNumber = 1; cardNumber <= 13; ++cardNumber) {
                this.deck[counter] = new Card();
                this.deck[counter].setCardGrade(cardGrade);
                this.deck[counter].setCardNumber(cardNumber);
                ++counter;
            }
        }

    }

    public void shuffleDeck() {
        for(int i = 0; i <= shuffleAmount; ++i) {
            int number1 = this.rnd.nextInt(52);
            int number2 = this.rnd.nextInt(52);
            Card temp = this.deck[number1];
            this.deck[number1] = this.deck[number2];
            this.deck[number2] = temp;
        }

    }

    public Card[] dealCards() {
        Card[] hand = new Card[handSize];

        for(int deckPosition = this.counterDealed; deckPosition < handSize + this.counterDealed; ++deckPosition) {
            hand[deckPosition - this.counterDealed] = this.deck[deckPosition];
        }

        if (this.counterDealed >= deckSize) {
            this.counterDealed = 0;
        } else {
            this.counterDealed += handSize;
        }

        return hand;
    }
}
