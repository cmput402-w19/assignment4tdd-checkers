package cmput402.tdd;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;

public class Utility {

	public HashMap<String, Float>  countAverageScore(Search search){
		HashMap<String, ArrayList<Integer>> result = search.returnAll();
		
		HashMap<String, Float> map = new HashMap<String, Float>();
		
		for(String player: result.keySet()) {
			Float avg = ((float) (result.get(player).get(1)) / ((float) result.get(player).get(0)));
			map.put(player, avg);
		}
		
		return map;
	}
	
public HashMap<String, Integer>  findTopScorer(Search search){
		HashMap<String, ArrayList<Integer>> result = search.returnAll();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		Integer maxScore = 0;
		String maxPlayer = "";
		for(String player: result.keySet()) {
			if(result.get(player).get(1) >= maxScore){
				maxScore = result.get(player).get(1);
				maxPlayer = player;
			}
		}
		map.put(maxPlayer, maxScore);
		
		return map;
	}
	
}
