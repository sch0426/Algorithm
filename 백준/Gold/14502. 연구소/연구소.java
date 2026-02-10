import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 0: 빈칸
 * 1: 벽
 * 2: 바이러스
 */
public class Main {
	static int N, M, map[][];
	static int wall = 3;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int MaxCnt;
	static boolean[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행 길이
		M = Integer.parseInt(st.nextToken()); // 열 길이
		map = new int[N][M]; // 맵 배열 생성
		for (int i = 0; i < N; i++) { // 맵 입력 초기화
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// (0,0)부터 벽 세울 수 있는 모든 경우의 수 찾아서 벽 세우기
		// 3개의 벽 각각의 위치 배열 (열 :벽은 3개까지 세움, 행: 각 벽의 (r,c))
		setWall(0, 0, new int[3][2], 0);
		
		System.out.println(MaxCnt);
	}

	// 벽 세우기
	/**
	 * @param r		: 현재 행
	 * @param c		: 현재 열
	 * @param sel	: 세운 벽의 위치 배열
	 * @param cnt	: 현재 벽 몇개 만들었는지	
	 */
	static void setWall(int r, int c, int[][] sel, int cnt) {		
		// 벽 3개를 다 세운 경우
		if(cnt == wall) {
			int[][] tmpMap = new int[N][M]; // 기존 맵 복사하기 위한 배열
			int[][] tmpSel = new int[3][2]; // 벽위치 조합 배열을 복사하기 위한 배열
			// 기존 맵 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tmpMap[i][j] = map[i][j];
				}
			}
			
			// 조합배열 복사
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 2; j++) {
					tmpSel[i][j] = sel[i][j];
				}
			}
			
			// 맵에 벽 세우기
			for(int i = 0; i < 3; i++) {
				tmpMap[tmpSel[i][0]][tmpSel[i][1]] = 1;
			}
			
			// 바이러스 퍼뜨리기
			v = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(tmpMap[i][j] == 2 && !v[i][j]) virus(tmpMap, i, j);
				}
			}
			
			MaxCnt = Math.max(MaxCnt, cntBlank(tmpMap));
			
			return;
		}
		
		// 이번열이 끝나면 다음 행으로 이동
		if(c == M) {
			setWall(r + 1, 0, sel, cnt);
			return;
		}
		
		// 행 끝까지 다 봤는데 벽을 다 안세운 경우는 그냥 끝
		if(r == N) return;
		
		// 현재 위치가 벽(1), 바이러스(2)인지 확인
		// 벽이나 바이러스면 다음 열로 이동
		if(map[r][c] == 1 || map[r][c] == 2) {
			setWall(r, c + 1, sel, cnt);
		} else if(map[r][c] == 0) {
			// 이번 위치에 벽을 세운다
			sel[cnt][0] = r;
			sel[cnt][1] = c;
			setWall(r, c + 1, sel, cnt + 1);
			// 이번 위치에 벽을 안세운다
			setWall(r, c + 1, sel, cnt);
		}
	}

	// 빈칸 세기
	static int cntBlank(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	// 바이러스 퍼지기
	static void virus(int[][] map, int r, int c) {
		Deque<int[]> q = new ArrayDeque<>();
		
		v[r][c] = true;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				
				// 맵 내부이고, 방문하지 않았고, 빈 칸인 경우만 큐 넣기
				if(nr >= 0 && nc >= 0 && nr < N && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					map[nr][nc] = 2;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
	
}
