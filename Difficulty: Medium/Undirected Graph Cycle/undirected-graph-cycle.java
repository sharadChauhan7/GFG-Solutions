//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
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
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    public boolean detectCycle(ArrayList<ArrayList<Integer>> graph,int V){
        boolean isVisited [] = new boolean[graph.size()];
        for(int i=0;i<isVisited.length;i++){
            if(!isVisited[i]){
                if(detectCycleUtil(graph,isVisited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
     public boolean detectCycleUtil(ArrayList<ArrayList<Integer>> graph,boolean [] isVisited,int si,int par){
            Queue<int []> q = new LinkedList<>();
            q.add(new int [] {si,par} );
            while(!q.isEmpty()){
                int []curr = q.remove();
                isVisited[curr[0]] = true;
                for(int i=0;i<graph.get(curr[0]).size();i++){
                    ArrayList<Integer> n=graph.get(curr[0]);
                    if(isVisited[n.get(i)] && n.get(i) != curr[1]){
                        return true;
                    }
                    else if(!isVisited[n.get(i)]){
                        
                            q.add(new int []{n.get(i),curr[0]});
                            
                    }
                }
            }
         return false;
     }
    
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // System.out.println(adj);
        return detectCycle(adj,V);
    }
}