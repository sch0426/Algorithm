import java.io.*;
import java.util.*;

// CC(i) = ∑ j dist(i,j) 단, dist(i,j)는 노드i로부터 노드 j까지의 최단 거리

// SWEA 1263. 사람 네트워크2
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adj = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(adj[i], Integer.MAX_VALUE);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) adj[i][j] = tmp;
				}
				adj[i][i] = 0;
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE) continue;
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
			
			int sum = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int currSum = 0;
				for (int j = 0; j < N; j++) {
					currSum += adj[i][j];
				}
				sum = Math.min(sum, currSum);
			}
			sb.append("#" + tc + " ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
