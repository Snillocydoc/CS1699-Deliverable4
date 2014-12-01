package com.ybrikman.funky.tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Created by cody on 11/29/14.
 */

public class CombinatorialTestSuite {
    @Test
    public void testPairs1()
    {
        String s = new String("0 1 2 3 4 5 6 7 8");

        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    @Test
    public void testPairs2()
    {
        String s = new String("1 3 5 7 0 2 4 6 8");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    @Test
    public void testPairs3()
    {
        String s = new String("2 5 8 1 4 7 0 3 6");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    @Test
    public void testPairs4()
    {
        String s = new String("3 7 2 6 1 5 0 4 8");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    @Test
    public void testPairs5()
    {
        String s = new String("4 0 5 1 6 2 7 3 8");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }

}
