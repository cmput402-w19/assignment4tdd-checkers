package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

class ConcretePiece extends Piece {

	public ConcretePiece(String color, int xPosition, int yPosition) throws Exception {
		super(color, xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	
}

/**
 * Unit test for Piece
 */
public class PieceTest 
    extends TestCase
{
	
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
    		ConcretePiece concretePiece = new ConcretePiece("R", 0, 0);
    		assert(true == true);
    	} catch(Exception e) {
    		assert(true == false);
    	}
    	
    	try {
    		ConcretePiece concretePiece = new ConcretePiece("B", 0, 0);
    		assert(true == true);
    	} catch(Exception e) {
    		assert(true == false);
    	}
    	
    	try {
    		ConcretePiece concretePiece = new ConcretePiece("", 0, 0);
    		assert(true == false);
    	} catch(Exception e) {
    		assert(true == true);
    	}
    	
    	try {
    		ConcretePiece concretePiece = new ConcretePiece("X", 0, 0);
    		assert(true == false);
    	} catch(Exception e) {
    		assert(true == true);
    	}
    	
    	int max = 8;
    	int min = -1;
    	int[] validTestInput = {0, 5, 7};
    	int[] invalidTestInput = {-1, 8};
    	for (int i = 0; i < validTestInput.length; i++) {
			try {
	    		ConcretePiece concretePiece = new ConcretePiece("R", validTestInput[i], 0);
	    		assert(true == true);
	    	} catch(Exception e) {
	    		assert(true == false);
	    	}
			try {
	    		ConcretePiece concretePiece = new ConcretePiece("R",0, validTestInput[i]);
	    		assert(true == true);
	    	} catch(Exception e) {
	    		assert(true == false);
	    	}
    	}
    	
    	for (int i = 0; i < invalidTestInput.length; i++) {
			try {
	    		ConcretePiece concretePiece = new ConcretePiece("R", invalidTestInput[i], 0);
	    		assert(true == false);
	    	} catch(Exception e) {
	    		assert(true == true);
	    	}
			try {
	    		ConcretePiece concretePiece = new ConcretePiece("R",0, invalidTestInput[i]);
	    		assert(true == false);
	    	} catch(Exception e) {
	    		assert(true == true);
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
     * test for getXPosition
     * @throws Exception
     */
    public void testGetXPosition() throws Exception {
    	ConcretePiece concretePiece = new ConcretePiece("R", 1, 2);
    	assert(concretePiece.getXPosition() == 1);
    }
    
    /**
     * test for getYPosition
     * @throws Exception
     */
    public void testGetYPosition() throws Exception {
    	ConcretePiece concretePiece = new ConcretePiece("R", 1, 2);
    	assert(concretePiece.getYPosition() == 2);
    }
    
    /**
     * test for setPosition, it should throw an exception if the arguments are not valid
     * @throws Exception
     */
    public void testSetPosition() throws Exception {
    	ConcretePiece concretePiece = new ConcretePiece("R", 1, 2);
    	
    	int max = 8;
    	int min = -1;
    	int[] validTestInput = {0, 5, 7};
    	int[] invalidTestInput = {-1, 8};
    	for (int i = 0; i < validTestInput.length; i++) {
    		try {
				concretePiece.setPosition(validTestInput[i], 0);
				assert(concretePiece.getXPosition() == validTestInput[i]);
	        	assert(concretePiece.getYPosition() == 0);
	        	concretePiece.setPosition(0, validTestInput[i]);
	        	assert(concretePiece.getXPosition() == 0);
	        	assert(concretePiece.getYPosition() == validTestInput[i]);
			} catch (Exception e) {
				assert(true == false);
			}
    	}
    	
    	for (int i = 0; i < invalidTestInput.length; i++) {
    		try {
    			concretePiece.setPosition(invalidTestInput[i], 0);
    			assert(true == false);
    		} catch(Exception e) {
	    		assert(true == true);
	    	}
    		try {
    			concretePiece.setPosition(0, invalidTestInput[i]);
    			assert(true == false);
    		} catch(Exception e) {
	    		assert(true == true);
	    	}
    	}
    }
    
    /**
     * test for isEnemyPiece
     * @throws Exception
     */
    public void testIsEnemyPiece() throws Exception {
    	ConcretePiece concretePiece1 = new ConcretePiece("R", 0, 0);
    	ConcretePiece concretePiece2 = new ConcretePiece("B", 1,1);
    	ConcretePiece concretePiece3 = new ConcretePiece("R", 2, 2);
    	ConcretePiece concretePiece4 = new ConcretePiece("B", 3, 3);
    	assert(concretePiece1.isEnemyPiece(concretePiece2) == true);
    	assert(concretePiece2.isEnemyPiece(concretePiece1) == true);
    	assert(concretePiece1.isEnemyPiece(concretePiece3) == false);
    	assert(concretePiece2.isEnemyPiece(concretePiece4) == false);
    	assert(concretePiece2.isEnemyPiece(null) == false);
    }
}


