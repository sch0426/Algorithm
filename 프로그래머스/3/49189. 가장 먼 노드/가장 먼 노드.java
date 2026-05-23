import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int N = 0;
        
        for(int i = 0; i < edge.length; i++) {
            for(int node : edge[i]) {
                N = Math.max(N, node);
            }
        }
        
        List<Integer>[] adj = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++) {
            int n1 = edge[i][0] - 1;
            int n2 = edge[i][1] - 1;
            adj[n1].add(n2);
            adj[n2].add(n1);
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        q.offer(0);
        
        while(!q.isEmpty()) {
            int size = q.size();
            answer = size;
            for(int step = 0; step < size; step++) {
                int curr = q.poll();

                for(int next : adj[curr]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        
        return answer;
    }
}