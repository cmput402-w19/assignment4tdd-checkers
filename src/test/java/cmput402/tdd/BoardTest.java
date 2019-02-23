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

    /**
     * This unit test expects the board to initialize the pieces correctly
     */
    public void testGetPiece() {
	    Board checkersBoard = new Board();

        for(int evenCol = 0, oddCol = 1; evenCol < maxLength; ++evenCol, ++oddCol) {
            assert(checkersBoard.getPiece(0, evenCol) instanceof Piece);
            assert(checkersBoard.getPiece(1, oddCol) instanceof Piece);
            assert(checkersBoard.getPiece(2, evenCol) instanceof Piece);

            assert(checkersBoard.getPiece(5, oddCol) instanceof Piece);
            assert(checkersBoard.getPiece(6, evenCol) instanceof Piece);
            assert(checkersBoard.getPiece(7, oddCol) instanceof Piece);
        }
    }
}