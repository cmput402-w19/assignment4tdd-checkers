package cmput402.tdd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    
    public void testGetName() throws Exception {
    	Pawn testPawn = new Pawn("B", 0, 0);
    	String name = testPawn.getName();
    	assertEquals(name, "BP");
    }
    
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
    	
    	// Test moving distance of 2 as Red
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
    	assertEquals(coords4[0], 1); // row - position
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
    
}
