import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] sel;
	static boolean[] v;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		v = new boolean[N + 1];
		permutation(0);
	}
	
	// 1~N 자연수 중 M개를 뽑는 경우의 수 중복 x 순서 다르면 다른 경우의 수로 봄
	private static void permutation(int cnt) {
		if(cnt == M) {
			for (int i : sel) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[cnt] = i;
			permutation(cnt + 1);
			v[i] = false;
		}
		
	}

}
