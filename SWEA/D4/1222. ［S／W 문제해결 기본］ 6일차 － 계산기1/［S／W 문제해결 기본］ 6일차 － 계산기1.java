import java.util.*;
import java.io.*;

class Solution
{
    private static String change(String str) {
    	Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
        	if('0' <= c && c <= '9') sb.append(c);
            else if(c == '+') {
            	if(stack.isEmpty()) stack.push(c);
                else {
                    sb.append(stack.pop());
                    stack.push(c);
                }
            }
        }
        if(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
    
    private static int calculate(String str) {
        Deque<Integer> stack = new ArrayDeque<>();
    	int result = 0;
        
        for(int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
            if('0' <= c && c <= '9') stack.push(c - '0');
            else if(c == '+') {
            	int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            }
        }
        result = stack.pop();
        return result;
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int answer = calculate(change(str));
            System.out.println("#" + test_case + " " + answer);
		}
	}
}