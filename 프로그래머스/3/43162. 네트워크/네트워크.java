class Solution {
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        v = new boolean[n];
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!v[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int start, int[][] map) {
        for(int i = 0; i < map[start].length; i++) {
            if(start == i) continue;
            if(map[start][i] == 1  && !v[i]) {
                v[i] = true;
                dfs(i, map);
            }
        }
        
    }
}