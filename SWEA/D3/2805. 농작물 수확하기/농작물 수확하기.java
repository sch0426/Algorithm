import java.io.*;
import java.util.*;

public class Solution {
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            int answer = 0;

            for (int h = 0; h < N; h++) {
                String input = br.readLine();

                for (int w = 0; w < N; w++) {
                    map[h][w] = input.charAt(w) - '0';
                }
            }

            int startR = N / 2;
            int startC = N / 2;

            Deque<int[]> dq = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            dq.offer(new int[]{startR, startC});
            visited[startR][startC] = true;

            int step = 0;
            while (!dq.isEmpty()) {
                if (step > N / 2) break;

                int size = dq.size(); // 현재 큐에 들어있는 만큼만 진행
                for (int s = 0; s < size; s++) {
                    int[] curr = dq.poll();
                    int r = curr[0];
                    int c = curr[1];

                    answer += map[r][c];

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                        if (!visited[nr][nc]) {
                            dq.offer(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
                step++;
            }

            sb.append("#").append(tc).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }
}
