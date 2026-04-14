import java.util.*;
import java.io.*;

// SWEA 5643. 키 순서
public class Solution {
	static final int INF = 100000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int[][] adj = new int[N + 1][N + 1];
			for(int i = 1; i <= N; i++) {
				Arrays.fill(adj[i], INF);
				adj[i][i] = 0;
			}
			
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				adj[start][end] = 1;
			}
			
			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						if(adj[i][k] == INF || adj[k][j] == INF) continue;
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
			
			int cnt = 0;
			for(int i = 1; i <= N; i++) {
				int temp = 0;
				for(int j = 1; j <= N; j++) {
					if(i == j) continue;
					if(adj[i][j] != INF || adj[j][i] != INF) temp++;
				}
				if(temp == N - 1) cnt++;
			}
			
			sb.append("#" + tc + " ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
