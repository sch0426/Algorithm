import java.util.*;
import java.io.*;

// SWEA 5656. 벽돌 깨기
public class Solution {
    static int N, W, H, bombCnt, totalBombCnt, ans;
    static int[][] map, copyMap;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            bombCnt = 0;
            map = new int[H][W];
            copyMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0)
                        bombCnt++;
                }
            }
            ans = Integer.MAX_VALUE;
            start(0, new int[N]);
            sb.append("#" + tc + " ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void start(int cnt, int[] bombCol) {
        if (cnt == N) {
            // bombIdx에 저장된 위치에 순서대로 폭탄을 떨어뜨린다
            for (int i = 0; i < H; i++) {
                copyMap[i] = map[i].clone();
            }
            totalBombCnt = bombCnt;
            for (int col : bombCol) {
                throwBomb(col);
                gravity();
            }
            ans = Math.min(ans, totalBombCnt);
            return;
        }

        for (int i = 0; i < W; i++) {
            bombCol[cnt] = i;
            start(cnt + 1, bombCol);
        }
    }

    private static void gravity() {
        for (int col = 0; col < W; col++) {
            Deque<Integer> q = new ArrayDeque<>();
            for(int row = H - 1; row >= 0; row--) {
                if(copyMap[row][col] > 0) {
                    q.offer(copyMap[row][col]);
                    copyMap[row][col] = 0;
                }
            }
            int size = q.size();
            for(int row = H - 1; row > H - 1 - size; row--) {
                copyMap[row][col] = q.poll();
            }
        }
    }

    // 폭탄을 떨어뜨릴 열 인덱스가 입력으로 들어온다
    // 해당 열에서 다음 행으로 계속 들어가다가 0이상인 값을 만나면 폭탄을 터트린다
    private static void throwBomb(int bombCol) {
        int nr = 0, nc = bombCol;
        while (true) {
            if (nr < 0 || nc < 0 || nr >= H || nc >= W)
                break;
            if (copyMap[nr][nc] > 0) {
                bomb(nr, nc, copyMap[nr][nc]);
                break;
            }
            nr++;
        }
    }

    private static void bomb(int r, int c, int power) {
        copyMap[r][c] = 0;
        totalBombCnt--;

        if(power == 1) return;

        // 블럭의 크기만큼 사방으로 블럭이 있으면 터트리기
        for (int d = 0; d < 4; d++) {
            for (int p = 1; p < power; p++) {
                int nr = r + dr[d] * p;
                int nc = c + dc[d] * p;
                if (nr < 0 || nc < 0 || nr >= H || nc >= W)
                    break;
                if (copyMap[nr][nc] > 0)
                    bomb(nr, nc, copyMap[nr][nc]);
            }
        }
    }

}

