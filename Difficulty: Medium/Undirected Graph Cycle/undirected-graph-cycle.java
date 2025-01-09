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
    class Node{
        int num;
        int parent;
        
        Node(int num,int parent){
            this.num = num;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue <Node> q = new LinkedList<>();
        boolean isV [] = new boolean [adj.size()];
        int n = adj.size();
        
        for(int i=0;i<n;i++){
            if(!isV[i]){
                q.add(new Node(i,-1));
                if(isCycleUtil(q,isV,adj))return true;
            }
        }
        return false;
        
    }
    
    public boolean isCycleUtil(Queue <Node> q,boolean isV [], ArrayList<ArrayList<Integer>> adj){
        while(!q.isEmpty()){
            Node curr = q.remove();
            // System.out.println(curr.num+" "+curr.parent);
            isV[curr.num] = true;
            for(int i=0;i<adj.get(curr.num).size();i++){
                int neigh = adj.get(curr.num).get(i);
                // System.out.println(neigh);
                if(isV[neigh] && neigh != curr.parent){
                    return true;
                }
                else{
                    if(!isV[neigh]){
                        q.add(new Node(neigh,curr.num));
                    }
                }
            }
        }
        return false;
    }
}