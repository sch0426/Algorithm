import java.util.*;
import java.io.*;

public class Solution {
    static int N, map[][];
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            int ans = dijkstra(0, 0);
            sb.append("#" + tc + " ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int r, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {r, c, 0});
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[r][c] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currDist = curr[2];

            for(int i = 0; i < 4; i++) {
                int nr = currR + dr[i];
                int nc = currC + dc[i];

                // 맵 벗어나면 안됌
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                // 다음 본 곳이 (현재 내 위치까지 오는데 필요한 거리 + 내가 거기 가는데 필요한 거리) 보다 크다면
                if(dist[nr][nc] > currDist + map[nr][nc]) {
                    dist[nr][nc] = currDist + map[nr][nc];
                    pq.offer(new int[] {nr, nc, dist[nr][nc]});
                }
            }

        }
        return dist[N - 1][N - 1];
    }
}
