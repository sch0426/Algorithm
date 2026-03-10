import java.util.*;
import java.io.*;

public class Solution {
	static int N, ans;
	static int[][] customer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			customer = new int[2][N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 회사
			customer[0][0] = Integer.parseInt(st.nextToken());
			customer[1][0] = Integer.parseInt(st.nextToken());
			
			// 집
			customer[0][N + 1] = Integer.parseInt(st.nextToken());
			customer[1][N + 1] = Integer.parseInt(st.nextToken());
			
			// 고객
			for(int i = 1; i < N + 1; i++) {
				customer[0][i] = Integer.parseInt(st.nextToken());
				customer[1][i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			goHome(0, 0, 0, new boolean[N + 2]);
			
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void print() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				System.out.print(customer[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * @param cnt: 		만난 고객 수
	 * @param currIdx:	현재 위치 인덱스
	 * @param dist: 	누적 이동거리	
	 * @param v:		고객 방문배열
	 */
	private static void goHome(int cnt, int start, int dist, boolean[] v) {
		// 마지막 고객 -> 집
		if(cnt == N) {
			int totalDist = dist + getDist(start, N + 1);
			ans = Math.min(ans, totalDist);
			return;
		}
		
		// 고객을 다 돌기 전에 누적 이동거리가 최종 이동거리보다 크다면 가지치기
		if(dist > ans) return;
		
		// 고객 수 만큼
		for(int next = 1; next < N + 1; next++) {
			if(!v[next]) {
				v[next] = true;
				int currDist = getDist(start, next);
				goHome(cnt + 1, next, dist + currDist, v);
				v[next] = false;
			}
		}
	}

	private static int getDist(int start, int end) {
		return Math.abs(customer[0][start] - customer[0][end]) + Math.abs(customer[1][start] - customer[1][end]);
	}
	
}
