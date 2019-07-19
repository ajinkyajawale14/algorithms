//code
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int m = in.nextInt();
       int n = in.nextInt();
       in.nextLine();
       String magzine[] = in.nextLine().split(" ");
       String note[] = in.nextLine().split(" ");

        HashMap<String,Integer>hm = new HashMap<String,Integer>();
        

        for(int i=0;i<m;i++)
        {
            if(hm.containsKey(magzine[i])){
               hm.put(magzine[i],hm.get(magzine[i])+1);
            }
            else hm.put(magzine[i],1);
        }
        boolean check = false;
        for(int i=0;i<n;i++)
        {
            if(!hm.containsKey(note[i])) check=true;
            else {
                if(hm.get(note[i])>1)
                //hm.put(note[i],hm.get(note[i]-1));
                   hm.put(note[i],hm.get(note[i])-1);
                else hm.remove(note[i]);
            }
        }
        
        if(!check)
            System.out.println("Yes");
        else
            System.out.println("No");
   }


   }
