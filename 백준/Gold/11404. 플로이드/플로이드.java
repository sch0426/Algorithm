import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
			adj[i][i] = 0;
		}
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			adj[start][end] = Math.min(adj[start][end], cost);
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {
						adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(adj[i][j] == Integer.MAX_VALUE) sb.append(0);
				else sb.append(adj[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
