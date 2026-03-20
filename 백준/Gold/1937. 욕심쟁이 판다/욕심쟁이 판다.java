import java.util.*;
import java.io.*;

public class Main {
	static int N, map[][], memo[][];
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static ArrayList<int[]> locations = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				locations.add(new int[] {i, j, map[i][j]});
				memo[i][j] = 1;
			}
		}
		
		locations.sort((a, b)->a[2]-b[2]);
		
		for(int[] location : locations) {
			int currR = location[0];
			int currC = location[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				if(map[currR][currC] < map[nr][nc]) {
					if(memo[nr][nc] < memo[currR][currC] + 1) {
						memo[nr][nc] = memo[currR][currC] + 1;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, memo[i][j]);
			}
		}
		System.out.println(ans);
	}
	
}
