package com.ybrikman.funky.tictactoe;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.Test;
import org.junit.contrib.theories.*;
import org.junit.runner.RunWith;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
/**
 * Created by Cody Collins
 */
@RunWith(Theories.class)
public class BoardMathHelperPropertyTests
{
    //Tests that every return value of this function has greater than 0 digits
    //It is impossible to have an int with no digits
    @Test @Theory public void testNumberOfDigitsProperty(@ForAll int num)
    {
        assumeThat(num ,any(Integer.TYPE));
        int digits=BoardMathHelpers.numberOfDigits(num);
        assertTrue(digits>0);

    }
    /*
     *  Tests the boolean answer of the function
     *  This test was difficult for testing properties without
     *  implementing the actual function, since it is so simple
     */
    @Test @Theory public void testIsPerfectSquare(@ForAll int num)
    {
        assumeThat(num,any(Integer.TYPE));
        boolean ans=BoardMathHelpers.isPerfectSquare(num);
        Integer sqrt = (int)(Math.sqrt(num)+0.5);
        if(ans) {

            assertEquals(num, sqrt * sqrt);
        }
        else {
            assertNotEquals(num, sqrt * sqrt);
        }

    }
    /*
     *  Tests the size of the List returned by the defaultBoard() function
     *  The List size should match the DEFAULT_BOARD_SIZE constant in BoardMathHelpers
     */
    @Test @Theory public void testDefaultBoardSizeProperty()
    {
       List<java.util.Optional<Player>> board=BoardMathHelpers.defaultBoard();
       assertEquals(board.size(), BoardMathHelpers.getDefaultBoardSize());

    }
    /*
     *  ARGS- Keep rowSize in the range of 2 to 100 for reasonable values
     *          (Playing with a board size less than 2 is pointless and playing with
     *           a board size greater than 100 is highly unlikely)
     *  The method Tests the size of each List of winning indices
     *  In order to win tic-tac-toe, the winning combination needs to be exactly
     *  the length of one side of the tic-tac-toe board, going either diagonally,
     *  vertically, or horizontally.
     */
    @Test @Theory public void testCalculateWinningRowIndicesSizes(@ForAll @InRange(minInt=2, maxInt=100)int rowSize)
    {
        List<List<Integer>> indices = BoardMathHelpers.calculateWinningRowIndices(rowSize*rowSize,rowSize);
        //Each list of winning indices should be the length of rowSize
        for(List<Integer> index : indices) {
            assertEquals(index.size(), rowSize);
        }


    }

}
