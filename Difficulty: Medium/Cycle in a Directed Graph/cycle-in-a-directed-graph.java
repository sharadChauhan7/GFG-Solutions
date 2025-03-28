//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int len = adj.size();
        boolean isV[] = new boolean [len];
        boolean isPV[] = new boolean [len];
        
        for(int i=0;i<len;i++){
            if(!isV[i]){
                if(dfs(adj,i,isV,isPV)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int curr,boolean isV[],boolean isPV[]){
        isV[curr]=true;
        isPV[curr]=true;
        
        for(int i=0;i<adj.get(curr).size();i++){
            int neigh = adj.get(curr).get(i);
            if(isV[neigh] && isPV[neigh]){
                return true;
            }
            else{
                if(dfs(adj,neigh,isV,isPV))return true;
            }
        }
        isPV[curr]=false;
        return false;
    }
}