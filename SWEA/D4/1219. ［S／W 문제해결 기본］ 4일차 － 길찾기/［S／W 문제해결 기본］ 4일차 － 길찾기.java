import java.util.*;
import java.io.*;

class Solution
{
    public static void dfs(int start, boolean[] visited, int[] arr1, int[] arr2) {
    	visited[start] = true;
        int start1 = arr1[start];
        int start2 = arr2[start];
        if(0 < start1 && start1 < 100 && !visited[start1]) {
        	dfs(start1, visited, arr1, arr2);
        }
        if(0 < start2 && start2 < 100 && !visited[start2]) {
        	dfs(start2, visited, arr1, arr2);
        }
    }
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            int[] idxArr = new int[len];
            boolean[] visited = new boolean[100];
            int[] arr1 = new int[100];
	        int[] arr2 = new int[100];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < len; i++) { // 배열 초기화
                int idx = Integer.parseInt(st.nextToken());
                int nextIdx = Integer.parseInt(st.nextToken());
                
            	if(arr1[idx] == 0) {
                	arr1[idx] = nextIdx;
                } else {
                	arr2[idx] = nextIdx;
                }
            }
			
            int answer = 0;
            dfs(0, visited, arr1, arr2);
            if(visited[99]) answer = 1;
            
			System.out.println("#" + tc + " " + answer);
		}
	}
}