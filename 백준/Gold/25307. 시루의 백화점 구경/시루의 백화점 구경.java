import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int r, c, dist;
		
		public Node(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
	}
	
	static int N, M, K, ans, map[][];
	static ArrayList<int[]> mannequin = new ArrayList<>();
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[] start, end;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 3)
					mannequin.add(new int[] { i, j });
				if (map[i][j] == 4)
					start = new int[] { i, j };
				if (map[i][j] == 2)
					end = new int[] { i, j };
			}
		}

		bfs1();
//		print();
		
		if (end == null || map[end[0]][end[1]] == -1) {
			System.out.println(-1);
			return;
		}
		bfs();
		System.out.println(ans);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs1() {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		for (int[] m : mannequin) {
			v[m[0]][m[1]] = true;
			q.offer(m);
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			if (cnt == K)
				return;
			int size = q.size();
			for (int step = 0; step < size; step++) {
				int[] curr = q.poll();
				int currR = curr[0];
				int currC = curr[1];

				for (int d = 0; d < 4; d++) {
					int nr = currR + dr[d];
					int nc = currC + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)	continue;
					if (v[nr][nc]) continue;
					
					v[nr][nc] = true;
					map[nr][nc] = -1;
					q.offer(new int[] { nr, nc });
				}

			}
			cnt++;
		}

	}

	private static void bfs() {
		Deque<Node> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		v[start[0]][start[1]] = true;
		q.offer(new Node(start[0], start[1], 0));

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int currR = curr.r;
			int currC = curr.c;
			int currD = curr.dist;

			if (map[currR][currC] == 2) {
				ans = currD;
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)	continue;
				if (v[nr][nc]) continue;
				
				if (map[nr][nc] == 0 || map[nr][nc] == 2) {
					v[nr][nc] = true;
					q.offer(new Node(nr, nc, currD + 1));
				}
			}
		}
		ans = -1;
		return;
	}

}
