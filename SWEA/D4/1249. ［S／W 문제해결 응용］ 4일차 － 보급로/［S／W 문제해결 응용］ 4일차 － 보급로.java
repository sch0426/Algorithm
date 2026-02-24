import java.util.*;
import java.io.*;

public class Solution {
	static int N, map[][], ans;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			ans = 0;
			dijkstra(0, 0);
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
	
	// {r, c, time}
	private static void dijkstra(int r, int c) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2]-b[2]);
		pq.offer(new int[] {r, c, 0});
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;
		
		while(!pq.isEmpty()) {
			int[] temp = pq.poll();
			
			if(temp[0] == N - 1 && temp[1] == N - 1) {
				ans = temp[2];
				return ;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < N && !v[nr][nc]) {
					v[nr][nc] = true;
					pq.offer(new int[] {nr, nc, temp[2]+map[nr][nc]});
				}
			}
		}
		
	}

}
