//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int dp[][] = new int [arr.length+1][target+1];
        for(int num[]:dp){
            Arrays.fill(num,-1);
        }
        return isSubsetSumUtil(arr,target,0,dp);
    }
    
    static boolean isSubsetSumUtil(int arr[], int target,int idx,int dp[][]){
        
        if(target==0){
            return true;
        }
        
        if(target<0){
            return false;
        }
        
        if(idx>=arr.length){
            return false;
        }
        if(dp[idx][target]!=-1){
            return dp[idx][target]==1?true:false;
        }
        
        boolean ans = isSubsetSumUtil(arr,target,idx+1,dp) || isSubsetSumUtil(arr, target-arr[idx], idx+1,dp);
        dp[idx][target]=ans?1:0;
        return ans;
        
        
    }
}