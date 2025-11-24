import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> stack = new ArrayDeque<>();
        int T =  Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if(cmd.equals("pop")) {
                if(!stack.isEmpty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if(cmd.equals("top")) {
                if(!stack.isEmpty()) {
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if(cmd.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if(cmd.equals("empty")) {
                if(!stack.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append("1").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
