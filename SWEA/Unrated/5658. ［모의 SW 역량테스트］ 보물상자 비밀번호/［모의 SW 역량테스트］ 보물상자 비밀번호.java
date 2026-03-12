import java.util.*;
import java.io.*;

// SWEA 5658. 보물상자 비밀번호
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String[] lock = br.readLine().split("");
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());

			for(int step = 0; step < N / 4; step++) {
				// 시계방향으로 한칸 회전
				String temp = lock[N - 1];
				for (int i = N - 1; i > 0; i--) {
					lock[i] = lock[i - 1];
				}
				lock[0] = temp;
				// ------
				for (int i = 0; i < N; i += N / 4) {
					String currNum = "";
					for (int j = i; j < i + (N / 4); j++) {
						currNum += lock[j];
					}
					set.add(currNum);
				}
			}

			List<String> list = new ArrayList<>(set);
			String xNum = list.get(K - 1);
			sb.append("#" + tc + " ").append(Long.parseLong(xNum, 16)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
