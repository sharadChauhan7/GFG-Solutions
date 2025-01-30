//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int exits[] = new int[n];
            for (int i = 0; i < n; i++) exits[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            System.out.println(sln.maxWeightCell(exits));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxWeightCell(int[] exits) {
        int n = exits.length;
        int ans [] = new int [n];
        
        for(int i=0;i<n;i++){
            if(exits[i]!=-1){
                ans[exits[i]] =ans[exits[i]]+i;
            }
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            // System.out.println(ans[i]+" ");
            if(ans[res]<=ans[i]){
                res = i;
            }
        }
        return res;
    }
}