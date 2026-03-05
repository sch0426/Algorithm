import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int maxTree = 0;
            for(int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxTree = Math.max(maxTree, trees[i]);
            }

            int ones = 0;
            int twos = 0;
            for(int i = 0; i < N; i++) {
                int need = maxTree - trees[i];
                ones += need % 2;
                twos += need / 2;
            }

            while(twos > ones + 1) {
                twos--;
                ones += 2;
            }

            if(ones > twos) {
                sb.append("#" + tc + " ").append(ones * 2 - 1).append("\n");
            } else {
                sb.append("#" + tc + " ").append(twos * 2).append("\n");
            }

        }
        System.out.println(sb);
    }
}
