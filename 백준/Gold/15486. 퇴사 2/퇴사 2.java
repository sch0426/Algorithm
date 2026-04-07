import java.util.*;
import java.io.*;

public class Main {
	static int N, schedule[][], dp[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		schedule = new int[N + 2][2];
		dp = new int[N + 2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				schedule[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i = 1; i <= N + 1; i++) {
			max = Math.max(max, dp[i]);
			
			int end = i + schedule[i][0];
			if(end <= N + 1) {
				dp[end] = Math.max(dp[end], max + schedule[i][1]);
			}
		}	
		System.out.println(max);
	}

}
