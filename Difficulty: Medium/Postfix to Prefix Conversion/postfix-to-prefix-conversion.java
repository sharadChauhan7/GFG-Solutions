//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i=0;i<post_exp.length();i++){
            char curr = post_exp.charAt(i);
            if(curr>='a' && curr<='z' || curr>='A' && curr<='Z' || curr>='0' && curr<='9'){
                st.push(curr+"");
            }
            else{
                String val1=st.pop();
                String val2 = st.pop();
                String join = curr+val2+val1;
                st.push(join);
            }
        }
        return st.pop();
    }
}
