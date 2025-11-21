import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> queue = new ArrayDeque<>();
            int N = 8;
            for(int i = 0; i < N; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int cnt = 1;
            while(queue.peekLast() != 0) {
                if(cnt == 6) cnt = 1;
                int temp = queue.poll();
                if(temp - cnt <= 0) queue.offer(0);
                else queue.offer(temp - cnt);
                cnt++;
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < N; i++) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}