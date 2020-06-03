//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package gamelogic.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundTest {
    private Round round;
    private Card[] cardSet;

    RoundTest() {
    }

    @BeforeEach
    void setup() {
        this.round = new Round();
        this.cardSet = new Card[3];
        this.cardSet[0] = new Card();
        this.cardSet[1] = new Card();
        this.cardSet[2] = new Card();
    }

    @Test
    void testThreeOfAKind_MaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(13);
        this.cardSet[2].setCardNumber(13);
        int actual = this.round.threeOfAKind(this.cardSet);
        int expected = 5013;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testThreeOfAKind_MinValue_True() {
        this.cardSet[0].setCardNumber(1);
        this.cardSet[1].setCardNumber(1);
        this.cardSet[2].setCardNumber(1);
        int actual = this.round.threeOfAKind(this.cardSet);
        int expected = 5001;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStraightFlush_MaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(12);
        this.cardSet[2].setCardNumber(11);
        this.cardSet[0].setCardGrade(1);
        this.cardSet[1].setCardGrade(1);
        this.cardSet[2].setCardGrade(1);
        int actual = this.round.straightFlush(this.cardSet);
        int expected = 4014;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStraightFlush_2ndMaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(2);
        this.cardSet[2].setCardNumber(1);
        this.cardSet[0].setCardGrade(1);
        this.cardSet[1].setCardGrade(1);
        this.cardSet[2].setCardGrade(1);
        int actual = this.round.straightFlush(this.cardSet);
        int expected = 4013;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStraightFlush_MinValue_True() {
        this.cardSet[0].setCardNumber(3);
        this.cardSet[1].setCardNumber(2);
        this.cardSet[2].setCardNumber(1);
        this.cardSet[0].setCardGrade(1);
        this.cardSet[1].setCardGrade(1);
        this.cardSet[2].setCardGrade(1);
        int actual = this.round.straightFlush(this.cardSet);
        int expected = 4003;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStraight_MaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(12);
        this.cardSet[2].setCardNumber(11);
        int actual = this.round.straight(this.cardSet);
        int expected = 3514;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStraight_2ndMaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(2);
        this.cardSet[2].setCardNumber(1);
        int actual = this.round.straight(this.cardSet);
        int expected = 3513;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStraight_MinValue_True() {
        this.cardSet[0].setCardNumber(3);
        this.cardSet[1].setCardNumber(2);
        this.cardSet[2].setCardNumber(1);
        int actual = this.round.straight(this.cardSet);
        int expected = 3503;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFlush_MaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(11);
        this.cardSet[2].setCardNumber(10);
        this.cardSet[0].setCardGrade(1);
        this.cardSet[1].setCardGrade(1);
        this.cardSet[2].setCardGrade(1);
        int actual = this.round.flush(this.cardSet);
        int expected = 3420;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFlush_MinValue_True() {
        this.cardSet[0].setCardNumber(4);
        this.cardSet[1].setCardNumber(2);
        this.cardSet[2].setCardNumber(1);
        this.cardSet[0].setCardGrade(1);
        this.cardSet[1].setCardGrade(1);
        this.cardSet[2].setCardGrade(1);
        int actual = this.round.flush(this.cardSet);
        int expected = 2421;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPair_MaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(12);
        this.cardSet[2].setCardNumber(12);
        int actual = this.round.pair(this.cardSet);
        int expected = 1513;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testPair_MinValue_True() {
        this.cardSet[0].setCardNumber(1);
        this.cardSet[1].setCardNumber(13);
        this.cardSet[2].setCardNumber(13);
        int actual = this.round.pair(this.cardSet);
        int expected = 1501;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHighCard_MaxValue_True() {
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(11);
        this.cardSet[2].setCardNumber(10);
        int actual = this.round.highCard(this.cardSet);
        int expected = 1420;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHighCard_MinValue_True() {
        this.cardSet[0].setCardNumber(4);
        this.cardSet[1].setCardNumber(2);
        this.cardSet[2].setCardNumber(1);
        int actual = this.round.highCard(this.cardSet);
        int expected = 421;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void quickTest(){
        cardSet = new Card[3];
        this.cardSet[0] = new Card();
        this.cardSet[1] = new Card();
        this.cardSet[2] = new Card();
        this.cardSet[0].setCardNumber(13);
        this.cardSet[1].setCardNumber(13);
        this.cardSet[2].setCardNumber(13);

        Card[] cards = cardSet.clone();

        assertEquals(cards[1], cardSet[1]);
    }
}
