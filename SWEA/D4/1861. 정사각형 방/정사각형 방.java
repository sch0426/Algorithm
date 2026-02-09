import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int map[][];
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) { 
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxCnt = 0;
			int location = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int cnt = dfs(i, j);
					if(maxCnt < cnt) {
						maxCnt = cnt;
						location = map[i][j];
					} else if(maxCnt == cnt) {
						if(location > map[i][j]) location = map[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + location + " " + maxCnt);
		}
	}
	
	/*
	 * 모든 위치마다 dfs 를 돌려서 해당 위치부터
	 * 현재 본인의 위치map[][] 보다 1 큰 방향으로 이동을 할거임
	 * 이동을 하는데 더이상 갈 곳이 없으면 현재 위치까지 오는데 몇번 왔는지 갱신할거임
	 */
	private static int dfs(int r, int c) {
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 다음 둘러볼 곳이 벽 내부이고
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
				// 현재 위치보다 1 크면 이동
				if(map[r][c] + 1 == map[nr][nc]) {
					return dfs(nr, nc) + 1;
				}
			}
		}
		
		return 1;
	}

}
