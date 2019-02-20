package cmput402.tdd;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	Utility util = new Utility();
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testCountAverageScore() {
    	Search mockSearch = mock(Search.class);
    	HashMap<String, ArrayList<Integer>> fakeMap = new HashMap<String, ArrayList<Integer>>();
    	ArrayList<Integer> messi = new ArrayList<Integer>();
    	messi.add(100);
    	messi.add(200);
    	
    	ArrayList<Integer> ronaldo = new ArrayList<Integer>();
    	ronaldo.add(80);
    	ronaldo.add(150);
    	
    	ArrayList<Integer> neymar = new ArrayList<Integer>();
    	neymar.add(50);
    	neymar.add(80);
    	
    	fakeMap.put("messi", messi);
    	fakeMap.put("ronaldo", ronaldo);
    	fakeMap.put("neymar", neymar);
    	
    	when(mockSearch.returnAll()).thenReturn(fakeMap);
    	
    	HashMap<String, Float> results = util.countAverageScore(mockSearch);
    	//System.out.println(results.get("ronaldo"));
    	assert((float)2==results.get("messi"));
    	assert((float)1.875==results.get("ronaldo"));
    	assert((float)1.6==results.get("neymar"));
    	
    }
    
    public void testFindTopScorer() {
    	Search mockSearch = mock(Search.class);
    	HashMap<String, ArrayList<Integer>> fakeMap = new HashMap<String, ArrayList<Integer>>();
    	ArrayList<Integer> messi = new ArrayList<Integer>();
    	messi.add(100);
    	messi.add(200);
    	
    	ArrayList<Integer> ronaldo = new ArrayList<Integer>();
    	ronaldo.add(80);
    	ronaldo.add(150);
    	
    	ArrayList<Integer> neymar = new ArrayList<Integer>();
    	neymar.add(50);
    	neymar.add(80);
    	
    	fakeMap.put("messi", messi);
    	fakeMap.put("ronaldo", ronaldo);
    	fakeMap.put("neymar", neymar);
    	
    	when(mockSearch.returnAll()).thenReturn(fakeMap);
    	
    	HashMap<String, Integer> results = util.findTopScorer(mockSearch);
    	assert(1==results.keySet().size());
    	assert("messi"==results.keySet().iterator().next());
    	assert(200==results.get("messi"));
    }
}
