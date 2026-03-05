import java.util.*;
import java.io.*;

public class Solution {
    static int N, map[][], ansLen, ansCore;
    static ArrayList<int[]> cores;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            cores = new ArrayList<>();
            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i > 0 && j > 0 && i < N - 1 && j < N - 1 && map[i][j] == 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }
            ansLen = 0;
            ansCore = 0;
            setCore(0, 0, 0);

            System.out.println("#" + tc + " " + ansLen);
        }

    }

    private static void setCore(int coreIdx, int totalLen, int connectCnt) {
        if(coreIdx == cores.size()) {
            if(connectCnt > ansCore) {
                ansCore = connectCnt;
                ansLen = totalLen;
            } else if(connectCnt == ansCore) {
                ansLen = Math.min(ansLen, totalLen);
            }
            return;
        }

        int[] currCoreInfo = cores.get(coreIdx);
        int r = currCoreInfo[0];
        int c = currCoreInfo[1];
        for(int d = 0; d < 4; d++) {
            if(!isAvailable(r, c, d)) continue;

            int cnt = connect(r, c, d, 2);
            setCore(coreIdx + 1, totalLen + cnt, connectCnt + 1);
            connect(r, c, d, 0);
        }
        setCore(coreIdx + 1, totalLen, connectCnt);
    }

    private static int connect(int r, int c, int d, int set) {
        int nr = r, nc = c, cnt = 0;

        while(true) {
            nr += dr[d];
            nc += dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
            map[nr][nc] = set;
            cnt++;
        }

        return cnt;
    }

    private static boolean isAvailable(int r, int c, int d) {
        int nr = r, nc = c;

        while(true) {
            nr += dr[d];
            nc += dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;

            if(map[nr][nc] != 0) return false;
        }

        return true;
    }
}
