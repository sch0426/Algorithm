import java.util.*;
import java.io.*;

public class Solution {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] smallCount;
    static int[] bigCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); // 학생 수
            M = Integer.parseInt(br.readLine()); // 비교 횟수
            
            adj = new ArrayList[N + 1];
            smallCount = new int[N + 1];
            bigCount = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b); // a < b 관계 (a에서 b로 화살표)
            }

            // 모든 학생에 대해 BFS 수행
            for (int i = 1; i <= N; i++) {
                bfs(i);
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                // 나보다 큰 사람 수 + 나보다 작은 사람 수 == N - 1 이면 위치를 아는 것
                if (smallCount[i] + bigCount[i] == N - 1) {
                    ans++;
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : adj[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    
                    // 핵심 로직:
                    // start 학생 입장에서는 next가 나보다 큰 사람임
                    bigCount[start]++;
                    // next 학생 입장에서는 start가 나보다 작은 사람임
                    smallCount[next]++;
                }
            }
        }
    }
}