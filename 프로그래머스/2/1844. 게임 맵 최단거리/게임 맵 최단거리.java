import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int n = maps.length;
        int m = maps[0].length;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        dq.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!dq.isEmpty()) {
            int[] curr = dq.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currDist = curr[2];
            
            if(currR == n - 1 && currC == m - 1) {
                answer = Math.min(answer, currDist);
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) continue;
                
                if(maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    dq.offer(new int[] {nr, nc, currDist + 1});   
                }
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}