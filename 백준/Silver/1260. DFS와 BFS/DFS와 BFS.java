import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        /*
        * N : 정점의 개수
        * M : 간선의 개수
        * V : 시작할 정점
        * */
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // graph 초기화
        boolean[][] graph = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            graph[row][col] = true;
            graph[col][row] = true;
        }

        // dfs 구현
        visited = new boolean[N + 1];
        dfs(V, graph, N);
        sb.append("\n");

        // bfs 구현
        visited = new boolean[N + 1];
        bfs(V, graph, N);

        System.out.println(sb.toString());
    }

    private static void dfs(int idx, boolean[][] graph, int N) {
        visited[idx] = true;
        sb.append(idx).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i, graph, N);
            }
        }
    }

    private static void bfs(int idx, boolean[][] graph, int N) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[idx] = true;
        queue.offer(idx);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(" ");
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[curr][i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
