import java.util.*;
import java.lang.Math;
public class MergeSort{
	
	public static void main(String[] args) {
		int [] A= {-5,23,99,-24,-34,56,0,2};
		int len=A.length;
		mergesort(A,0,len-1);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}

	private static void mergesort(int[] a,int start, int end) {
		// TODO Auto-generated method stub
		if(end-start+1<=1) return;
		int mid=start+(end-start)/2;
		mergesort(a,start,mid);
		mergesort(a,mid+1,end);
		merge(a,start,mid,end);
	}

	private static void merge(int[] a, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int left=start;
		int right=mid+1;
		int buffer[]=new int [end-start+1];
		int t=0;
		
		while(left<=mid && right<=end) {
			if(a[left]<a[right]) {
				buffer[t++]=a[left++];
			}
			else {
				buffer[t++]=a[right++];
			}
		}
		while(left<=mid) buffer[t++]=a[left++];
		while(right<=end) buffer[t++]=a[right++]; //no need to copy 2nd array as left elements would be sorted in the first place itself
		
		//copy to original a
		for (int i=start;i<=end;i++) {
			a[i]=buffer[i-start];
		}
		
		
		
	}
}