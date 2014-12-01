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
 * Created by cody on 11/30/14.
 */
@RunWith(Theories.class)
public class GameStateTests {
    @Test @Theory public void testMakeMove(@ForAll @InRange(minInt=0, maxInt=8) int move,@ForAll @InRange(minInt=0, maxInt=8) int avail)
    {
        GameState game=new GameState();
        GameState before;

       before=game;
       if(game.getCurrentPlayer()==Player.O) {
           game = game.makeMove(move);
           assertEquals(game.getCurrentPlayer(),Player.X);
       }else{
           game=game.makeMove(move);
           assertEquals(game.getCurrentPlayer(),Player.O);
       }
       //After making a single move, the game should not be equal to its previous state
       assertNotEquals(before,game);
       //After making a single move, the game should not be over
       assertFalse(game.isGameOver());
       //After making a single move, the should not have a winner
       assertEquals(game.findWinner(), Optional.empty());

    }
    @Test @Theory public void testIsGameOver()
    {
        GameState state = new GameState();
        assertFalse(state.isGameOver());
        for(int x=0;x<8;x++)
            state=state.makeMove(x);
        assertTrue(state.isGameOver());

    }
    @Test @Theory public void testFindWinner()
    {
        GameState state = new GameState();
        for(int x=0;x<8;x++)
            state=state.makeMove(x);
        assertTrue(state.findWinner().isPresent());
        assertEquals( state.findWinner().get(),Player.X);
    }

}
