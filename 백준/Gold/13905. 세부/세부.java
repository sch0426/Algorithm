import java.util.*;
import java.io.*;

public class Main {
	static int N, M, S, E;
	static ArrayList<int[]>[] house;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			house[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			house[h1].add(new int[] { h2, k });
			house[h2].add(new int[] { h1, k });
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		int[] dist = new int[N + 1];
		dist[S] = Integer.MAX_VALUE;
		pq.offer(new int[] {S, dist[S]});
		
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currWeight = curr[1];
			
			if(curr[0] == E) break;
			
			for(int[] next : house[currNode]) {
				int nextNode = next[0];
				int nextWeight = next[1];
				
				int maxWeight = Math.min(currWeight, nextWeight);
				
				if(dist[nextNode] < maxWeight) {
					dist[nextNode] = maxWeight;
					pq.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		System.out.println(dist[E]);
	}

}
