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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char curr = exp.charAt(i);
            if(curr>='a' && curr <='z' || curr>='A' && curr<='Z' || curr>='1' && curr<='9'){
                st.push(curr+"");
            }
            else{
                String val1= st.pop();
                String val2= st.pop();
                st.push("("+val2+curr+val1+")");
            }
        }
        return st.pop();
    }
}
