import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            String isMatch = "yes";

            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if(c == '(' || c == '[') stack.push(c);
                else if(c == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {isMatch = "no"; break;}
                } else if(c == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {isMatch = "no"; break;}
                }
            }

            if(isMatch.equals("yes") && !stack.isEmpty()) isMatch = "no";

            sb.append(isMatch).append("\n");
        }
        System.out.println(sb);
    }
}
