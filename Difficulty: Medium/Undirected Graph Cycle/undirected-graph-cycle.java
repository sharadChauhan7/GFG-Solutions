//{ Driver Code Starts
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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int len = adj.size();
        boolean isV[] = new boolean [len];
        Queue<int[]> que = new LinkedList<>();
        
        for(int i=0;i<len;i++){
            if(!isV[i]){
                que.add(new int []{i,-1});
                if(cyc(adj,que,isV)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean cyc(ArrayList<ArrayList<Integer>> adj,Queue<int[]> que,boolean [] isV){
        while(!que.isEmpty()){
            int[] curr = que.remove();
            isV[curr[0]] = true;
            
            for(int i=0;i<adj.get(curr[0]).size();i++){
                int neigh = adj.get(curr[0]).get(i);
                if(isV[neigh] && neigh!=curr[1]){
                    return true;
                }
                if(!isV[neigh]){
                    que.add(new int[]{neigh,curr[0]});
                }
            }
        }
        return false;
    }
}