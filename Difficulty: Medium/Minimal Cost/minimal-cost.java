//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(arr,arr.length-1,dp,k);
    }
     public int helper(int [] arr, int idx,int dp[],int k){
        
        if(idx<=0){
            return 0;
        }
        
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int maxi = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            
            if(idx-i>=0){
                int n =helper(arr,idx-i,dp,k)+Math.abs(arr[idx]-arr[idx-i]);
                maxi = Math.min(maxi,n);
            }
        }
        return dp[idx]=maxi;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends