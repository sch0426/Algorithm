import java.io.*;
import java.util.*;

// CC(i) = ∑ j dist(i,j) 단, dist(i,j)는 노드i로부터 노드 j까지의 최단 거리

// SWEA 1263. 사람 네트워크2
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		final int INF = 100000000;
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adj = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
					if(adj[i][j] == 0) adj[i][j] = INF;  
				}
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
			
			int sum = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int currSum = 0;
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					currSum += adj[i][j];
				}
				sum = Math.min(sum, currSum);
			}
			sb.append("#" + tc + " ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
