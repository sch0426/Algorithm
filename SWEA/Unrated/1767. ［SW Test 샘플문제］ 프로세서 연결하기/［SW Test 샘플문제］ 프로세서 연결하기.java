import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int N, map[][], connectCellCnt, totalCell, totalLine;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static ArrayList<int[]> core = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            core.clear();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            connectCellCnt = 0;
            totalCell = 0;
            totalLine = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if((i == 0 || j == 0 || i == N-1 || j == N-1) && map[i][j] == 1) continue;
                    if(map[i][j] == 1) core.add(new int[] {i, j});
                }

            }

            totalCell = core.size();
            connectCell(0, 0, 0);

            System.out.println("#" + tc + " " + totalLine);
        }
    }

    private static void connectCell(int coreIdx, int lineLen, int cellCnt) {
        // 코어 다 돌았으면 갱신하기
        if(coreIdx == totalCell) {
            // 코어가 더 많이 연결됐으면 갱신
            if(cellCnt > connectCellCnt) {
                connectCellCnt = cellCnt;
                totalLine = lineLen;
                // 갱신되어있는 코어수와 같다면 더 라인이 작은거로 갱신
            } else if(cellCnt == connectCellCnt) {
                totalLine = Math.min(totalLine, lineLen);
            }
            return;
        }

        int[] coreLocation = core.get(coreIdx); // 각 코어 좌표
        int r = coreLocation[0];
        int c = coreLocation[1];
        // 해당 코어에서
        for(int d = 0; d < 4; d++) {
            // 전선 연결 못하면 다른 방향 탐색
            if(!isAvailable(r, c, d)) continue;
            // 연결 하는 경우
            // 전선 깔기
            int cnt = connect(r, c, d, 2);
            connectCell(coreIdx + 1, lineLen + cnt, cellCnt + 1);
            // 전선 끊기
            connect(r, c, d, 0);
        }
        // 연결하지 않는 경우
        connectCell(coreIdx + 1, lineLen, cellCnt);


    }

    // 해당 방향으로 전선 연결하기
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

    // 해당 방향으로 전선을 연결할 수 있는지
    private static boolean isAvailable(int r, int c, int d) {
        int nr = r, nc = c;

        while(true) {
            nr += dr[d];
            nc += dc[d];
            // 끝에 도달하면 해당 경로까지 방해요소가 없었으니까 true 반환
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
            // 해당 방향으로 탐색하는데 0이 아닌걸 만나면 다른 셀이거나 전선을 만난거라 안됌
            if(map[nr][nc] != 0) return false;
        }

        return true;
    }

}

