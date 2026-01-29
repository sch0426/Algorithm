import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 카드 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<String> card1 = new ArrayDeque<>();
			Deque<String> card2 = new ArrayDeque<>();
			if(N % 2 != 0) {
				for(int i = 0; i < N/2 + 1; i++) {
					card1.offer(st.nextToken());
				}
				for(int i = N/2 + 1; i < N; i++) {
					card2.offer(st.nextToken());
				}
			} else {
				for(int i = 0; i < N/2; i++) {
					card1.offer(st.nextToken());
				}
				for(int i = N/2; i < N; i++) {
					card2.offer(st.nextToken());
				}
			}

			sb.append("#" + tc + " ");
			int turn = 1;
			for(int i = 0; i < N; i++) {
				if(turn % 2 == 0) {
					sb.append(card2.poll()).append(" ");
				} else {
					sb.append(card1.poll()).append(" ");
				}
                turn++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
