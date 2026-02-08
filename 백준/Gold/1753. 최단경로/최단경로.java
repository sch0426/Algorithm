import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    int e, w;

    Node(int e, int w) {
        this.e = e;
        this.w = w;
    }
}

public class Main {
    static int V, E, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
        ArrayList<Node>[] adj = new ArrayList[V + 1];
        // 정점의 개수만큼 배열 선언 , 인덱스 1부터 시작할거임
        for(int i = 1; i < V + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        // 간선의 개수만큼 입력이 주어진다
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V + 1];
        dist[K] = 0;

        for(int step = 1; step < V + 1; step++) {
            // 거리배열에서 기준정점으로 방문하지 않은 정점중 최소거리정점을 선택한다
            int minIdx = -1;
            int minDist = Integer.MAX_VALUE;
            for(int i = 1; i < V + 1; i++) {
                if(!visited[i] && dist[i] < minDist) {
                    minIdx = i;
                    minDist = dist[i];
                }
            }

            if(minIdx == -1) break;

            // 더이상 볼 필요없다
            visited[minIdx] = true;
            for(Node node : adj[minIdx]) {
                if(dist[node.e] > dist[minIdx] + node.w) {
                    dist[node.e] = dist[minIdx] + node.w;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < V + 1; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}
