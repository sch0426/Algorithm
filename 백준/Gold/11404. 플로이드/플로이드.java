import java.util.*;
import java.io.*;

// BOJ 11404. 플로이드
public class Main {
	static int N, M, minCost[][];
	static ArrayList<int[]>[] cities;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cities = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			cities[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			cities[start].add(new int[] {end, cost});
		}
		minCost = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(minCost[i], Integer.MAX_VALUE);
		}
		
		// 알고리즘 작성
		for(int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		
		// 출력
		print();
	}
	
	private static void dijkstra(int startNode) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[startNode] = 0;
		pq.offer(new int[] {startNode, dist[startNode]});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currEnd = curr[0];
			int currDist = curr[1];
			
			for(int[] next : cities[currEnd]) {
				int nextNode = next[0];
				int nextCost = next[1];
				
				if(dist[nextNode] > currDist + nextCost) {
					dist[nextNode] = currDist + nextCost;
					pq.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			minCost[startNode - 1][i - 1] = Math.min(minCost[startNode - 1][i - 1], dist[i]);
		}
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(minCost[i][j] == Integer.MAX_VALUE) sb.append(0);
				else sb.append(minCost[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
