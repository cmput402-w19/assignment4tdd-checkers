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
    
    public void testGetBlackTotalPieces() {
    	Board checkersBoard = new Board();
    	
    	assert(checkersBoard.getBlackTotalPiece() == 12);
    }

    public void testGetRedTotalPieces() {
	    Board checkersBoard = new Board();

	    assert(checkersBoard.getRedTotalPiece() == 12);
    }

    public void testPieceInLegalBound() {
        Board checkersBoard = new Board();

        assertTrue(checkersBoard.pieceInLegalBound(4,4));
        assertFalse(checkersBoard.pieceInLegalBound(-1, 3));
        assertFalse(checkersBoard.pieceInLegalBound(8, 2));
        assertFalse(checkersBoard.pieceInLegalBound(3, -1));
        assertFalse(checkersBoard.pieceInLegalBound(3, 9));
    }
}