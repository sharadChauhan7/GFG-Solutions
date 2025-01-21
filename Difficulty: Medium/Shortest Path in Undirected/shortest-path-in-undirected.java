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
    class Info {
        int node;
        int dis;
        
        Info(int node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        
        Queue<Info> q = new LinkedList<>();
        int [] ans = new int [adj.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = Integer.MAX_VALUE;
        }
        q.add(new Info(src,0));
        while(!q.isEmpty()){
            Info curr = q.remove();
            
            ans[curr.node] = curr.dis;
            for(int i=0;i<adj.get(curr.node).size();i++){
                int neigh = adj.get(curr.node).get(i);
                if(curr.dis+1<ans[neigh]){
                    ans[neigh] = curr.dis+1;
                    q.add(new Info(neigh,curr.dis+1));
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE){
                ans[i]=-1;
            }
        }
        
        return ans;
    }
}
