import java.util.*;
import java.io.*;

class Node {
	int start, end, weight;

	public Node(int start, int end, int weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
}

public class Main {
	static int N, M, W;
	static ArrayList<Node> adj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			adj = new ArrayList<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				adj.add(new Node(start, end, time));
				adj.add(new Node(end, start, time));
			}
			
			for(int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				adj.add(new Node(start, end, -time));
			}
			
			boolean isAvailable = bellmanFord();
			if(isAvailable) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static boolean bellmanFord() {
		int[] dist = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			for(Node node : adj) {
				if(dist[node.end] > dist[node.start] + node.weight) {
					dist[node.end] = dist[node.start] + node.weight;
					if(i == N) return true;
				}
			} 
		}
		
		return false;
	}

}
