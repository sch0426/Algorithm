import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;

		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		boolean[] v = new boolean[100001];
		q.offer(new int[] { subin, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currTime = curr[1];
			
			v[currX] = true;
			
			if(currTime >= ans) continue;
			
			if (currX == sister) {
				ans = Math.min(ans, currTime);
			} else {
				if(currX * 2 <= 100000 && !v[currX * 2]) q.offer(new int[] { currX * 2, currTime });
				if(currX + 1 <= 100000 && !v[currX + 1])q.offer(new int[] { currX + 1, currTime + 1 });
				if(currX - 1 >= 0 && !v[currX - 1])q.offer(new int[] { currX - 1, currTime + 1 });
			}
		}
		
		System.out.println(ans);
	}

}
