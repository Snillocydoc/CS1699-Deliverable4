package com.ybrikman.funky.tictactoe;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;
/**
 * Created by cody on 11/28/14.
 */
@RunWith(Theories.class)
public class BoardMathHelperTests
{

    @Test @Theory public void testNumberOfDigits(@ForAll int num)
    {
        assumeThat(num ,any(Integer.TYPE));
        int digits=BoardMathHelpers.numberOfDigits(num);
        assertTrue(digits>0);

    }
    @Test @Theory public void testIsPerfectSquare(@ForAll int num)
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
    @Test @Theory public void testCalculateWinningRowIndices()
    {
        List<List<Integer>> indices = BoardMathHelpers.calculateWinningRowIndices(BoardMathHelpers.getDefaultBoardSize(),(int)Math.sqrt(BoardMathHelpers.getDefaultBoardSize()));

    }

}
