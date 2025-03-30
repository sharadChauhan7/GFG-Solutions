//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u); // Since the graph is undirected
            }

            int src = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.shortestPath(adj, src);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        Queue<int[]> q = new LinkedList<>();
        int len = adj.size();
        int ans [] = new int [len];
        
        Arrays.fill(ans,Integer.MAX_VALUE);
        
        q.add(new int[]{src,0});
        while(!q.isEmpty()){
            int curr[]= q.remove();
            ans[curr[0]] = Math.min(curr[1],ans[curr[0]]);
            
            for(int i=0;i<adj.get(curr[0]).size();i++){
                int neigh = adj.get(curr[0]).get(i);
                if(curr[1]+1<ans[neigh]){
                    q.add(new int[]{neigh,curr[1]+1});
                }
            }
        }
        for(int i=0;i<len;i++){
            if(ans[i]==Integer.MAX_VALUE){
                ans[i]=-1;
            }
        }
        return ans;
    }
}
