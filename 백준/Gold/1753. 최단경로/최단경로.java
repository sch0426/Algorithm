import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
 * 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 * 첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
 */
public class Main {

	static class Node {
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
	}
	
	static int V, E, dist[];
	static ArrayList<Node>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine()) - 1;
		graph = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		dist = new int[V];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(start);
		for (int distance : dist) {
			System.out.println(distance == Integer.MAX_VALUE ? "INF" : distance);
		}
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int v = curr.v;
			int w = curr.w;
			
			if(dist[v] < w) continue;
			
			for(Node node : graph[v]) {
				if(dist[node.v] > dist[v] + node.w) {
					dist[node.v] = dist[v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}
		
	}

}
