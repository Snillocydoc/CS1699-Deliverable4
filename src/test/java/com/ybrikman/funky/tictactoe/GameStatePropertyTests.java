package com.ybrikman.funky.tictactoe;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Cody Collins
 */
@RunWith(Theories.class)
public class GameStatePropertyTests {
    /*
     *  Tests whether the game alternates the current player after each move
     */
    @Test @Theory public void testMakeMovePlayerAlternation(@ForAll @InRange(minInt=0, maxInt=8) int move)
    {
        GameState game=new GameState();
        GameState before;
        before=game;

       //Each time a move is made, the current player should alternate
       game = game.makeMove(move);
       assertNotEquals(before.getCurrentPlayer(), game.getCurrentPlayer());



    }
    /*
     *  Tests whether a GameState object is the same as another after a move is made
     */
    @Test @Theory public void testMakeMoveStateChange(@ForAll @InRange(minInt=0, maxInt=8) int move)
    {
        GameState game=new GameState();
        GameState before;

        before=game;
        game=game.makeMove(move);
        //After making a single move, the game should not be equal to its previous state
        assertNotEquals(before,game);

    }
    /*
     *  Tests findWinner() after a single move is made
     */
    @Test @Theory public void testMakeMoveWinner(@ForAll @InRange(minInt=0, maxInt=8) int move)
    {
        GameState game=new GameState();
        game=game.makeMove(move);
        //After making a single move, there should not be a winner yet
        assertEquals(game.findWinner(), Optional.empty());

    }
    /*
     *  Tests whether a game is over after all the moves are made to win a game
     */
    @Test @Theory public void testIsGameOver()
    {
        GameState state = new GameState();
        assertFalse(state.isGameOver());
        for(int x=0;x<8;x++)
            state=state.makeMove(x);
        assertTrue(state.isGameOver());

    }
    /*
     *  Tests whether there is a winner present after no moves are made
     */
    @Test @Theory public void testFindWinnerNotPresentProperty()
    {
        GameState state = new GameState();
        //game does not complete, so a winner should not be present
        assertFalse(state.findWinner().isPresent());

    }
    /*
     *  Tests whether there is a winner present after winning moves are made
     */
    @Test @Theory public void testFindWinnerPresentProperty()
    {
        GameState state = new GameState();
        //complete game with a winner, so a winner should be present
        for(int x=0;x<8;x++)
            state=state.makeMove(x);
        assertTrue(state.findWinner().isPresent());
    }

}
