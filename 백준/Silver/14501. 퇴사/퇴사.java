import java.util.*;
import java.io.*;

// BOJ 14501. 퇴사
public class Main {
	static int N, arr[][], dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N];
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, work(i, i + arr[i][0]));
		}

		System.out.println(ans);
	}
	
	// 일 시작일, 일 끝나는 일
	private static int work(int startDay, int endDay) {
		if(endDay > N) return 0;
		else if(endDay == N) return arr[startDay][1];
		
		// i일차에 일을 시작했어, 그러면 그 일이 끝나고 그 뒤에 있는 일중에 하고싶은 일을 시작해
		// 그중에 제일 큰 값을 준 애를 dp에 갱신하는거임
		for(int i = endDay; i < N; i++) {
			dp[startDay] = Math.max(dp[startDay], arr[startDay][1] + work(i, i + arr[i][0]));
		}
		
		return dp[startDay];
	}

}
