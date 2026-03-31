import java.util.*;
import java.io.*;

public class Main {
	static int N, M, map[][];
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					q.offer(new int[] { i, j });
				}
			}
		}
		
		int time = 0;
		while (true) {
			visited = new boolean[N][M];
			int bfsCnt = 0;
			for(int[] m : q) {
				if(!visited[m[0]][m[1]]) {
					bfs(m);
					bfsCnt++;
				}
			}
			
			if(bfsCnt > 1) {
				System.out.println(time);
				return;
			}
			
			if(q.isEmpty()) {
				System.out.println(0);
				return;
			}
			
			int size = q.size();
			ArrayList<int[]> meltM = new ArrayList<>();
			for (int step = 0; step < size; step++) {
				int[] currM = q.poll();
				int currR = currM[0];
				int currC = currM[1];
				int meltCnt = 0;

				for (int d = 0; d < 4; d++) {
					int nr = currR + dr[d];
					int nc = currC + dc[d];

					if (!isIn(nr, nc)) continue;
					if (map[nr][nc] != 0) continue;
					meltCnt++;
				}
				meltM.add(new int[] {currR, currC, meltCnt});
			}
			
			for(int[] m : meltM) {
				int r = m[0];
				int c = m[1];
				int meltCnt = m[2];
				map[r][c] -= meltCnt;
				if(map[r][c] > 0) {
					q.offer(new int[] {r, c});
				} else {
					map[r][c] = 0;
				}
			}
			
			time++;
		
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	private static void bfs(int[] start) {
	    Queue<int[]> queue = new ArrayDeque<>();
	    queue.offer(start);
	    visited[start[0]][start[1]] = true;

	    while (!queue.isEmpty()) {
	        int[] curr = queue.poll();

	        for (int d = 0; d < 4; d++) {
	            int nr = curr[0] + dr[d];
	            int nc = curr[1] + dc[d];

	            if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
	                visited[nr][nc] = true;
	                queue.offer(new int[] { nr, nc });
	            }
	        }
	    }
	}
	
}
