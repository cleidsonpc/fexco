package algorith.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utility.Graph;
import utility.Graph.Next;

public class AStar {

	private static Map<String, Integer> pathAndWight = new HashMap<String, Integer>();
	private static String allPaths = "";
	
	// 7, 17, 19, 26, 30 or null
	private static Integer target = 7;
	
	public static void main(String[] a) {
		Graph graph = Graph.getGrafo();
		process(graph, null, 0);
		
		Integer lowerWeight = null;
		String lowerPath = "";
		
		
		for(Entry<String, Integer> entry : pathAndWight.entrySet()) {
			if(lowerWeight == null || entry.getValue() < lowerWeight) {
				lowerWeight = entry.getValue();
				lowerPath = entry.getKey();
			}
		}
		
		System.out.println("Lower path is ["+ lowerPath + "] and spent " + lowerWeight + ".");
		System.out.println("\nAll the paths updated: " + allPaths);
	}

	private static void process(Graph graph, String path, Integer weight) {
		
		if(path == null) {
			path = String.valueOf(graph.getId());
		} else {
			path = path + ", " + graph.getId();
		}
		
		if((target == null && graph.getNext().isEmpty()) || (target != null && graph.getNext().isEmpty() && graph.getId().equals(target))) {
			pathAndWight.put(path, weight);
			allPaths = allPaths + "\n" + path + "=" + weight; 
		}
		
		for(Next next : graph.getNext()) {
			process(next.getNext(), path,  weight + next.getPeso());
		}
	}
}
