import java.util.*;
import java.io.*;

class Location {
    int r;
    int c;
    int broken;
    int dist;
    Location(int r, int c, int broken, int dist) {
        this.r = r;
        this.c = c;
        this.broken = broken;
        this.dist = dist;
    }
}

public class Main {
    static int[][] arr;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][][] v;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        // (N, M)에 방문했는지 + 현재 벽을 부수는걸 썼는
        v = new boolean[N][M][2];
        System.out.println(bfs());

    }

    private static int bfs() {
        Deque<Location> q = new ArrayDeque<>();
        v[0][0][0] = true;
        q.add(new Location(0, 0, 0, 1));

        while (!q.isEmpty()) {
            Location loca = q.poll();

            if(loca.r == N - 1 && loca.c == M - 1) {
                return loca.dist;
            }

            for(int i = 0; i < 4; i++) {
                int nr = loca.r + dr[i];
                int nc = loca.c + dc[i];
                // 사방탐색
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                
                // 길이고 방문하지 않았다면
                if(arr[nr][nc] == 0 && !v[nr][nc][loca.broken]) {
                    v[nr][nc][loca.broken] = true;
                    q.add(new Location(nr, nc, loca.broken, loca.dist + 1));
                    // 길이 아니고 망치를 안썼다면
                } else if(arr[nr][nc] == 1 && loca.broken == 0 && !v[nr][nc][1]) {
                    v[nr][nc][1] = true;
                    q.add(new Location(nr, nc, 1, loca.dist + 1));
                }
            }
        }
        return -1;
    }

}
