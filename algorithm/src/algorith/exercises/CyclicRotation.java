package algorith.exercises;

/**
 * A zero-indexed array A consisting of N integers is given. Rotation of the
 * array means that each element is shifted right by one index, and the last
 * element of the array is also moved to the first place.
 *
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7].
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right by K indexes.
 *
 * Write a function:
 *
 * struct Results solution(int A[], int N, int K); that, given a zero-indexed
 * array A consisting of N integers and an integer K, returns the array A
 * rotated K times.
 *
 * For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should
 * return [9, 7, 6, 3, 8].
 *
 * Assume that:
 *
 * N and K are integers within the range [0..100]; each element of array A is an
 * integer within the range [-1,000..1,000]. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment.
 */
public class CyclicRotation {

	public static void main(String[] args) {

		CyclicRotation cr = new CyclicRotation();

		System.out.print("\nTest 1: ");
		int[] r1 = cr.solution(new int[] { 3, 8, 9, 7, 6 }, 3);
		for (int v : r1) {
			System.out.print(v);
		}

		System.out.print("\nTest 2: ");
		int[] r2 = cr.solution(new int[] { 6, 3, 8, 9, 7 }, 9);
		for (int v : r2) {
			System.out.print(v);
		}

		System.out.print("\nTest 3: ");
		int[] r3 = cr.solution(new int[] { -1000, 5 }, -2);
		for (int v : r3) {
			System.out.print(v);
		}
	}

	public int[] solution(int[] A, int K) {
        
		int[] newArray = A;
        
        if(K <= 0) {
            newArray = A;
            
        } else if(K > A.length) {
            newArray = A;
            
        } else {
            
            int start = 0;
            for(int i=0 ; i<K-1; i++) {
                
                start = newArray[0];
                for(int x=0; x<newArray.length; x++) {
                    if(x >= newArray.length-1) {
                        newArray[x] = start;
                    } else {
                        newArray[x] = newArray[x+1];
                    }
                }
            }
        }
        
        return newArray;
    }
	
}
