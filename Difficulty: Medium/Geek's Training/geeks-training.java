//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
        int dp[][] = new int [N][4];
        for(int nums[]:dp){
            Arrays.fill(nums,-1);
        }
        
        return helper(arr,N-1,3,dp);
    }
    public int helper(int arr[][],int n,int idx,int dp[][]){
        if(n<0){
            return 0;
        }
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3 = Integer.MIN_VALUE;
        if( dp[n][idx] !=-1){
            return dp[n][idx];
        }
        
        if(idx !=0){
            n1 = helper(arr,n-1,0,dp)+arr[n][0];
        }
        if(idx !=1){
            n2 = helper(arr,n-1,1,dp)+arr[n][1];
        }
        if(idx !=2){
            n3 = helper(arr,n-1,2,dp)+arr[n][2];
        }
        return dp[n][idx]=Math.max(n1,Math.max(n2,n3));
    }
}