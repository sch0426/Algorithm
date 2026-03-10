import java.util.*;
import java.io.*;

// SWEA 3124. 최소 스패닝 트리
public class Solution {
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V + 1];
			
			makeSets();
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				pq.add(new Edge(start, end, weight));
			}
			
			int cnt = 0;
			double result = 0;
			while(!pq.isEmpty()) {
				Edge curr = pq.poll();
				if(union(curr.start, curr.end)) {
					result += curr.weight;
					if(++cnt == V - 1) break;
				}
			}
			sb.append("#" + tc + " ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makeSets() {
		for(int i = 1; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
