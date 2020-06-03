//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardDeckTest {
    private CardDeck deck;
    private Card[] cards;

    CardDeckTest() {
    }

    @BeforeEach
    void setup() {
        this.deck = new CardDeck();
        this.cards = new Card[52];
    }

    @Test
    void testFillDeck_52Cards_True() {
        this.deck.fillDeck();
        int expected = 52;
        int actual = this.deck.getDeck().length;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testDealCards_EachPlayer13Cards_True() {
        this.deck.fillDeck();
        this.deck.shuffleDeck();
        int expected = 13;
        int actual1 = this.deck.dealCards().length;
        int actual2 = this.deck.dealCards().length;
        int actual3 = this.deck.dealCards().length;
        int actual4 = this.deck.dealCards().length;
        Assertions.assertEquals(expected, actual1);
        Assertions.assertEquals(expected, actual2);
        Assertions.assertEquals(expected, actual3);
        Assertions.assertEquals(expected, actual4);
    }
}
