import java.util.*;
import java.io.*;

public class Main {
	static int N, K, adj[][], minTime[][];
	static int totalMinTime = Integer.MAX_VALUE;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 알고리즘
		minTime = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(minTime[i], Integer.MAX_VALUE);
		}
		
		// min(i->j, i->k + k->j)
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					minTime[i][j] = Math.min(minTime[i][j], Math.min(adj[i][j], adj[i][k] + adj[k][j]));
				}
			}
		}
		
		v = new boolean[N];
		v[K] = true;
		dfs(K, 1, minTime[K][K]);
		
		// 출력
		System.out.println(totalMinTime);
	}
	
	private static void dfs(int curr, int vCnt, int sum) {
		if(vCnt == N) {
			totalMinTime = Math.min(totalMinTime, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				dfs(i, vCnt + 1, sum + minTime[curr][i]);
				v[i] = false;
			}
		}
		
	}

}
