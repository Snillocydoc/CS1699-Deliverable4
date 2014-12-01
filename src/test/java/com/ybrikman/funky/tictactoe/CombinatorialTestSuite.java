package com.ybrikman.funky.tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Created by cody on 11/29/14.
 */

public class CombinatorialTestSuite {
    /*
     * Tests pairs (0,1) (1,2) (2,3) (3,4) (4,5) (5,6) (6,7) (7,8)
     */
    @Test
    public void testPairs1()
    {
        String s = new String("0 1 2 3 4 5 6 7 8");

        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (1,3) (3,5) (5,7) (7,0) (0,2) (2,4) (4,6) (6,8)
     */
    @Test
    public void testPairs2()
    {
        String s = new String("1 3 5 7 0 2 4 6 8");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (2,5) (5,8) (8,1) (1,4) (4,7) (7,0) (0,3) (3,6)
     */
    @Test
    public void testPairs3()
    {
        String s = new String("2 5 8 1 4 7 0 3 6");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (3,7) (7,2) (2,6) (6,1) (1,5) (5,0) (0,4) (4,8)
     */
    @Test
    public void testPairs4()
    {
        String s = new String("3 7 2 6 1 5 0 4 8");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (4,0) (0,5) (5,1) (1,6) (6,2) (2,7) (7,3) (3,8)
     */
    @Test
    public void testPairs5()
    {
        String s = new String("4 0 5 1 6 2 7 3 8");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
    * Tests pairs (5,2) (2,8) (8,6) (6,3) (3,0) (0,7) (7,4) (4,1)
    */
    @Test
     public void testPairs6()
    {
        String s = new String("5 2 8 6 3 0 7 4 1");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (6,4) (4,2) (2,0) (0,8) (8,7) (7,5) (5,3) (3,1)
     */
    @Test
    public void testPairs7()
    {
        String s = new String("6 4 2 0 8 7 5 3 1");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (7,6) (6,4) (4,3) (3,2) (2,1) (1,8) (8,0) (0,5)
     */
    @Test
    public void testPairs8()
    {
        String s = new String("7 6 4 3 2 1 8 0 5");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (8,5) (5,4) (4,1) (1,0) (0,6) (6,7) (7,3) (3,2)
     */
    @Test
    public void testPairs9()
    {
        String s = new String("8 5 4 1 0 6 7 3 2");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (8,2) (2,1) (1,7) (7,6) (6,0) (0,3) (3,4) (4,5)
     */
    @Test
    public void testPairs10()
    {
        String s = new String("8 2 1 7 6 0 3 4 5");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (8,3) (3,7) (7,1) (1,6) (6,5) (5,2) (2,4) (4,0)
     */
    @Test
    public void testPairs11()
    {
        String s = new String("8 3 7 1 6 5 2 4 0");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }
    /*
     * Tests pairs (8,4) (4,5) (5,6) (6,7) (7,0) (0,1) (1,2) (2,3)
     */
    @Test
    public void testPairs12()
    {
        String s = new String("8 4 5 6 7 0 1 2 3");
        ByteArrayInputStream in = new ByteArrayInputStream(s.toString().getBytes());

        new TicTacToe().play(in);

    }


}
