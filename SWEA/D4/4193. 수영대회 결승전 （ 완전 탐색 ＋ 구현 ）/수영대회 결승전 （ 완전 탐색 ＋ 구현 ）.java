import java.util.*;
import java.io.*;

// 행, 열, 이동거리, 현재시간
class Node{
    int r;
    int c;
    int dist;
    int time;

    public Node(int r, int c, int dist, int time) {
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.time = time;
    }
}

public class Solution {
    static int N;
    static int[][] arr;
    static int ans;
    static int[] dr = {0 , 1, 0, -1};
    static int[] dc = {1 , 0, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            // 수영장 맵 입력 초기화
            StringTokenizer st;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());

            ans = bfs(sR, sC, eR, eC);
            sb.append("#" + tc + " ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int sR, int sC, int eR, int eC) {
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] v = new boolean[N][N];

        v[sR][sC] = true;
        // 행, 열, 이동거리, 시간
        q.offer(new Node(sR, sC, 0, 0));

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Node curr = q.poll();

            // 도착하면 최소값으로 갱신
            if (curr.r == eR && curr.c == eC) {
            	ans = Math.min(ans, curr.time);
            	continue;
            }

            // 4방탐색
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                // 맵 벗어나면 패스
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                // 벽 만났거나 방문한 곳은 패스
                if(arr[nr][nc] == 1 || v[nr][nc]) continue;
                
                // 소용돌이 만난 경우
                if(arr[nr][nc] == 2) {
                	// 소용돌이 꺼졌으면 그길로 이동
                	if(curr.time % 3 == 2 && !v[nr][nc]) {
                		v[nr][nc] = true;
                		q.offer(new Node(nr, nc, curr.dist + 1, curr.time + 1));
                	} else {
                		// 소용돌이 끝날때까지 그자리에서 대기
                		q.offer(new Node(curr.r, curr.c, curr.dist, curr.time + 1));
                	}
                } else {// 소용돌이 안만난 경우
                	if(!v[nr][nc]) {
                		v[nr][nc] = true;
                		q.offer(new Node(nr, nc, curr.dist + 1, curr.time + 1));
                	}
                }
            }
            
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


}
