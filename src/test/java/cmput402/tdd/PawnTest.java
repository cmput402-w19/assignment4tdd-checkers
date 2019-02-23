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
}
