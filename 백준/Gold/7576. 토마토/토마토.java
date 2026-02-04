import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

// boj 7576 토마토
public class Main {
    static int M, N;
    static ArrayList<int[]> tomatos = new ArrayList<>();
    static int[][] box;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];
        boolean perfectTomato = true;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                // 처음에 익은 토마토 위치를 미리 저장
                if(box[i][j] == 1) tomatos.add(new int[] {i, j});
                if(box[i][j] == 0) perfectTomato = false;
            }
        }
        // 처음부터 모든 토마토가 익어있는 경우
        if(perfectTomato) {
            System.out.println(0);
            return;
        }

        bfs();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);

    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        // 익은 토마토 전부 큐에 넣기
        for(int[] tomato : tomatos) {
            q.offer(tomato);
        }

        int day = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int step = 0; step < size; step++) {
                int[] cur = q.poll();

                // 4방 탐색
                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];

                    // 박스 사이즈 넘어가면 패스
                    if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                    // 빈 공간 만나면 패스
                    if (box[nr][nc] == -1) continue;

                    if (box[nr][nc] == 0) {
                        box[nr][nc] = 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            day++;
        }
        ans = day - 1;
    }

}
