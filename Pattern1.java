package Algo;
import java.io.*;
import java.util.*;
public class Pattern1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		patternprint(n);
	}
	
	public static void patternprint(int n) {
		int j=0;
		for(int i=0;i<n;i++) {
			j=n;
			while(j-->i) {
				System.out.print(" ");
			}
			while(j-->=0) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}

/*output
6
   
     #
    ##
   ###
  ####
 #####

*/