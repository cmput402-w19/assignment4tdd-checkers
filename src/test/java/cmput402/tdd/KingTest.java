package cmput402.tdd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import static org.mockito.Matchers.anyInt;

/**
 * Unit test for King class
 */
public class KingTest 
    extends TestCase
    
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KingTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KingTest.class );
    }

    /**
     * test for constructor, it should throw an exception if the arguments are not valid
     * @throws Exception 
     */
    public void testConstructor() throws Exception {
    	King king = new King("R", 0, 0);
    	assertThat(king, instanceOf(Piece.class));
    	try {
    		new King("R", 0, 0);
    		assert(true);
    	} catch(Exception e) {
    		assert(false);
    	}
    	
    	try {
    		new King("B", 0, 0);
    		assert(true);
    	} catch(Exception e) {
    		assert(false);
    	}
    	
    	try {
    		new King("", 0, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	try {
    		new King("X", 0, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	int[] validTestInput = {0, 5, 7};
    	int[] invalidTestInput = {-1, 8};
    	for (int i = 0; i < validTestInput.length; i++) {
			try {
	    		new King("R", validTestInput[i], 0);
	    		assert(true);
	    	} catch(Exception e) {
	    		assert(false);
	    	}
			try {
	    		new King("R",0, validTestInput[i]);
	    		assert(true);
	    	} catch(Exception e) {
	    		assert(false);
	    	}
    	}
    	
    	for (int i = 0; i < invalidTestInput.length; i++) {
			try {
	    		new King("R", invalidTestInput[i], 0);
	    		assert(false);
	    	} catch(Exception e) {
	    		assert(true);
	    	}
			try {
	    		new King("R",0, invalidTestInput[i]);
	    		assert(false);
	    	} catch(Exception e) {
	    		assert(true);
	    	}
    	}
    }
    
    /**
     * test for getName of the piece that is shown on the board
     * @throws Exception 
     */
    public void testGetName() throws Exception {
    	King king = new King("R", 0, 0);
    	assertEquals(king.getName(), "RK");
    	king = new King("B", 0, 0);
    	assertEquals(king.getName(), "BK");
    }
    
    /**
     * test for testGetTargetCoord 
     * it should return the 4 different diagonal coordinate of distance 1 or 2 
     * depending on the arguments
     * output: [targetX, targetY, distance, direction] 
     * where direction:3 is up left, direction:4 is down left, 
     * direction:5 is up right, direction:6 is down right
     * @throws Exception 
     */
    public void testGetTargetCoord() throws Exception {
    	int x = 0;
    	int y = 0;
    	int[] output;
    	int[] expectedOutput;
    	
    	King king = new King("R", x, y);
    	
    	//left up
    	output = king.getTargetCoord(true, true, 1);
    	expectedOutput = new int[] {-1, -1, 1, 3};
    	assertTrue(Arrays.equals(expectedOutput, output));
    	
    	//left down
    	output = king.getTargetCoord(true, false, 1);
    	expectedOutput = new int[] {1, -1, 1, 4};
    	assertTrue(Arrays.equals(expectedOutput, output));
    	
    	//right up
    	output = king.getTargetCoord(false, true, 1);
    	expectedOutput = new int[] {-1, 1, 1, 5};
    	assertTrue(Arrays.equals(expectedOutput, output));
    	
    	//right down
    	output = king.getTargetCoord(false, false, 1);
    	expectedOutput = new int[] {1, 1, 1, 6};
    	assertTrue(Arrays.equals(expectedOutput, output));
    	
    	king = new King("R", 3, 3);
    	//left up
    	output = king.getTargetCoord(true, true, 2);
    	expectedOutput = new int[] {1, 1, 2, 3};
    	assertTrue(Arrays.equals(expectedOutput, output));
    	
    	try {
    		king = new King("R", 0, 0);
    		king.getTargetCoord(true, true, 3);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	try {
    		king = new King("R", 0, 0);
    		king.getTargetCoord(true, true, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	try {
    		king = new King("R", 0, 0);
    		king.getTargetCoord(true, true, -1);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    }
    
    private void assertLegalMoves(ArrayList<int[]> expectedOutput, ArrayList<int[]> output) {
    	assert(output.size() == expectedOutput.size());
    	for(int i = 0; i<expectedOutput.size(); i++) {
			assertEquals(Arrays.toString(expectedOutput.get(i)), Arrays.toString(output.get(i)));
		}
    }
    
    public void testLegalMoves() throws Exception {
    	Board mockBoard = mock(Board.class);
    	//top left corner
    	King myKing = new King("B", 0, 0);
    	when(mockBoard.inBounds(-1, -1)).thenReturn(false);
    	when(mockBoard.inBounds(-1, 1)).thenReturn(false);
    	when(mockBoard.inBounds(-2, -2)).thenReturn(false);
    	when(mockBoard.inBounds(-2, 2)).thenReturn(false);
    	when(mockBoard.inBounds(1, -1)).thenReturn(false);
    	when(mockBoard.inBounds(2, -2)).thenReturn(false);
    	
    	when(mockBoard.inBounds(1, 1)).thenReturn(true);
    	when(mockBoard.inBounds(2, 2)).thenReturn(true);
    	
    	when(mockBoard.getPiece(anyInt(), anyInt())).thenReturn(null);
    	
    	ArrayList<int[]> output = myKing.legalMoves(mockBoard);
    	ArrayList<int[]> expectedOutput = new ArrayList<int[]>();
    	int[] tmp = {1,1,1,6};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//top right corner
    	myKing = new King("B", 0, 7);
    	when(mockBoard.inBounds(-1, 8)).thenReturn(false);
    	when(mockBoard.inBounds(-2, 9)).thenReturn(false);
    	when(mockBoard.inBounds(1, 8)).thenReturn(false);
    	when(mockBoard.inBounds(2, 9)).thenReturn(false);
    	when(mockBoard.inBounds(-1, 6)).thenReturn(false);
    	when(mockBoard.inBounds(-2, 5)).thenReturn(false);
    	
    	when(mockBoard.inBounds(1, 6)).thenReturn(true);
    	when(mockBoard.inBounds(2, 5)).thenReturn(true);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {1,6,1,4};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//bottom left corner
    	myKing = new King("B", 7, 0);
    	when(mockBoard.inBounds(8, -1)).thenReturn(false);
    	when(mockBoard.inBounds(9, -2)).thenReturn(false);
    	when(mockBoard.inBounds(8, 1)).thenReturn(false);
    	when(mockBoard.inBounds(9, 2)).thenReturn(false);
    	when(mockBoard.inBounds(6, -1)).thenReturn(false);
    	when(mockBoard.inBounds(5, -2)).thenReturn(false);
    	
    	when(mockBoard.inBounds(6, 1)).thenReturn(true);
    	when(mockBoard.inBounds(5, 2)).thenReturn(true);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {6,1,1,5};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//bottom right corner
    	myKing = new King("B", 7, 7);
    	when(mockBoard.inBounds(8, 8)).thenReturn(false);
    	when(mockBoard.inBounds(9, 9)).thenReturn(false);
    	when(mockBoard.inBounds(8, 6)).thenReturn(false);
    	when(mockBoard.inBounds(9, 5)).thenReturn(false);
    	when(mockBoard.inBounds(6, 8)).thenReturn(false);
    	when(mockBoard.inBounds(5, 9)).thenReturn(false);
    	
    	when(mockBoard.inBounds(6, 6)).thenReturn(true);
    	when(mockBoard.inBounds(5, 5)).thenReturn(true);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {6, 6, 1, 3};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	
    	//surrounded by enemy and can capture
    	when(mockBoard.inBounds(anyInt(), anyInt())).thenReturn(true);

    	myKing = new King("R", 3, 3);    	
    	King enemyKing1 = new King("B", 2, 2);
    	King enemyKing2 = new King("B", 2, 4);
    	King enemyKing3 = new King("B", 4, 2);
    	King enemyKing4 = new King("B", 4, 4);
    	
    	when(mockBoard.getPiece(2, 2)).thenReturn(enemyKing1);
    	when(mockBoard.getPiece(2, 4)).thenReturn(enemyKing2);
    	when(mockBoard.getPiece(4, 2)).thenReturn(enemyKing3);
    	when(mockBoard.getPiece(4, 4)).thenReturn(enemyKing4);
    	
    	when(mockBoard.getPiece(1, 1)).thenReturn(null);
    	when(mockBoard.getPiece(1, 5)).thenReturn(null);
    	when(mockBoard.getPiece(5, 1)).thenReturn(null);
    	when(mockBoard.getPiece(5, 5)).thenReturn(null);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {1,1,2,3};
    	expectedOutput.add(tmp);
    	tmp = new int[] {5,1,2,4};
    	expectedOutput.add(tmp);
    	tmp = new int[] {1,5,2,5};
    	expectedOutput.add(tmp);
    	tmp = new int[] {5,5,2,6};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//surrounded by enemy and can capture
    	myKing = new King("R", 3, 3);
    	
    	King enemyKing5 = new King("B", 1, 1);
    	King enemyKing6 = new King("B", 1, 5);
    	King enemyKing7 = new King("B", 5, 1);
    	King enemyKing8 = new King("B", 5, 5);
    	
    	when(mockBoard.getPiece(2, 2)).thenReturn(enemyKing1);
    	when(mockBoard.getPiece(2, 4)).thenReturn(enemyKing2);
    	when(mockBoard.getPiece(4, 2)).thenReturn(enemyKing3);
    	when(mockBoard.getPiece(4, 4)).thenReturn(enemyKing4);
    	
    	when(mockBoard.getPiece(1, 1)).thenReturn(enemyKing5);
    	when(mockBoard.getPiece(1, 5)).thenReturn(enemyKing6);
    	when(mockBoard.getPiece(5, 1)).thenReturn(enemyKing7);
    	when(mockBoard.getPiece(5, 5)).thenReturn(enemyKing8);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//surrounded by friendly pieces
    	myKing = new King("R", 3, 3);
    	
    	King friendlyKing1 = new King("R", 2, 2);
    	King friendlyKing2 = new King("R", 2, 4);
    	King friendlyKing3 = new King("R", 4, 2);
    	King friendlyKing4 = new King("R", 4, 4);
    	
    	when(mockBoard.getPiece(2, 2)).thenReturn(friendlyKing1);
    	when(mockBoard.getPiece(2, 4)).thenReturn(friendlyKing2);
    	when(mockBoard.getPiece(4, 2)).thenReturn(friendlyKing3);
    	when(mockBoard.getPiece(4, 4)).thenReturn(friendlyKing4);
    	
    	when(mockBoard.getPiece(1, 1)).thenReturn(null);
    	when(mockBoard.getPiece(1, 5)).thenReturn(null);
    	when(mockBoard.getPiece(5, 1)).thenReturn(null);
    	when(mockBoard.getPiece(5, 5)).thenReturn(null);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//surrounded by nothing
    	myKing = new King("R", 3, 3);
    	
    	when(mockBoard.getPiece(2, 2)).thenReturn(null);
    	when(mockBoard.getPiece(2, 4)).thenReturn(null);
    	when(mockBoard.getPiece(4, 2)).thenReturn(null);
    	when(mockBoard.getPiece(4, 4)).thenReturn(null);
    	
    	when(mockBoard.getPiece(1, 1)).thenReturn(null);
    	when(mockBoard.getPiece(1, 5)).thenReturn(null);
    	when(mockBoard.getPiece(5, 1)).thenReturn(null);
    	when(mockBoard.getPiece(5, 5)).thenReturn(null);
    	    	
    	output = myKing.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {2,2,1,3};
    	expectedOutput.add(tmp);
    	tmp = new int[] {4,2,1,4};
    	expectedOutput.add(tmp);
    	tmp = new int[] {2,4,1,5};
    	expectedOutput.add(tmp);
    	tmp = new int[] {4,4,1,6};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    }
}
