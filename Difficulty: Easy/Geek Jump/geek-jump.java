//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code hereint []
        int dp[] = new int[N];
        Arrays.fill(dp,-1);
        return helper(arr,arr.length-1,dp);
    }
    public int helper(int [] arr, int idx,int dp[]){
        
        if(idx<=0){
            return 0;
        }
        
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int n1=helper(arr,idx-1,dp);
        
        if(idx-2>=0){
             int n2=helper(arr,idx-2,dp);
             return dp[idx]=Math.min((n1+Math.abs(arr[idx]-arr[idx-1])),(n2+Math.abs(arr[idx]-arr[idx-2])));
        }
        return dp[idx]=n1+Math.abs(arr[idx]-arr[idx-1]);
    }
}