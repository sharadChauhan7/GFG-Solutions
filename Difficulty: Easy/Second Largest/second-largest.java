//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        if(arr.length<2)return -1;
        
        Set<Integer> s = new HashSet<>();
        for(int i:arr){
            s.add(i);
        }
        // Code Here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:s){
            pq.add(i);
            if(pq.size()>2){
                pq.remove();
            }
        }
        if(pq.size()<2)return -1;
        return pq.peek();
    }
}