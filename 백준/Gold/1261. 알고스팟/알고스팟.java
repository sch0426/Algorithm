import java.util.*;
import java.io.*;

class Node {
	int r, c, dist;

	public Node(int r, int c, int dist) {
		super();
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
	
}

public class Main {
	static int N, M, map[][], dist[][];
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		dist = new int[N][M];
		for(int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		System.out.println(dijkstra(0, 0, 0));
		
	}
	
	private static int dijkstra(int r, int c, int cost) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
		pq.add(new Node(r, c, cost));
		dist[r][c] = cost;
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int currR = current.r;
			int currC = current.c;
			int currDist = current.dist;
			
			if(currDist > dist[currR][currC]) continue; // 가지치기
			
			for(int i = 0; i < 4; i++) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				if(map[nr][nc] == 0) {
					if(dist[nr][nc] > currDist) {
						dist[nr][nc] = currDist;
						pq.add(new Node(nr, nc, currDist));
					}
				}else if(map[nr][nc] == 1) {
					if(dist[nr][nc] > currDist + 1) {
						dist[nr][nc] = currDist + 1;
						pq.add(new Node(nr, nc, currDist + 1));
					}
				}
			}
			
		}
		
		return dist[N - 1][M - 1];
		
	}
	
}
