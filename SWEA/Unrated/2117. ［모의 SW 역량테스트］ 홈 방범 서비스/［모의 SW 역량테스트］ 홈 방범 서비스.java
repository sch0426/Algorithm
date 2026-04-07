import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, map[][], home;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			home = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 1; k <= N + 1; k++) {
						int cost = getCost(k);
						int money = 0;
						int homeCnt = 0;
						
						Deque<int[]> q = new ArrayDeque<>();
						boolean[][] v = new boolean[N][N];
						v[i][j] = true;
						q.offer(new int[] {i, j});
						
						int dist = 0;
						while(!q.isEmpty()) {
							if(dist == k) break;
							int size = q.size();
							for(int step = 0; step < size; step++) {
								int curr[] = q.poll();
								int currR = curr[0];
								int currC = curr[1];
								
								if(map[currR][currC] == 1) {
									money += M;
									homeCnt++;
								}
								
								for(int d = 0; d < 4; d++) {
									int nr = currR + dr[d];
									int nc = currC + dc[d];
									
									if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
									if(v[nr][nc]) continue;
									
									v[nr][nc] = true;
									q.offer(new int[] {nr, nc});
								}
							}
							dist++;
						}
						
						if(cost <= money) home = Math.max(home, homeCnt);
					}
				}
			}
			sb.append("#" + tc + " ").append(home).append("\n");
		}
		System.out.println(sb);
	}
	
	// 운영 비용 = K * K + (K - 1) * (K - 1)
	private static int getCost(int K) {
		return K * K + (K - 1) * (K - 1);
	}
}	 
