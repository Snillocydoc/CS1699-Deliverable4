package com.ybrikman.funky.tictactoe;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;
/**
 * Created by cody on 11/28/14.
 */
@RunWith(Theories.class)
public class BoardMathHelperPropertyTests
{
    //Tests that every return value of this function has greater than 0 digits
    @Test @Theory public void testNumberOfDigits(@ForAll int num)
    {
        assumeThat(num ,any(Integer.TYPE));
        int digits=BoardMathHelpers.numberOfDigits(num);
        assertTrue(digits>0);

    }
    @Test @Theory public void testIsPerfectSquare(@ForAll Integer num)
    {
        assumeThat(num,any(Integer.TYPE));
        boolean ans=BoardMathHelpers.isPerfectSquare(num);
        if(ans) {
            assertFalse(num % 1 == 0);
        }
        else {
            assertTrue(num % 1 == 0);
        }

    }
    @Test @Theory public void testDefaultBoard()
    {
       List<java.util.Optional<Player>> board=BoardMathHelpers.defaultBoard();
       assertTrue(board.size()==BoardMathHelpers.getDefaultBoardSize());

    }
    @Test @Theory public void testCalculateWinningRowIndicesSizes()
    {
        int rowSize=3;
        List<List<Integer>> indices = BoardMathHelpers.calculateWinningRowIndices(rowSize*rowSize,rowSize);

        //Each list of winning indices should be the length of rowSize
        for(List<Integer> index : indices) {
            assertEquals(index.size(), rowSize);
        }


    }

}
