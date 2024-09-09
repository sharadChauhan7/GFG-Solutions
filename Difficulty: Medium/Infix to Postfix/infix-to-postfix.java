//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int priority(char curr){
        if(curr =='^')return 3;
        else if(curr== '*' || curr =='/') return 2;
        else if(curr =='+' || curr =='-') return 1;
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st = new Stack<>();
        String ans ="";
        for(int i=0;i<exp.length();i++){
            char curr = exp.charAt(i);
            if(curr>='a' && curr <='z' || curr>='A' && curr<='Z' || curr>='1' && curr<='9'){
                ans+=curr;
            }
            else if(curr =='('){
                st.push(curr);
            }
            else if(curr==')'){
                while(!st.isEmpty()&& st.peek()!='('){
                    ans+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && priority(curr)<=priority(st.peek())){
                    ans+=st.pop();
                }
                st.push(curr);
            }
        }
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}