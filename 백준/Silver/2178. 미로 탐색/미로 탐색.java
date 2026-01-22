import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 1, 0, -1}; // 오른쪽 아래 왼쪽 위 순서로 탐색
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // (N, M) 입력
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) { // 미로 초기화
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[N][M];

        bfs(maze, 0, 0, visited);
        System.out.println(maze[N - 1][M - 1]);
    }

    /**
     *
     * @param maze      : 2차원 미로 배열
     * @param startX    : 시작 행 번호
     * @param startY    : 시작 열 번호
     * @param visited	: 방문체크
     */
    static void bfs(int[][] maze, int startX, int startY, boolean[][] visited) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[startX][startY] = true; // 시작지점 방문처리
        int[] curr = {startX, startY};
        queue.offer(curr); // 시작지점 큐에 넣기

        // 큐의 제일 앞에를 빼고, 그 값에서 탐색을 시작(4방향), 갈 수 있으면 거기를 방문처리 하고 방문, 큐가 다 빌때까지 방문
        while(!queue.isEmpty()) {
            curr = queue.poll(); // 큐 제일 앞에 요소 제거

            for(int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                // 미로 맵 초과하거나, 방문한 곳이거나, 벽(0)인 경우는 패스
                if(nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[0].length) continue;
                if(visited[nx][ny]) continue;
                if(maze[nx][ny] == 0) continue;
                // 갈 수 있는 경로면, 방문처리 하고, 이동
                visited[nx][ny] = true;
                maze[nx][ny] += maze[curr[0]][curr[1]];
                queue.offer(new int[]{nx, ny});
            }
        }

    }

}
