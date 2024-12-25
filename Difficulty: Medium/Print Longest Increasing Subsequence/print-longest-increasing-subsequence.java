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
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        // Code here
        int dp[] = new int[nums.length];
        int hash[] = new int [nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            hash[i] = i;
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i] && dp[i]<1+dp[j]){
                    dp[i] = 1+dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i]>max){
                    max = dp[i];
                    idx = i;
            }
        }
        ArrayList<Integer>arr = new ArrayList<>();
        while(idx!=hash[idx]){
            arr.add(0,nums[idx]);
            idx = hash[idx];
        }
        arr.add(0,nums[idx]);
        return arr;
    }
}
