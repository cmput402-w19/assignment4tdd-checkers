package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import cmput402.tdd.Board;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BoardTest extends TestCase {
	
	int maxLength = 8;

	public BoardTest( String boardClassTest ) {
        super( boardClassTest );
	}
	 
    public static Test suite() {
        return new TestSuite( BoardTest.class );
    }

    /**
     *Tests to see if the requested location is a piece (not null) or empty (null)
     * The test cases are based on illegal bounds, a legal bound with no piece class (null) and
     * an actual instantiated piece.
     */
    public void testGetBoardPiece() throws Exception {
	    Board checkersBoard = new Board();

	    assertNotNull(checkersBoard.getPiece(1,1));
	    assertNull(checkersBoard.getPiece(4, 4));
	    assertNull(checkersBoard.getPiece(-1, 2));
    }

    /**
     * Unit test to test the proper initiation of the board with the pieces in the
     * correct position.
     * @throws Exception
     */
    public void testInitBoard() throws Exception {
        Board checkersBoard = new Board();

        for(int oddCol = 1, evenCol = 0; oddCol < maxLength; oddCol +=2, evenCol +=2) {
            //The following block tests the proper instantiation of pieces
            assertNotNull(checkersBoard.getPiece(0, evenCol));
            assertNotNull(checkersBoard.getPiece(1, oddCol));
            assertNotNull(checkersBoard.getPiece(2, evenCol));

            assertNotNull(checkersBoard.getPiece(5, oddCol));
            assertNotNull(checkersBoard.getPiece(6, evenCol));
            assertNotNull(checkersBoard.getPiece(7, oddCol));

            //The following tests for the gaps between the checkers pieces instantiation
            assertNull(checkersBoard.getPiece(0, oddCol));
            assertNull(checkersBoard.getPiece(1, evenCol));
            assertNull(checkersBoard.getPiece(2, oddCol));

            assertNull(checkersBoard.getPiece(5, evenCol));
            assertNull(checkersBoard.getPiece(6, oddCol));
            assertNull(checkersBoard.getPiece(7, evenCol));
        }

        for(int row = 3; row < 5; ++row) {
            for(int col = 0; col < 8; ++col) {
                assertNull(checkersBoard.getPiece(row, col));
            }
        }
    }

    public void testGetBlackTotalPieces() throws Exception {
    	Board checkersBoard = new Board();
    	
    	assert(checkersBoard.getBlackTotalPiece() == 12);
    }

    public void testGetRedTotalPieces() throws Exception {
	    Board checkersBoard = new Board();

	    assert(checkersBoard.getRedTotalPiece() == 12);
    }

    public void testPieceInLegalBound() throws Exception {
        Board checkersBoard = new Board();

        assertTrue(checkersBoard.inBounds(4,4));
        assertFalse(checkersBoard.inBounds(-1, 3));
        assertFalse(checkersBoard.inBounds(8, 2));
        assertFalse(checkersBoard.inBounds(3, -1));
        assertFalse(checkersBoard.inBounds(3, 9));
    }

    /**
     * Unit test to validate if the target move and the direction is valid
     * @throws Exception
     */

    public void testIsValidMove() throws Exception {
        Board checkersBoard = new Board();

        ArrayList<int[]> testMoves = new ArrayList<int[]>() ;
        int[] output = checkersBoard.isValidMove(2, 4, testMoves);
        int[] expectedOutput = null;
        assertNull(output);

        int[] negDir = new int[] {-1, 2, 1, 1};
        testMoves.add(negDir);
        output = checkersBoard.isValidMove(2, 4, testMoves);
        assertNull(output);

        int[] legalDir = new int[] {2, 4, 1, 2};
        testMoves.add(legalDir);
        output = checkersBoard.isValidMove(2, 4, testMoves);
        expectedOutput = new int[] {2, 4, 1, 2};
        assertTrue(Arrays.equals(output, expectedOutput));

        output = checkersBoard.isValidMove(1, 4, testMoves);
        assertNull(output);
    }

    /**
     * Tests if the piece is able to capture a piece.
     * Takes in an int array of values [targetRow, targetCol, distance, direction]
     * If the output is 0, the move is not a capture.
     * Any output from 1-6 is a capture move. 
     * @throws Exception
     */

    public void testIsCapture() throws Exception {
        Board board = new Board();

        int[] move = new int[] {2, 4, 2, 1};
        assert(board.isCapture(move) == 1);

        move = new int[] {2, 4, 2, 2};
        assert(board.isCapture(move) == 2);

        move = new int[] {2, 4, 2, 3};
        assert(board.isCapture(move) == 3);

        move = new int[] {2, 4, 2, 4};
        assert(board.isCapture(move) == 4);

        move = new int[] {2, 4, 2, 5};
        assert(board.isCapture(move) == 5);

        move = new int[] {2, 4, 2, 6};
        assert(board.isCapture(move) == 6);

        move = new int[] {2, 4, 1, 6};
        assert(board.isCapture(move) == 0);

        move = new int[] {};
        try {
            board.isCapture(move);
            assert(false);
        } catch(Exception e){
            assert(true);
        }
    }

    public void testSetPiecePosition() throws Exception {
        Board board = new Board();
        Piece testPawn = new Pawn("B", 3, 3);

        board.setPiecePosition(testPawn, 3, 3);
        assertNotNull(board.getPiece(3, 3));

        try {
            board.setPiecePosition(testPawn,-1, -1);
            assert(false);
        } catch(Exception e) {
            assert(true);
        }

        // Test the if statement branch for if piece is null
        board.setPiecePosition(null, 4,4);
        assertNull(board.getPiece(4, 4));
    }

}