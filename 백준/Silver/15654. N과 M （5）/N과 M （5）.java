import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] sel;
	static int[] arr;
	static boolean[] v;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M];
		arr = new int[N];
		v = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		permutation(0);
		
		System.out.println(sb);
	}
	
	// 1~N 자연수 중 M개를 뽑는 조합
	private static void permutation(int cnt) {
		if(cnt == M) {
			for (int i : sel) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[cnt] = arr[i];
			permutation(cnt + 1);
			v[i] = false;
		}

	}

}
