import java.util.*;
import java.io.*;

// SWEA 7793. 오! 나의 여신님
public class Solution {
	static class Node {
		int r, c;
		String who;
		
		public Node(int r, int c, String who) {
			super();
			this.r = r;
			this.c = c;
			this.who = who;
		}
		
	}
	
	static int N, M, start[], end[], time;
	static char map[][];
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] devilVisited, humanVisited;
	static ArrayList<int[]> devil;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			start = new int[2];
			end = new int[2];
			devil = new ArrayList<>();
			map = new char[N][M];
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'S') {start[0]=i; start[1]=j;}
					if(map[i][j] == 'D') {end[0]=i; end[1]=j;}
					if(map[i][j] == '*') {devil.add(new int[] {i, j});}
				}
			}
			
			time = 0;
			sb.append(gripOfTheDevil() == true ? time : "GAME OVER");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 악마의 손아귀
	private static boolean gripOfTheDevil() {
		Deque<Node> q = new ArrayDeque<>();
		
		devilVisited = new boolean[N][M];
		for(int[] d : devil) {
			devilVisited[d[0]][d[1]] = true;
			q.offer(new Node(d[0], d[1], "Devil"));
		}
		
		humanVisited = new boolean[N][M];
		humanVisited[start[0]][start[1]] = true;
		q.offer(new Node(start[0], start[1], "Human"));
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int step = 0; step < size; step++) {
				Node curr = q.poll();
				
				if(map[curr.r][curr.c] == 'D') return true;
				
				for(int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];
					
					// 맵 벗어나면 안됌
					if(!isIn(nr, nc)) continue;
					
					if(curr.who.equals("Devil")) {
						// 돌, 여신의 공간에는 퍼질 수 없음
						if(map[nr][nc] == 'X' || map[nr][nc] == 'D') continue;
						// 이미 퍼지지 않은 곳
						if(!devilVisited[nr][nc]) {
							devilVisited[nr][nc] = true;
							q.add(new Node(nr, nc, "Devil"));
						}						
					} else {
						// 돌, 악마의 손아귀에는 퍼질 수 없음
						if(map[nr][nc] == 'X' || devilVisited[nr][nc]) continue;
						// 이미 퍼지지 않은 곳
						if(!humanVisited[nr][nc]) {
							humanVisited[nr][nc] = true;
							q.add(new Node(nr, nc, "Human"));
						}	
					}
					
				}
			}
			time++;
		}
		return false;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
