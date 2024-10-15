//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void bfsUtil(ArrayList<ArrayList<Integer>> graph ,boolean [] visited,int starting){
        Queue<Integer> q = new LinkedList<Integer>();
        // boolean visited [] = new boolean[graph.length];
        q.add(starting);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                visited[curr]=true;
                // System.out.print(curr+" ");
                // for(int i=0;i<graph[curr].size();i++){
                //     q.add(graph[curr].get(i).dest);
                // }
                for(int i =0;i<graph.get(curr).size();i++){
                    
                    if(graph.get(curr).get(i) == 1){
                        q.add(i);
                    }
                }
            }
        }
        return;
    }
    public static int bfs(ArrayList<ArrayList<Integer>> graph,int starting){
        boolean isVisited [] = new boolean[graph.size()];
        int count=0;
        for(int i=0;i<graph.size();i++){
            if(!isVisited[i]){
                count++;
                bfsUtil(graph,isVisited, i);
            }
        }
        return count;
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        return bfs(adj,0);
    }
};