import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] aj = new int[N];
            int[] bj = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                aj[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                bj[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for(int j = 0; j < Math.abs(N - M) + 1; j++) {
                int sum = 0;
                for(int k = 0; k < Math.min(N, M); k++) {
                    if(N >= M) {
                        sum += aj[k + j] * bj[k];
                    } else {
                        sum += aj[k] * bj[k + j];
                    }
                }
                answer = Math.max(answer, sum);
            }

            sb.append("#" + i + " " + answer).append("\n");
        }
        System.out.println(sb);
    }

}