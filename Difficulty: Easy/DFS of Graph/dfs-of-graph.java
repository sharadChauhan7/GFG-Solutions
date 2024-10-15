//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(adj);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> graph) {
        // Code here
        boolean isVisited [] = new boolean[graph.size()];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        helper(graph,isVisited,0,ans);
        return ans;
    }
    public void helper(ArrayList<ArrayList<Integer>> graph,boolean isVisited [],int starting,ArrayList<Integer> ans){
        if(!isVisited[starting]){
            isVisited[starting]=true;
            ans.add(starting);
            for(int i=0;i<graph.get(starting).size();i++){
                ArrayList<Integer> n = graph.get(starting);
                if(!isVisited[n.get(i)]){
                    helper(graph,isVisited,n.get(i),ans);
                }
            }
        }
        return;
    }
}