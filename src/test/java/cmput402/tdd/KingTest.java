package cmput402.tdd;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

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
}
