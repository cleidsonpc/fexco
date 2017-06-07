package algorith.exercises;

import java.util.ArrayList;
import java.util.List;

public class TowersOfHanoi {
	
	/**
	 * Method that print the moves between two tower. 
	 */
	private static void mover(List<Integer> origin, List<Integer> destiny) {
		int valOrigem = origin.get(origin.size()-1);
		destiny.add(valOrigem);
		origin.remove(origin.size()-1);
	}

	/**
	 *  Method of recursion.
	 */
	static void hanoi(int n, List<Integer> origin, List<Integer> destiny, List<Integer> aux) {

		if (n > 0) {
			hanoi(n - 1, origin, aux, destiny);
			mover(origin, destiny);
			hanoi(n - 1, aux, destiny, origin);
		}

	}

	/**
	 *  Executing Tower of Hanoi.
	 */
	public static void main(String[] args) {

		List<Integer> tower1 = new ArrayList<Integer>();
		tower1.add(3);
		tower1.add(2);
		tower1.add(1);
		List<Integer> tower2 = new ArrayList<Integer>();
		List<Integer> tower3 = new ArrayList<Integer>();
		
		int n; // number of disks.

		n = tower1.size();
		
		System.out.println("Start: " + tower1 + " - " + tower2 + " - " + tower3);
		
		// Execute Hanoi!
		TowersOfHanoi.hanoi(n, tower1, tower2, tower3);
		
		System.out.println("End: " + tower1 + " - " + tower2 + " - " + tower3);
		
	}
	
}