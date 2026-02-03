import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] island;
    static boolean[][] v;
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        // 마지막 입력은 0 0
        while(!line.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            w = Integer.parseInt(st.nextToken()); // 가로
            h = Integer.parseInt(st.nextToken()); // 세로
            island = new int[h][w];
            // 섬 입력값 초기화
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 방문배열 초기화
            v = new boolean[h][w];
            int ans = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    // 땅이고 방문하지 않았으면 dfs 돌리기
                    if(island[i][j] == 1 && !v[i][j]) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
            // 새로운 줄 입력 받기
            line = br.readLine();
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        v[r][c] = true;

        for(int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= h || nc < 0 || nc >= w) continue;

            if(island[nr][nc] == 1 && !v[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

}