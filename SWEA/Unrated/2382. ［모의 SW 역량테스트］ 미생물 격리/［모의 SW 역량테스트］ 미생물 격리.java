import java.util.*;
import java.io.*;

/*
 * 맵 크기: N*N
 * 제한구역: r == 0 || c == 0 || r == N-1 || c == N-1
 * 제한시간: M
 * 군집의 수 : K개
 * 군집
 * 	- 속성: 미생물의 수, 이동 방향(상, 하, 좌, 우)
 * 	- 특성: 
 * 		1) 제한구역에 도착하면 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값으로 갱신
 * 			미생물의 수가 0이되면 군집은 사라지게 된다.
 * 		2) 제한구역에 도착하면 이동방향이 반대로 바뀐다. 
 * 			dir%2 == 0 ? dir++ : dir--
 * 		3) 군집끼리 만나는 경우 하나의 군집으로 합쳐진다.
 * 			이동방향은 미생물의 수가 많은 군집의 이동방향이 된다.
 */

// SWEA 2382. 미생물 격리
public class Solution {
	static class Bug {
		int r, c, weight, dir; // 행, 열, 미생물 수, 이동방향

		public Bug(int r, int c, int weight, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
			this.dir = dir;
		}
		
		private void move() {
			this.r = r + dr[dir];
			this.c = c + dc[dir];
		}
		
		private void downWeight() {
			this.weight = (int)(weight / 2);
		}
		
		private void turn() {
			if(this.dir % 2 == 0) {
				this.dir += 1;
			} else {
				this.dir -= 1;
			}
		}
		
	}
	
	static int N, M, K;
	static ArrayList<Bug> bugs;
	static ArrayList<Bug>[][] map;
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 한변의 길이
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 군집 수
			bugs = new ArrayList<>(); // 군집  저장 리스트
			
			// 군집 입력값 저장
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				bugs.add(new Bug(r, c, weight, dir));
			}
			
			map = new ArrayList[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			
			// M시간 반복
			for(int time = 0; time < M; time++) {
				start();
			}

			int ans = 0;
			for(Bug bug : bugs) {
				ans += bug.weight;
			}
			
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	// 군집끼리 만나는 경우도 있어서 군집 하나하나 시뮬레이션이 아닌
	// 모든 군집을 각 이동방향으로 이동시키고 한번에 처리하는 방식
	// (반복)군집 리스트 -> 각각 이동 후 맵에 뿌리기 -> 처리 후 다시 군집 리스트에 저장
	private static void start() {
		for(Bug bug : bugs) {
			// 이동 전 맵에서 각 군집의 현재 위치를 초기화 시킨다
			map[bug.r][bug.c].clear();
		}
		for(Bug bug : bugs) {
			// 이동 방향으로 한칸 이동시킨다
			bug.move();
			// 이동 후 위치를 맵에 저장한다
			map[bug.r][bug.c].add(bug);
		}
		// 군집 리스트 초기화
		bugs.clear();
		// 각 군집들이 모두 이동한 후 위치가 맵에 갱신됐으니 제한구역에 들어간 경우와, 군집끼리 만난 경우를 처리해주면 된다
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 맵의 해당 좌표에 군집이 있는 경우
				if(!map[i][j].isEmpty()) {
					// 해당 좌표가 제한구역인 경우
					if(isOut(i, j)) {
						for(Bug b : map[i][j]) {
							b.downWeight(); // 미생물 죽이기
							b.turn(); // 방향전환
							if(b.weight != 0) {
								bugs.add(new Bug(i, j, b.weight, b.dir));
							}
						}
					}
					// 해당 좌표가 제한구역이 아닌 경우
					else {
						// 해당 좌표에서 군집의 최대 크기, 모든 군집의 크기를 더한 값, 최대크기인 군집의 이동방향
						int maxWeight = -1, sumWeight = 0, maxDir = -1;
						for(Bug b : map[i][j]) {
							sumWeight += b.weight;
							if(maxWeight < b.weight) {
								maxWeight = b.weight;
								maxDir = b.dir;
							}
						}
						bugs.add(new Bug(i, j, sumWeight, maxDir));
					}
				}
			}
		}
	}
	
	// 해당 좌표가 제한구역에 들어갔는지 체크하는 메서드
	// true면 제한구역 들어간 것, false면 제한구역 들어가지 않은 것
	private static boolean isOut(int r, int c) {
		return r == 0 || c == 0 || r == N - 1 || c == N - 1;
	}
	
}
