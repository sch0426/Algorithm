import java.util.*;
import java.io.*;

/*
 * N개의 문제중 2개 이상을 뽑는다.
 * 이때 문제 난이도의 합은 L이상 R이하이다
 * 추가로 가장 쉬운 난이도와 가장 어려운 난이도의 차이는 X이상이어야 한다
 * 문제 고르는 방법의 경우의 수를 구하라
 */
public class Main {
	static int N, L, R, X, ans, question[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		question = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			question[i] = Integer.parseInt(st.nextToken());
		}

		backtracking(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

		System.out.println(ans);
	}

	private static void backtracking(int idx, int cnt, int sum, int min, int max) {
		if (idx == N) {
			if (cnt >= 2 && sum >= L && sum <= R && max - min >= X) {
				ans++;
			}
			return;
		}

		int curr = question[idx];

		backtracking(idx + 1, cnt + 1, sum + curr, Math.min(min, curr), Math.max(max, curr));
		backtracking(idx + 1, cnt, sum, min, max);
	}

}
