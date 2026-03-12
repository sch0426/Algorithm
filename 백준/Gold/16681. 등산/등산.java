import java.util.*;
import java.io.*;

public class Main {
    static int N, M, D, E;
    static int[] h;
    static long[] upDist, downDist; // 거리는 long으로 저장
    static ArrayList<Node>[] path;

    // 간선 정보를 담을 클래스
    static class Node implements Comparable<Node> {
        int idx;
        long dist;

        public Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        h = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        path = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            path[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            path[start].add(new Node(end, dist));
            path[end].add(new Node(start, dist));
        }

        // 1번(집)에서 각 지점까지 올라가는 최단 거리
        upDist = dijkstra(1);
        // N번(학교)에서 각 지점까지 올라가는 최단 거리 (내려오는 길의 역방향)
        downDist = dijkstra(N);

        long ans = Long.MIN_VALUE; // int 범위를 넘으므로 Long.MIN_VALUE 사용
        boolean possible = false;

        for (int i = 1; i <= N; i++) {
            // 두 경로 모두 도달 가능한 경우에만 계산
            if (upDist[i] != Long.MAX_VALUE && downDist[i] != Long.MAX_VALUE) {
                // 등산의 가치 = (성취감) - (올라갈 때 소모 체력 + 내려올 때 소모 체력)
                long currentVal = (long) h[i] * E - (upDist[i] + downDist[i]) * D;
                ans = Math.max(ans, currentVal);
                possible = true;
            }
        }

        System.out.println(possible ? ans : "Impossible");
    }

    private static long[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currIdx = curr.idx;
            long currDist = curr.dist;

            if (currDist > dist[currIdx]) continue;

            for (Node next : path[currIdx]) {
                // 핵심 조건: 목표 지점으로 갈수록 높이가 "증가"해야 함
                if (h[next.idx] > h[currIdx]) {
                    if (dist[next.idx] > currDist + next.dist) {
                        dist[next.idx] = currDist + next.dist;
                        pq.add(new Node(next.idx, dist[next.idx]));
                    }
                }
            }
        }
        return dist;
    }
}