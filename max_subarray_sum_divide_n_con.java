package Algo;

import java.util.*;
import java.lang.*;

public class max_subarray_sum_divide_n_con {
	
	// only for positive elements 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 4, 5, 7 };
		int n = A.length;
		int result=div_con(A, 0, n - 1);
		System.out.println("Maximum sum subarray is " + result);
	}

	private static int div_con(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end)  //base case
			return a[start];

		// mid
		int mid = (start + end) / 2;

		/*
		 * Return maximum of following three possible cases: 
		 * a) Maximum subarray sum in left half 
		 * b) Maximum subarray sum in right half 
		 * c) Maximum subarray sum such
		 * that the subarray crosses the midpoint
		 */

		return Math.max(Math.max(div_con(a, start, mid), div_con(a, mid + 1, end)), cross_mid(a, start, mid, end));

	}

	static int cross_mid(int[] a, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = mid; i >= start; i--) {
			sum = sum + a[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		int right_sum = Integer.MAX_VALUE;
		for (int i = mid + 1; i <= end; i++) {
			sum = sum + a[i];
			if (sum > right_sum) {
				right_sum = sum;
			}
		}

		return left_sum + right_sum;
	}
}
