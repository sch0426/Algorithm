import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int testLen = Integer.parseInt(br.readLine());
            String test = br.readLine();
            int answer = 1; // 유효한걸 디폴트로
            HashMap<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            map.put('>', '<');
            
            Deque<Character> deque = new ArrayDeque<>();
            for(int i = 0; i < testLen; i++) {
                char c = test.charAt(i);
            	if(map.containsValue(c)) {
                	deque.push(c);
                } else {
                	if(deque.isEmpty() || deque.peek() != map.get(c)) {
                    	answer = 0;
                        break;
                    }
                    deque.pop();
                }
            }
            if(!deque.isEmpty()) answer = 0;
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}