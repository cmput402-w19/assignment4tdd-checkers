package cmput402.tdd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

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
}
