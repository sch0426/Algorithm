import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 나무의 최고 높이
            int max = Integer.MIN_VALUE;
            // 나무 입력값 초기화
            for(int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(trees[i], max);
            }

            // 1만큼 줘야하는 횟수와 2만큼 줘야하는 횟수
            int ones = 0, twos = 0;
            for(int i = 0; i < N; i++) {
                ones += (max - trees[i]) % 2;
                twos += (max - trees[i]) / 2;
            }
            // 1 2 0 2 0 2 -> 1 2 1 2 1 : 치환해서 이득이 되는 예시
            // 짝수날이 홀수날보다 2개이상 많다면
            // 짝수 1일을 홀수 2일로 치환
            while(twos - ones >= 2) {
                twos -= 1;
                ones += 2;
            }

            int ans = 0;
            if(twos >= ones) {
                ans = twos * 2;
            } else {
                ans = ones * 2 - 1;
            }
            
            sb.append("#" + tc + " ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
