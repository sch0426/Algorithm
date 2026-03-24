import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int minTree[], maxTree[], arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정수 수
		M = Integer.parseInt(st.nextToken()); // 구간 수
		arr = new int[N];
		minTree = new int[4 * N];
		maxTree = new int[4 * N];
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a;
		}
		minBuild(1, 0, N - 1);
		maxBuild(1, 0, N - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int min = minQuery(1, 0, N - 1, a - 1, b - 1);
			int max = maxQuery(1, 0, N - 1, a - 1, b - 1);
			sb.append(min + " " + max).append("\n");
		}
		System.out.println(sb);
	}

	static void minBuild(int node, int start, int end) {
		if (start == end) {
			minTree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		minBuild(node * 2, start, mid);
		minBuild(node * 2 + 1, mid + 1, end);
		minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
	}

	static void maxBuild(int node, int start, int end) {
		if (start == end) {
			maxTree[node] = arr[start];
			return;
		}
		int mid = (start + end) / 2;
		maxBuild(node * 2, start, mid);
		maxBuild(node * 2 + 1, mid + 1, end);
		maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
	}

	static int minQuery(int node, int start, int end, int L, int R) { // 쿼리 최솟값
		if (R < start || end < L)
			return Integer.MAX_VALUE;
		if (L <= start && end <= R)
			return minTree[node];
		int mid = (start + end) / 2;
		return Math.min(minQuery(2 * node, start, mid, L, R), minQuery(2 * node + 1, mid + 1, end, L, R));
	}

	static int maxQuery(int node, int start, int end, int L, int R) { // 쿼리 최댓값
		if (R < start || end < L)
			return Integer.MIN_VALUE;
		if (L <= start && end <= R)
			return maxTree[node];
		int mid = (start + end) / 2;
		return Math.max(maxQuery(2 * node, start, mid, L, R), maxQuery(2 * node + 1, mid + 1, end, L, R));
	}

}
