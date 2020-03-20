import java.util.ArrayList;
import java.util.Collections;

public class Merge_two_sorted_arrays {
	static void MergeArrays(int A[], int m, int B[], int n) {
		int i = m-1;
		int j=n-1;
		//int k=m+n-1; //shared space o(m+n)
		ArrayList<Integer>it=new ArrayList<Integer>();
		while(i>-0 && j>=0) {
			if(A[i]>B[j]) {
				//A[k--]=A[i--];
				it.add(A[i--]);
			}
			else if(A[i]<B[j]) {
				//A[k--]=B[j--];
				it.add(B[j--]);
			}
			//i.e. A[k--]= A[i]>B[j] ? A[i--] : B[j--];
		}
		while(j>=0) {
			//A[k--]=B[j--];
			it.add(B[j--]);
		}
		//now print arraylist in reverse
		Collections.reverse(it);
		System.out.println(it);
		
	}
	public static void main(String[] args) {
		int A[] = { 1, 3, 5, 7 };
		int B[] = { 2, 4, 6, 8 };
		int m=A.length;
		int n=B.length;
		MergeArrays(A,m,B,n);
	}
}
