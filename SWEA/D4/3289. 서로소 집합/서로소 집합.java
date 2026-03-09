import java.util.*;
import java.io.*;

// SWEA 3289. 서로소 집합
public class Solution {
	static int N, M, input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			input = new int[N + 1];
			
			makeSets(); // 초기화 과정, 각자 본인을 루트로 설정한다
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int oper = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(oper == 0) { // 합집합
					union(a, b);
				} else {
					if(findSet(a) != findSet(b)) sb.append(0);
					else sb.append(1);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void makeSets() {
		for(int i = 1; i < N + 1; i++) {
			input[i] = i;
		}
	}

	static int findSet(int a) {
		if(input[a] == a) return a; // 나 자신이 루트이면 리턴
		
		return input[a] = findSet(input[a]);
	}
	
	static boolean union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		
		if(rootA == rootB) return false;
		
		input[rootA] = rootB;
		return true;
	}
	
}
