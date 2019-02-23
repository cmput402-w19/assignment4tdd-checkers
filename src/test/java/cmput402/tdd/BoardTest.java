package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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

	    assertNotNull(checkersBoard.getBoardPiece(1,1));
	    assertNull(checkersBoard.getBoardPiece(6, 6));
	    assertNull(checkersBoard.getBoardPiece(-1, 2));
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
            assertNotNull(checkersBoard.getBoardPiece(0, evenCol));
            assertNotNull(checkersBoard.getBoardPiece(1, oddCol));
            assertNotNull(checkersBoard.getBoardPiece(2, evenCol));

            assertNotNull(checkersBoard.getBoardPiece(5, oddCol));
            assertNotNull(checkersBoard.getBoardPiece(6, evenCol));
            assertNotNull(checkersBoard.getBoardPiece(7, oddCol));

            //The following tests for the gaps between the checkers pieces instantiation
            assertNull(checkersBoard.getBoardPiece(0, oddCol));
            assertNull(checkersBoard.getBoardPiece(1, evenCol));
            assertNull(checkersBoard.getBoardPiece(2, oddCol));

            assertNull(checkersBoard.getBoardPiece(5, evenCol));
            assertNull(checkersBoard.getBoardPiece(6, oddCol));
            assertNull(checkersBoard.getBoardPiece(7, evenCol));
        }

        for(int row = 3; row < 5; ++row) {
            for(int col = 0; col < 8; ++col) {
                assertNull(checkersBoard.getBoardPiece(row, col));
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

        assertTrue(checkersBoard.pieceInLegalBound(4,4));
        assertFalse(checkersBoard.pieceInLegalBound(-1, 3));
        assertFalse(checkersBoard.pieceInLegalBound(8, 2));
        assertFalse(checkersBoard.pieceInLegalBound(3, -1));
        assertFalse(checkersBoard.pieceInLegalBound(3, 9));
    }
}