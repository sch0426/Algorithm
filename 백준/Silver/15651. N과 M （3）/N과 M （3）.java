import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] sel;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		permutation(0, 1);
		System.out.println(sb);
	}
	
	// 1~N 자연수 중 M개를 뽑는 조합
	private static void permutation(int cnt, int start) {
		if(cnt == M) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			sel[cnt] = i;
			permutation(cnt + 1, start);
		}

	}

}
