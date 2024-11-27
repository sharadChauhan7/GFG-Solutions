//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int dp[][] = new int [nums.length][target+1];
        
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        // Arrays.sort(nums);
        
        return perfectSumUtil(nums,0,target,dp);
    }
    
    public int perfectSumUtil(int[] nums, int idx,int target, int[][] dp){
            
            if(target==0 && idx==nums.length-1){
                if(nums[idx] == 0) return 2;
                return 1;
            }
            if(idx==nums.length-1){
                    if(nums[idx] == target)return 1;
                    return 0;
            }
            if(dp[idx][target]!=-1){
                
                return dp[idx][target];
                
            }
            
            // Kaam 
            
            int notTake =  perfectSumUtil(nums,idx+1,target,dp);
            
            int take =0;
            if(nums[idx]<=target){
                take = perfectSumUtil(nums,idx+1,target-nums[idx],dp);
            }
            
            return dp[idx][target]=take+notTake;
            
    }
        
}