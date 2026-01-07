import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc).append("\n");

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N]; // 입력값 초기화
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(arr[N-1-j][i]);
                }
                sb.append(" ");

                for(int j = 0; j < N; j++) {
                    sb.append(arr[N-1-i][N-1-j]);
                }
                sb.append(" ");

                for(int j = 0; j < N; j++) {
                    sb.append(arr[j][N-1-i]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

}