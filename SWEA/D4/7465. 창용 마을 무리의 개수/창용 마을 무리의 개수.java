import java.util.*;
import java.io.*;

// SWEA 7465. 창용 마을 무리의 개수
public class Solution {
	static int N, M, input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			input = new int[N + 1];
			
			makeSets(); // 본인을 루트로 초기화
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}     
			
			for(int i = 1; i < N + 1; i++) {
				findSet(i);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i < N + 1; i++) {
				set.add(input[i]);
			}
			
			sb.append("#" + tc + " ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	static void makeSets() {
		for(int i = 1; i < N + 1; i++) {
			input[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(a == input[a]) return a;
		
		return input[a] = findSet(input[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		input[aRoot] = bRoot;
		return true;
	}
	
}
