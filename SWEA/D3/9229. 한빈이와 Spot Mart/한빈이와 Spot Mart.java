import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N : 과자 개수
            int M = Integer.parseInt(st.nextToken()); // M : 최대 무게 합

            st = new StringTokenizer(br.readLine());
            int[] snacks = new int[N];
            for(int i = 0; i < N; i++) { // 과자무게 입력값 초기화
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(snacks);

            int s = 0, e = N - 1;
            int sum = -1;
            while(s < e) {
                if(snacks[s] + snacks[e] > M) {
                    e--;
                } else if(snacks[s] + snacks[e] < M) {
                    sum = Math.max(sum, snacks[s] + snacks[e]);
                    s++;
                } else {
                    sum = M;
                    break;
                }
            }

            sb.append("#" + tc + " ").append(sum).append("\n");

        }
        System.out.println(sb);
    }

}