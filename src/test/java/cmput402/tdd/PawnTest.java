package cmput402.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.mockito.Matchers.anyInt;

/**
 * Unit test for Pawn
 */
public class PawnTest extends TestCase {
	
	public PawnTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PawnTest.class );
    }
    
    /**
     * Test for constructor, it should throw an exception if the arguments are not valid
     */
    public void testConstructor() {
    	try {
    		new Pawn("R", 0, 0);
    		assert(true);
    	} catch(Exception e) {
    		assert(false);
    	}
    	
    	try {
    		new Pawn("B", 0, 0);
    		assert(true);
    	} catch(Exception e) {
    		assert(false);
    	}
    	
    	try {
    		new Pawn("", 0, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    	
    	try {
    		new Pawn("X", 0, 0);
    		assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}
    }
    
    /**
     * Test for getName
     */
    public void testGetName() throws Exception {
    	Pawn testPawn = new Pawn("B", 0, 0);
    	String name = testPawn.getName();
    	assertEquals(name, "BP");
    }
    
    /**
     * Test for getTargetCoords which attempts to play a move for a pawn
     */
    public void testGetTargetCoord() throws Exception {
    	// Test moving distance of 1 right
    	Pawn testPawn = new Pawn("B", 0, 0);
    	int[] coords = new int[4];
    	coords = testPawn.getTargetCoords(false, 1);
    	assertEquals(coords[0], 1); // row - position
    	assertEquals(coords[1], 1); // column - position
    	assertEquals(coords[2], 1); // distance
    	assertEquals(coords[3], 2); // left = 1 right = 2
    	
    	// Test moving distance of 2 right 
    	Pawn testPawn2 = new Pawn("B", 3, 3);
    	int[] coords2 = new int[4];
    	coords2 = testPawn2.getTargetCoords(false, 2);
    	assertEquals(coords2[0], 5); // row - position
    	assertEquals(coords2[1], 5); // column - position
    	assertEquals(coords2[2], 2); // distance
    	assertEquals(coords2[3], 2); // left = 1 right = 2
    	
    	// Test moving distance of 2 as Red right
    	Pawn testPawn3 = new Pawn("R", 3, 3);
    	int[] coords3 = new int[4];
    	coords3 = testPawn3.getTargetCoords(false, 2);
    	assertEquals(coords3[0], 1); // row - position
    	assertEquals(coords3[1], 5); // column - position
    	assertEquals(coords3[2], 2); // distance
    	assertEquals(coords3[3], 2); // left = 1 right = 2
    	
    	// Test moving left
    	Pawn testPawn4 = new Pawn("B", 3, 3);
    	int[] coords4 = new int[4];
    	coords4 = testPawn4.getTargetCoords(true, 2);
    	assertEquals(coords4[0], 5); // row - position
    	assertEquals(coords4[1], 1); // column - position
    	assertEquals(coords4[2], 2); // distance
    	assertEquals(coords4[3], 1); // left = 1 right = 2
    	
    	// Try moving distance of 3, this should throw an exception
    	try {
    		Pawn testPawn5 = new Pawn("B", 3, 3);
    		testPawn5.getTargetCoords(true, 3);
        	assert(false);
    	} catch(Exception e) {
    		assert(true);
    	}    	
    }
    
    /**
     * Custom assert function to compare two ArrayList of integers
     */
    private void assertLegalMoves(ArrayList<int[]> expectedOutput, ArrayList<int[]> output) {
    	assert(output.size() == expectedOutput.size());
    	for(int i = 0; i<expectedOutput.size(); i++) {
			assertEquals(Arrays.toString(expectedOutput.get(i)), Arrays.toString(output.get(i)));
		}
    }
    
    /**
     * Test for legalMoves which shows which coordinates a checkers pawn can play legally
     */
    public void testLegalMoves() throws Exception {
    	Board mockBoard = mock(Board.class);
    	
    	//top left corner black pawn
    	Pawn myPawn = new Pawn("B", 0, 0);
    	when(mockBoard.inBounds(-1, -1)).thenReturn(false);
    	when(mockBoard.inBounds(-1, 1)).thenReturn(false);
    	when(mockBoard.inBounds(-2, -2)).thenReturn(false);
    	when(mockBoard.inBounds(-2, 2)).thenReturn(false);
    	when(mockBoard.inBounds(1, -1)).thenReturn(false);
    	when(mockBoard.inBounds(2, -2)).thenReturn(false);
    	
    	when(mockBoard.inBounds(1, 1)).thenReturn(true);
    	when(mockBoard.inBounds(2, 2)).thenReturn(true);
    	
    	when(mockBoard.getPiece(anyInt(), anyInt())).thenReturn(null);
    	
    	ArrayList<int[]> output = myPawn.legalMoves(mockBoard);
    	ArrayList<int[]> expectedOutput = new ArrayList<int[]>();
    	int[] tmp = {1,1,1,2};
    	expectedOutput.add(tmp);
    	
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//top right corner black pawn
    	myPawn = new Pawn("B", 0, 7);
    	when(mockBoard.inBounds(-1, 8)).thenReturn(false);
    	when(mockBoard.inBounds(-2, 9)).thenReturn(false);
    	when(mockBoard.inBounds(1, 8)).thenReturn(false);
    	when(mockBoard.inBounds(2, 9)).thenReturn(false);
    	when(mockBoard.inBounds(-1, 6)).thenReturn(false);
    	when(mockBoard.inBounds(-2, 5)).thenReturn(false);
    	
    	when(mockBoard.inBounds(1, 6)).thenReturn(true);
    	when(mockBoard.inBounds(2, 5)).thenReturn(true);
    	    	
    	output = myPawn.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {1,6,1,1};
    	expectedOutput.add(tmp);
    	
    	
    	
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//bottom left corner red pawn
    	myPawn = new Pawn("R", 7, 0);
    	when(mockBoard.inBounds(8, -1)).thenReturn(false);
    	when(mockBoard.inBounds(9, -2)).thenReturn(false);
    	when(mockBoard.inBounds(8, 1)).thenReturn(false);
    	when(mockBoard.inBounds(9, 2)).thenReturn(false);
    	when(mockBoard.inBounds(6, -1)).thenReturn(false);
    	when(mockBoard.inBounds(5, -2)).thenReturn(false);
    	
    	when(mockBoard.inBounds(6, 1)).thenReturn(true);
    	when(mockBoard.inBounds(5, 2)).thenReturn(true);
    	    	
    	output = myPawn.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {6,1,1,2};
    	expectedOutput.add(tmp);
    	
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//bottom right corner red pawn
    	myPawn = new Pawn("R", 7, 7);
    	when(mockBoard.inBounds(8, 8)).thenReturn(false);
    	when(mockBoard.inBounds(9, 9)).thenReturn(false);
    	when(mockBoard.inBounds(8, 6)).thenReturn(false);
    	when(mockBoard.inBounds(9, 5)).thenReturn(false);
    	when(mockBoard.inBounds(6, 8)).thenReturn(false);
    	when(mockBoard.inBounds(5, 9)).thenReturn(false);
    	
    	when(mockBoard.inBounds(6, 6)).thenReturn(true);
    	when(mockBoard.inBounds(5, 5)).thenReturn(true);
    	    	
    	output = myPawn.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {6, 6, 1, 1};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//red can capture black
    	myPawn = new Pawn("R", 3, 3);
    	when(mockBoard.inBounds(anyInt(), anyInt())).thenReturn(true);
    	
    	Pawn enemyPawn1 = new Pawn("B", 2, 2);
    	Pawn enemyPawn2 = new Pawn("B", 2, 4);
    	
    	when(mockBoard.getPiece(2, 2)).thenReturn(enemyPawn1);
    	when(mockBoard.getPiece(2, 4)).thenReturn(enemyPawn2);
    	
    	when(mockBoard.getPiece(1, 1)).thenReturn(null);
    	when(mockBoard.getPiece(1, 5)).thenReturn(null);
    	    	
    	output = myPawn.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {1,1,2,1};
    	expectedOutput.add(tmp);
    	tmp = new int[] {1,5,2,2};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    	//black can capture red
    	myPawn = new Pawn("B", 3, 3);
    	when(mockBoard.inBounds(anyInt(), anyInt())).thenReturn(true);
    	    	
    	Pawn enemyPawn3 = new Pawn("R", 4, 2);
    	Pawn enemyPawn4 = new Pawn("R", 4, 4);
    	
    	when(mockBoard.getPiece(4, 2)).thenReturn(enemyPawn3);
    	when(mockBoard.getPiece(4, 4)).thenReturn(enemyPawn4);
    	
    	when(mockBoard.getPiece(5, 1)).thenReturn(null);
    	when(mockBoard.getPiece(5, 5)).thenReturn(null);
    	
    	output = myPawn.legalMoves(mockBoard);
    	expectedOutput = new ArrayList<int[]>();
    	tmp = new int[] {5,1,2,1};
    	expectedOutput.add(tmp);
    	tmp = new int[] {5,5,2,2};
    	expectedOutput.add(tmp);
    	this.assertLegalMoves(expectedOutput, output);
    	
    }
    
}
