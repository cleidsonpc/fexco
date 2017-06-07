package algorith.exercises;

/**
 * A zero-indexed array A consisting of N different integers is given. The array
 * contains integers in the range [1..(N + 1)], which means that exactly one
 * element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * int solution(int A[], int N); that, given a zero-indexed array A, returns the
 * value of the missing element.
 *
 * For example, given array A such that:
 *
 * A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5 the function should return 4, as it is
 * the missing element.
 *
 * Assume that:
 *
 * N is an integer within the range [0..100,000]; the elements of A are all
 * distinct; each element of array A is an integer within the range [1..(N +
 * 1)]. Complexity:
 *
 * expected worst-case time complexity is O(N); expected worst-case space
 * complexity is O(1), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 */
public class PermMissingElem {

	public static void main(String[] args) {
		// Case 1
		int[] elements = new int[]{2,3,1,5};
		int r = new PermMissingElem().solution(elements);
		System.out.println(r);
		
		// Case 2
		elements = new int[]{};
		r = new PermMissingElem().solution(elements);
		System.out.println(r);
		
		// Case 3
		elements = new int[]{1,2,3,4,5};
		r = new PermMissingElem().solution(elements);
		System.out.println(r);
	}
	
	public int solution(int[] A) {
		java.util.Arrays.sort(A);
		int r = 1; // start using 1 to the case of "A" is empty
		for (int x = 0; x < A.length; x++) {
			if (A[x] != x + 1) {
				r = x + 1;
				break;
			} else {
				r = A[x] + 1; // get the end to the case of don't have missing.
			}
		}
		return r;
	}
	
}
