package com.ybrikman.funky.tictactoe;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.*;
import org.junit.runner.RunWith;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
/**
 * Created by cody on 11/28/14.
 */
@RunWith(Theories.class)
public class BoardMathHelperPropertyTests
{
    //Tests that every return value of this function has greater than 0 digits
    @Test @Theory public void testNumberOfDigitsProperty(@ForAll int num)
    {
        assumeThat(num ,any(Integer.TYPE));
        int digits=BoardMathHelpers.numberOfDigits(num);
        assertTrue(digits>0);

    }
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
    @Test @Theory public void testDefaultBoardSizeProperty()
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
