import java.util.*;
import java.io.*;

class Location{
	int r;
	int c;
	
	public Location(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int N = 16;
	static int[][] maze;
	static int[] dr = {0, 1, 0, -1}; // 오른쪽 아래 왼쪽 위 순서
	static int[] dc = {1, 0, -1, 0};
	static int ans;
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			maze = new int[N][N]; // 16*16 미로 초기화
			int sR = 0;
			int sC = 0;
			int eR = 0;
			int eC = 0;
			
			for(int i = 0; i < N; i++) { // 미로 입력값 배열에 저장
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					maze[i][j] = str.charAt(j) - '0';
					if(maze[i][j] == 2) {
						sR = i;
						sC = j;
					} else if(maze[i][j] == 3) {
						eR = i;
						eC = j;
					}
				}
			}
			
			ans = 0; // 도착불가능으로 초기화
			v = new boolean[N][N]; // 방문배열 초기화
			bfs(sR, sC, eR, eC);
			sb.append("#" + T + " " + ans).append("\n");
		}
		System.out.println(sb);
	}
	
	/**
	 * @param sR : 시작행
	 * @param sC : 시작열
	 * @param eR : 도착행
	 * @param eC : 도착열
	 */
	private static void bfs(int sR, int sC, int eR, int eC) {
		Queue<Location> q = new ArrayDeque<>();
		v[sR][sC] = true;
		q.offer(new Location(sR, sC));
		
		while(!q.isEmpty()) {
			Location loca = q.poll();
			if(loca.r == eR && loca.c == eC) {
				ans = 1;
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = loca.r + dr[i];
				int nc = loca.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && maze[nr][nc] != 1) {
					v[nr][nc] = true;
					q.offer(new Location(nr, nc));
				}
			}
			
		}
	}

}
