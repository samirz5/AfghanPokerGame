package gamelogic;

import gamelogic.models.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
        private Card[] cardSet;
        Game game;
        @BeforeEach
        void setup(){
          game = new Game(1, 1);
            game.joinGame("Test", 50);
            game.joinGame("Test1", 50);
            game.joinGame("Test2", 50);

            this.cardSet = new Card[3];
            this.cardSet[0] = new Card();
            this.cardSet[1] = new Card();
            this.cardSet[2] = new Card();
        }

        @Test
        void testJoinGame_WithUserName_AssertTrue(){
            game.joinGame("Test3", 50);

            //results
            int expected = 4;
            int actual = game.getPlayers().size();

            //assert
            assertEquals(expected, actual);
        }

        @Test
        void testReadyToPlayGame_AllPlayersReady_ReturnTrue(){
            game.joinGame("Test3", 50);
            game.readyToPlayGame("Test");
            game.readyToPlayGame("Test1");
            game.readyToPlayGame("Test2");

            assertTrue(game.readyToPlayGame("Test3"));
        }

        @Test
        void testReadyWithCardSorting_AllPlayersReady_ReturnTrue(){
            this.cardSet[0].setCardNumber(13);
            this.cardSet[1].setCardNumber(13);
            this.cardSet[2].setCardNumber(13);
            this.cardSet[0].setCardGrade(1);
            this.cardSet[1].setCardGrade(2);
            this.cardSet[2].setCardGrade(3);
            game.joinGame("Test3", 50);
            game.readyWithCardSorting("Test", cardSet, cardSet, cardSet, cardSet);
            game.readyWithCardSorting("Test1", cardSet, cardSet, cardSet, cardSet);
            game.readyWithCardSorting("Test2", cardSet, cardSet, cardSet, cardSet);

            assertTrue(game.readyWithCardSorting("Test3", cardSet, cardSet, cardSet, cardSet));
        }

        @Test
        void testPlaceBet_BalanceMinusBet_AssertEqualTrue(){

        }

        @Test
        void testGetWinner_ReturnName_AsserEqualsTrue(){
            this.cardSet[0].setCardNumber(7);
            this.cardSet[1].setCardNumber(7);
            this.cardSet[2].setCardNumber(7);
            this.cardSet[0].setCardGrade(1);
            this.cardSet[1].setCardGrade(2);
            this.cardSet[2].setCardGrade(3);
            game.joinGame("Test3", 50);
            game.readyWithCardSorting("Test3", cardSet, cardSet, cardSet, cardSet);
            game.readyWithCardSorting("Test1", cardSet, cardSet, cardSet, cardSet);
            game.readyWithCardSorting("Test2", cardSet, cardSet, cardSet, cardSet);

            this.cardSet[0] = new Card();
            this.cardSet[1] = new Card();
            this.cardSet[2] = new Card();
            this.cardSet[0].setCardNumber(13);
            this.cardSet[1].setCardNumber(13);
            this.cardSet[2].setCardNumber(13);
            this.cardSet[0].setCardGrade(1);
            this.cardSet[1].setCardGrade(2);
            this.cardSet[2].setCardGrade(3);
            game.readyWithCardSorting("Test", cardSet, cardSet, cardSet, cardSet);

            String expected = "Test";
            String actual = game.getRoundWinner();

            assertEquals(expected, actual);
        }



}