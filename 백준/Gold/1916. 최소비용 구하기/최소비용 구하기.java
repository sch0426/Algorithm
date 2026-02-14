import java.util.*;
import java.io.*;

/**
 * BOJ 1916. 최소비용 구하기
 * 도시: N개
 * 버스: M개
 * A번째 도시에서 B번째 도시로 가는 최소비용을 구하라
 * 도시 -> 도시로 이동하는 비용을 기준으로 우선순위 큐를 사용하면 되겠다
 * dist[N] 거리배열을 이용해서 각 도시별로 최소비용을 갱신해야겠다
 */

class Node {
    int e, w;

    Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

}

public class Main {
    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, w));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dijkstra(s, e);
        System.out.println(dist[e]);
    }

    private static void dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.offer(new Node(s, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if(current.e == e) break;

            if(dist[current.e] < current.w) continue;

            for(Node n : graph[current.e]) {
                if(dist[n.e] > dist[current.e] + n.w) {
                    dist[n.e] = dist[current.e] + n.w;
                    pq.offer(new Node(n.e, dist[n.e]));
                }
            }
        }

    }

}
