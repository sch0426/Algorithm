import java.util.*;
import java.io.*;

class Node {
	int r, c, hp, umbrella, cnt;

	public Node(int r, int c, int hp, int umbrella, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.hp = hp;
		this.umbrella = umbrella;
		this.cnt = cnt;
	}

}

public class Main {
	static int N, H, D;
	static char map[][];
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		int[] start = null;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S')
					start = new int[] { i, j };
			}
		}

		bfs(start);

	}

	private static void bfs(int[] start) {
	    Deque<Node> q = new ArrayDeque<>();
	    int[][] visited = new int[N][N];
	    
	    q.offer(new Node(start[0], start[1], H, 0, 0));
	    visited[start[0]][start[1]] = H;

	    while (!q.isEmpty()) {
	        Node currNode = q.poll();

	        for (int d = 0; d < 4; d++) {
	            int nr = currNode.r + dr[d];
	            int nc = currNode.c + dc[d];

	            if (!isIn(nr, nc)) continue;
	            
	            if (map[nr][nc] == 'E') {
	                System.out.println(currNode.cnt + 1);
	                return;
	            }
	            
	            int nextHp = currNode.hp;
	            int nextUmbrella = currNode.umbrella;

	            if (map[nr][nc] == 'U') {
	                nextUmbrella = D;
	            }
	            
	            if (nextUmbrella > 0) {
	                nextUmbrella--;
	            } else {
	                nextHp--;
	            }
	            
	            if (nextHp == 0) continue;
	            
	            if (visited[nr][nc] >= nextHp + nextUmbrella) continue;
	            
	            visited[nr][nc] = nextHp + nextUmbrella;
	            
	            q.offer(new Node(nr, nc, nextHp, nextUmbrella, currNode.cnt + 1));
	        }
	    }
	    System.out.println(-1);
	    return;
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
