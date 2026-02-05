import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SWEA 1247. 최적 경로
/*
 * 회사에서 출발해서 N번 들리고 본인 집으로 돌아가기
 * (x1, y1) (x2, y2) 거리공식 |x1-x2| + |y1-y2|
 * 두 점 사이 공식 : Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1])
 * 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로
 * 입력: 회사, 집, N명 고객 집 순서
 */
public class Solution {
	static int[][] arr;
	static int[][] sel;
	static boolean[] isSelected;
	static int N;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 고객 수
			st = new StringTokenizer(br.readLine());
			arr = new int[N + 2][2]; // 회사 + 집 + N = N + 2
			for(int i = 0; i < N + 2; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MAX_VALUE;
			sel = new int[N][2];
			isSelected = new boolean[N + 2];
			recursive(0);
			
			sb.append("#" + tc + " ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void recursive(int cnt) {
		if(cnt == N) {
			// N명의 회원의 집을 어떤 순서로 들릴지 경우의 수가 정해진 상황
			// 회사에서 시작 > 정해진 순서대로 거리 구하고 > 마지막에 집으로 거리계산
			distance(sel);
			return;
		}
		
		// 중복 안되고, 순서는 상관없음
		for(int i = 2; i < N + 2; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			// i 번째 손님 위치 저장
			sel[cnt][0] = arr[i][0];
			sel[cnt][1] = arr[i][1];
			recursive(cnt + 1);
			isSelected[i] = false;
		}

	}
	// N명의 회원의 집을 들릴 순서가 정해진 배열을 입력 받고
	// 회사 -> 회원 -> 집 순서로 거리를 계산하는 메서드
	private static void distance(int[][] sel) {
		int[] company = arr[0]; // 회사 좌표
		int[] home = arr[1]; // 집 좌표
		
		// 회사 -> 첫번째 회원까지 거리
		int cToN = Math.abs(company[0] - sel[0][0]) + Math.abs(company[1] - sel[0][1]);
		// 마지막 회원 -> 집까지 거리
		int nToH = Math.abs(home[0] - sel[sel.length-1][0]) + Math.abs(home[1] - sel[sel.length-1][1]);
		int total = cToN + nToH;
		for(int i = 0; i < sel.length-1; i++) {
			int distance = Math.abs(sel[i][0] - sel[i+1][0]) + Math.abs(sel[i][1] - sel[i+1][1]);
			total += distance;
		}
		ans = Math.min(ans, total);
	}

}
