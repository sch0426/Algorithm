import java.util.*;
import java.io.*;

public class Solution {
	static int N = 4, Limit = 7;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Set<String> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			set = new HashSet<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dfs(i, j, 0, "");
				}
			}
			sb.append("#" + tc + " ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int r, int c, int moveCnt, String num) {
		if(moveCnt == Limit) {
			set.add(num);
			return;
		}
		
		num += map[r][c];
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			dfs(nr, nc, moveCnt + 1, num);
		}
	}

}
