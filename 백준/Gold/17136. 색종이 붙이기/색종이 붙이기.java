import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 10;
    static int[][] map = new int[N][N];
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 색종이 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(ans ==  Integer.MAX_VALUE ? -1 : ans);
    }

    private static void dfs(int r, int c, int cnt) {
        // basis part
        // 최소값보다 크면 패스
        if(cnt >= ans) return;
        // 열 끝에 도달하면 다음 행으로
        if(c == N) {
            dfs(r + 1, 0, cnt);
            return;
        }
        // 맵 끝에 도달하면
        if(r == N) {
            ans = Math.min(ans, cnt);
            return;
        }
        // 0이면 다음칸 탐색
        if(map[r][c] == 0) {
            dfs(r, c + 1, cnt);
            return;
        }

        // inductive part
        // 색종이크기 5부터 시도
        for(int p = 5; p > 0; p--) {
            // 해당 크기의 색종이 다 썼으면 패스
            if(paper[p] == 0) continue;
            // 붙일 수 없으면 패스
            if(!isStick(r, c, p)) continue;

            // 색종이 붙이기
            stick(r, c, p, 0);
            paper[p]--;
            // 다음칸 탐색
            dfs(r, c + 1, cnt + 1);
            // 색종이 떼기 (백트래킹)
            stick(r, c, p, 1);
            paper[p]++;
        }

    }

    private static void stick(int r, int c, int pSize, int state) {
        for(int i = r; i < r + pSize; i++) {
            for(int j = c; j < c + pSize; j++) {
                map[i][j] = state;
            }
        }
    }

    private static boolean isStick(int r, int c, int pSize) {
        if(r + pSize > N || c + pSize > N) return false;
        for(int i = r; i < r + pSize; i++) {
            for(int j = c; j < c + pSize; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

}
