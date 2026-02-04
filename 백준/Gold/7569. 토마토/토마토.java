

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
/*
 * 익은 토마토들의 근처에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아서 익는다
 * 인접한 기준 : 위/아래/왼/오/앞/뒤
 * 며칠이 지나야 모든 토마도들이 다 익는지 -> 최소 일수
 * 일부 칸에는 토마토가 들어있지 않을 수 있다
 * 익은토마토 =1 / 익지않은토마토=0 / 빈공간=-1
 */
public class Main {
	static int[] dr = {0, 1, 0, -1, 0, 0};
	static int[] dc = {1, 0, -1, 0, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	static int M, N, H;
	static int[][][] box;
	static int ans;
	static ArrayList<int[]> tomatos = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		/*
		 * H : 상자 몇개 쌓았는지
		 * M : 각 상자의 행
		 * N : 각 상자의 열
		 * 토마토 입력값 초기화
		 */
		box = new int[H][M][N];
		boolean niceTomato = true;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < N; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 0) niceTomato = false;
					if(box[i][j][k] == 1) tomatos.add(new int[] {i, j, k});
				}
			}
		}
		// 입력부터 모두 익어있는 상태면 0 출력
		if(niceTomato) {
			System.out.println(0);
			return;
		}
				
		ans = 0;

		bfs();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < N; k++) { 
					if(box[i][j][k] == 0) {
						ans = -1;
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		for (int[] tomato : tomatos) {
			q.offer(tomato);
		}
		
		int day = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int step = 0; step < size; step++) {
				int[] tmp = q.poll();
				
				// 6방탐색
				for(int i = 0; i < 6; i++) {
					int nh = tmp[0] + dh[i];
					int nr = tmp[1] + dr[i];
					int nc = tmp[2] + dc[i];
					
					// 박스크기 벗어나면 패스
					if(nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= M || nc >= N) continue;
					// 빈공간 만나면 패스
					if(box[nh][nr][nc] == -1) continue;
					// 안익은 토마토 만나면 익게 만들고 큐에 집어넣기
					if(box[nh][nr][nc] == 0) {
						box[nh][nr][nc] = 1;
						q.offer(new int[] {nh, nr, nc});
					}
				}
			}
			day++;
		}
		ans = day-1;
	}

}
