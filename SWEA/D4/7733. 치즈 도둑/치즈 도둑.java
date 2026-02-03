import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// SWEA 7733. 치즈 도둑
/*
 * 한 변의 길이가 N인 정사각형
 * 각 칸의 값은 1~100 정수
 * 총 100일 동안 진행 되는데  X번째의 날에는 칸의 값이 X인 칸을 먹는다
 * 100일 중에서 치즈 덩어리가 가장 많을 때의 덩어리 개수를 구해라
 * 치즈 덩어리란 -> 상하좌우 기준으로 붙어있는 것
 */
public class Solution {
	static int[][] cheese;
	static boolean[][] v;
	static int N;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			// 치즈 한 변의 길이 N
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			
			StringTokenizer st;
			int max = Integer.MIN_VALUE; // 제일 맛있는 정도
			// 치즈 입력값 초기화
			for(int i = 0; i < N; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int t = Integer.parseInt(st.nextToken());
					cheese[i][j] = t;
					max = Math.max(max, t);
				}
			}
			
			// 최대 치즈 덩어리 개수
			ans = Integer.MIN_VALUE;
			// &quot;1일부터 시작 ~ 제일 맛있는 정도인 날&quot; 까지만 반복
			for(int t = 0; t < max; t++) {
				// 하루마다 치즈덩어리 갯수 세기
				int tmp = 0;
				// 하루마다 방문배열 초기화
				v = new boolean[N][N];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						// t일에 t일보다 맛이 높고, 거기를 방문하지 않았다면
						if(cheese[i][j] > t && !v[i][j]) {
							// bfs를 돌은 만큼 치즈덩어리 갯수
							bfs(i, j, t);
							tmp++;
						}
					}
				}
				// 하루마다 최대 치즈 덩어리 개수 갱신
				ans = Math.max(ans, tmp);
			}
			
			sb.append("#" + tc + " ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c, int taste) {
		Deque<int[]> q = new ArrayDeque<>();
		// 현재위치 방문처리
		v[r][c] = true;
		// 현재위치 큐에 넣기
		q.offer(new int[] {r, c});
		
		// 큐 빌때까지 반복
		while(!q.isEmpty()) {
			// 제일 앞에꺼 꺼내기
			int[] tmp = q.poll();
			
			// 4방탐색
			for(int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				// 치즈 크기를 벗어나거나 이미 방문했다면 패스
				if(nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc]) continue;

				// 갈 수 있는 방향은 큐에 넣기
				if(cheese[nr][nc] > taste) {
					v[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
			
		}
	}

}
