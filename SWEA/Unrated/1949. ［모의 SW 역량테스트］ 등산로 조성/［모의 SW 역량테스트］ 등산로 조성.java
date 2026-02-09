import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K, map[][], Heightest;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 지도 한변의 길이
			N = Integer.parseInt(st.nextToken());
			// 삽질 가능한 깊이
			K = Integer.parseInt(st.nextToken());
			// 지도 정보 입력 및 최대높이 찾기
			Heightest = 0;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					Heightest = Math.max(Heightest, map[i][j]);
				}
			}
			
			// 최대 높이 찾았는지 확인
//			System.out.println(Heightest);
			// 입력값 확인
//			print();
			
			int ans = 0;
//			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == Heightest) {
						visited = new boolean[N][N];
						visited[i][j] = true;
						int cnt = dfs(i, j, false, visited);
						ans = Math.max(ans, cnt);
					}
				}
			}
			
			sb.append("#" + tc + " ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}
	
	/*
	 * 입력 : 제일 높은 봉우리의 (r,c) 좌표
	 * 4방탐색해서 현재 위치보다 낮은 쪽으로만 이동
	 * 		특이케이스 : K만큼 땅을 '단 한번' 팔 수 있다
	 */
	private static int dfs(int r, int c, boolean crack, boolean[][] visited) {
		int tmp = 1;
		// 4방탐색
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 다음 갈 곳이 지도 내부인지, 방문하지 않은 곳
			if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
				// 다음 갈 곳이 현재 봉우리보다 낮은지
				if(map[r][c] > map[nr][nc]) {
					// 방문처리
					visited[nr][nc] = true;
					// 진입
					tmp = Math.max(tmp, dfs(nr, nc, crack, visited) + 1);
					// 방문 안한거로 처리
					visited[nr][nc] = false;
				}
				// 다음 갈 곳이 현재 봉우리와 같거나 높은지
				if(map[r][c] <= map[nr][nc]) {
					// 삽질 아직 안했고 K 이하만큼 차이 나면 땅 파고 진입
					if(!crack && map[nr][nc] - map[r][c] < K) {
						// 차이나는 정도
						int diff = map[nr][nc] - map[r][c];
						// 땅 파놓고
						map[nr][nc] = map[nr][nc] - (diff) - 1;
						// 방문처리 하기
						visited[nr][nc] = true;
						// 진입
						tmp = Math.max(tmp, dfs(nr, nc, true, visited) + 1);
						// 땅 다시 쌓기
						map[nr][nc] = map[nr][nc] + (diff) + 1;
						// 방문 안한거로 처리하기
						visited[nr][nc] = false;
					}
				}
			}
		}
		// 더 이상 갈 곳이 없으면 끝
		return tmp;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
