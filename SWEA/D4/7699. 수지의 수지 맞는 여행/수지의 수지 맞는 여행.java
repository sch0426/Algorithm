import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 7699. 수지의 수지 맞은 여행
/*
 * 1행 1열 ~ R행 C열 / R*C 칸
 * 수지는 1행 1열에서 시작
 * 섬의 각 칸에는 알파벳 -> 중복 있다
 * 명물을 처음 볼 때는 무료, 이후에는 요금 발생
 * 4방탐색
 * 명물을 최대한 많이 보되, 요금을 지급하지 않는 방법
 * 같은 알파벳 명물을 두 번 이상 보지 않도록 여행을 떠나는 방법 중에 볼 수 있는 명물의 "최대 개수"를 구하여라.
 * -> 각 요금은 제공되지 않았다
 */

public class Solution {
	static char[][] island;
	static boolean[] alpha;
	static int R, C, ans;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// 섬 배열
			island = new char[R][C];
			// 각 섬별로 방문체크 -> 알파벳이라 26개로
			alpha = new boolean[26];
			// 섬 입력 초기화
			for(int i = 0; i < R; i++) {
				String str = br.readLine();
				for(int j = 0; j < C; j++) {
					island[i][j] = str.charAt(j);
				}
			}
			
			ans = Integer.MIN_VALUE;
			dfs(0, 0, 1);
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
	
	private static void dfs(int r, int c, int cnt) {		
		// 방문처리 하고
		alpha[island[r][c] - 'A'] = true;
		
		// 4방탐색
		boolean isEnd = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 맵 벗어나면 탈출
			if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
			
			// 처음 본 알파벳이면 
			if(!alpha[island[nr][nc] - 'A']) {
				// 다음으로 이동하고
				dfs(nr, nc, cnt + 1);
				// 돌아와서 다음 간곳을 다른애가 갈 수 있으니 미방문 처리
				alpha[island[nr][nc] - 'A'] = false;
				isEnd = false;
			}
		}
		// 더이상 이동 못했으면 값 갱신해주고 탈출
		if(isEnd) {
			ans = Math.max(ans, cnt);
			return;
		}
		
	}

}
