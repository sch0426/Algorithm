import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			int maxTree = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxTree = Math.max(maxTree, tree[i]);
			}
			
			int even = 0;
			int odd = 0;
			for(int i = 0; i < N; i++) {
				even += (maxTree - tree[i]) / 2;
				odd += (maxTree - tree[i]) % 2;
			}
			
			while(even > odd + 1) {
				even -= 1;
				odd += 2;
			}
			
			if(even >= odd) {
				System.out.println("#" + tc + " " + even*2);
			} else {
				System.out.println("#" + tc + " " + (odd*2-1));
			}
			
		}
		
	}

}
