package algorith.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BreadthFirstSearch {

	public static void main(String[] args) {

		Map<Integer, int[]> matrix = new HashMap<Integer, int[]>();
		matrix.put(1, new int[] { 2, 3, 6 });
		matrix.put(2, new int[] { 4, 5 });
		matrix.put(3, new int[] { 7 });
		matrix.put(6, new int[] { 8 });

		breadthSearch(matrix, 1);

	}

	private static void breadthSearch(final Map<Integer, int[]> matrix, int start) {
		if (start < matrix.size()) {
			for (Entry<Integer, int[]> val : matrix.entrySet()) {
				for (int val2 : val.getValue()) {
					System.out.println(val2);
				}
			}
		}
	}

}
