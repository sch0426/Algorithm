import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int PEOPLE = 100;
	static int N;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 10개의 테스트 케이스가 주어진다
		for(int tc = 1; tc <= 10; tc++) {
			// 입력 받는 데이터의 길이와 시작점이 주어진다
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int START = Integer.parseInt(st.nextToken());
			list = new ArrayList[PEOPLE + 1];
			for(int i = 1; i < PEOPLE + 1; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N / 2; i++) {
				list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			sb.append("#" + tc + " ").append(bfs(START)).append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[PEOPLE + 1];
		// 시작지점 넣기
		visited[start] = true;
		q.offer(start);
		int max = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			int currStepMax = 0;
			for(int step = 0; step < size; step++) {
				// 큐에서 하나 꺼내고
				int tmp = q.poll();
				currStepMax = Math.max(currStepMax, tmp);
				// 해당 노드가 가리키고 있는 노드들
				for(int i : list[tmp]) {
					if(!visited[i]) {
						visited[i] = true;
						q.offer(i);
					}
				}
			}
			max = currStepMax;
		}
		
		return max;
		
	}

}
