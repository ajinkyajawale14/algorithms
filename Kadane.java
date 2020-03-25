package Algo;

public class Kadane {
	public static void main(String[] args) {
		int A[]= {-2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("largest sum subarray is "+kadanefun(A));
	}

	private static int kadanefun(int[] a) {
		// TODO Auto-generated method stub
		int maxsofar=0;
		int maxendinghere=0; //current location where maxsumsubaarray is ending
		for(int i:a) {
			 //update maximum sum of sub-array "ending" at index i (by adding
			// current element to maximum sum ending at previous index i-1)
			maxendinghere=maxendinghere+i;
			
			//if sum is -ve set it to 0
			maxendinghere=Integer.max(maxendinghere,0);
			
			//update result if current sub-array sum is found to be greater
			maxsofar=Integer.max(maxsofar,maxendinghere);
		}
		return maxsofar;
	}
	
}

// time complexity o(N)