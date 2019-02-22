package cmput402.tdd;

import static org.mockito.Mockito.mock;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Concrete class so we can call methods on abstract class Piece
 */
class ConcretePiece extends Piece {

	public ConcretePiece(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	
}

/**
 * Unit test for Piece class
 */
public class PieceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PieceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PieceTest.class );
    }

    /**
     * test for constructor, it should throw an exception if the arguments are not valid
     */
    public void testConstructor() {
    	try {
    		new ConcretePiece("R", 0, 0);
    		assert(true);
    	} catch(Exception e) {
    		assert(false);
    	}
    	
    	try {
    		new ConcretePiece("B", 0, 0);
    		assert(true);
    	} catch(Exception e) {
    		assert(false);
    	}
    	
    	try {
    		new ConcretePiece("", 0, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	try {
    		new ConcretePiece("X", 0, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	int[] validTestInput = {0, 5, 7};
    	int[] invalidTestInput = {-1, 8};
    	for (int i = 0; i < validTestInput.length; i++) {
			try {
	    		new ConcretePiece("R", validTestInput[i], 0);
	    		assert(true);
	    	} catch(Exception e) {
	    		assert(false);
	    	}
			try {
	    		new ConcretePiece("R",0, validTestInput[i]);
	    		assert(true);
	    	} catch(Exception e) {
	    		assert(false);
	    	}
    	}
    	
    	for (int i = 0; i < invalidTestInput.length; i++) {
			try {
	    		new ConcretePiece("R", invalidTestInput[i], 0);
	    		assert(false);
	    	} catch(Exception e) {
	    		assert(true);
	    	}
			try {
	    		new ConcretePiece("R",0, invalidTestInput[i]);
	    		assert(false);
	    	} catch(Exception e) {
	    		assert(true);
	    	}
    	}
    }
    
    /**
     * test for getColor
     * @throws Exception
     */
    public void testGetColor() throws Exception {
    	ConcretePiece concretePiece = new ConcretePiece("R", 0, 0);
    	assert(concretePiece.getColor() == "R");
    	concretePiece = new ConcretePiece("B", 0, 0);
    	assert(concretePiece.getColor() == "B");
    }
    
    /**
     * test for getYPosition
     * @throws Exception
     */
    public void testGetYPosition() throws Exception {
    	ConcretePiece concretePiece = new ConcretePiece("R", 1, 2);
    	assert(concretePiece.getYPosition() == 2);
    }
    
}
