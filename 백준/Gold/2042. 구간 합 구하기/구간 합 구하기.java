import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
	static long arr[], tree[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		tree = new long[N * 4];
		
		init(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			// 업데이트
			if(a == 1) {
				update(1, 1, N, b, c);
			// 구간 합 쿼리
			} else {
				sb.append(query(1, 1, N, b, (int)c)).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	/**
	 * 트리 구성(초기화) 
	 * @param node	: 현재 노드
	 * @param start	: 현재 노드가 관리하는 구간의 시작
	 * @param end	: 현재 노드가 관리하는 구간의 끝
	 * @return
	 */
	static long init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = arr[start];
		}
		int mid = (start + end) / 2;
		return tree[node] = init(node*2, start, mid) + init(node*2 + 1, mid + 1, end);
	}
	
	/**
	 * L-R 구간의 합을 구하는 쿼리
	 * @param node	: 현재 노드
	 * @param start	: 현재 노드가 관리하는 구간의 시작
	 * @param end	: 현재 노드가 관리하는 구간의 끝
	 * @param L		: 구하려는 구간의 시작 
	 * @param R		: 구하려는 구간의 끝
	 * @return
	 */
	static long query(int node, int start, int end, int L, int R) {
		if(L > end || R < start) return 0;
		if(L <= start && end <= R) return tree[node];
		int mid = (start + end) / 2;
		return query(node*2, start, mid, L, R) + query(node*2 + 1, mid + 1, end, L, R);
	}
	
	/**
	 * arr배열의 idx번째 값을 변경 
	 * @param node	: 현재 노드
	 * @param start	: 현재 노드가 관리하고 있는 구간의 시작
	 * @param end	: 현재 노드가 관리하고 있는 구간의 끝
	 * @param idx	: arr배열에서 변경할 인덱스 번호
	 * @param val	: 변경할 인덱스에 새로 업데이트할 값
	 */
	static void update(int node, int start, int end, int idx, long val) {
		if(start == end) {
			tree[node] = val;
			return;
		}
		int mid = (start + end) / 2;
		if(idx <= mid) {
			update(node*2, start, mid, idx, val);
		} else {
			update(node*2 + 1, mid + 1, end, idx, val);
		}
		tree[node] = tree[node*2] + tree[node*2 + 1];
	}
	
}
