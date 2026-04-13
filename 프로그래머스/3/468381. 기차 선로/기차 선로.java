class Solution {
    static int N, M, answer;
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};
    static int[] right = {1, 3, 4, 7};
    static int[] down = {2, 3, 4, 5};
    static int[] left = {1, 3, 5, 6};
    static int[] up = {2, 3, 6, 7};
    static int[][] v;
    public int solution(int[][] grid) {
        
        N = grid.length;
        M = grid[0].length;
        
        v = new int[N][M];
        dfs(0, 0, 1, 0, grid);
        
        return answer;
    }
    
    // 현재 행, 현재 열, 이전 모양, 진행중인 방향
    private static void dfs(int r, int c, int shape, int dir, int[][] map) {
        v[r][c]++;
        
        if(r == N - 1 && c == M - 1) {
            boolean isAvailable = false;
            if(map[N - 1][M - 1] == 1 && dir == 0) isAvailable = true;
            else if(map[N - 1][M - 1] == 2 && dir == 1) isAvailable = true;
            
            if(isAvailable && check(map)) answer++;
            
            v[r][c]--;
            return;
        }
        
        int nextDir = -1;
        
        // 1번
        if(shape == 1) {
            // 우
            if(dir == 0) nextDir = 0;
            // 좌
            else if(dir == 2) nextDir = 2;
        }
        // 2번
        else if(shape == 2) {
            // 상
            if(dir == 3) nextDir = 3;
            // 하
            else if(dir == 1) nextDir = 1;
        }
        // 3번
        else if(shape == 3) {
            nextDir = dir;
        }
        // 4번
        else if(shape == 4) {
            // 우
            if(dir == 0) nextDir = 3;
            // 하
            else if(dir == 1) nextDir = 2;
        }
        // 5번
        else if(shape == 5) {
            // 하
            if(dir == 1) nextDir = 0; 
            // 좌
            else if(dir == 2) nextDir = 3;
        }
        // 6번
        else if(shape == 6) {
            // 상
            if(dir == 3) nextDir = 0;
            // 좌
            else if(dir == 2) nextDir = 1;
        }
        // 7번
        else {
            // 상
            if(dir == 3) nextDir = 2; 
            // 우
            else if(dir == 0) nextDir = 1; 
        }
        
        if(nextDir != -1) {
            int nr = r + dr[nextDir];
            int nc = c + dc[nextDir];
            
            if(isIn(nr, nc) && map[nr][nc] != -1) {
                int nextShape = map[nr][nc];
                
                if(nextShape == 0) {
                    int[] canNextShape = null;
                    if(nextDir == 0) canNextShape = right;
                    else if(nextDir == 1) canNextShape = down;
                    else if(nextDir == 2) canNextShape = left;
                    else if(nextDir == 3) canNextShape = up;
                    
                    for(int s : canNextShape) {
                        map[nr][nc] = s;
                        dfs(nr, nc, s, nextDir, map);
                        map[nr][nc] = 0;
                    }
                } else { // 다음에 이미 길이 있으면
                    boolean isAvailable = false;
                    if(nextDir == 0) {
                        for(int s : right) {
                            if(s == nextShape) isAvailable = true;
                        }
                    } else if(nextDir == 1) {
                        for(int s : down) {
                            if(s == nextShape) isAvailable = true;
                        }
                    } else if(nextDir == 2) {
                        for(int s : left) {
                            if(s == nextShape) isAvailable = true;
                        }
                    } else if(nextDir == 3) {
                        for(int s : up) {
                            if(s == nextShape) isAvailable = true;
                        }
                    }
                    
                    if(isAvailable) {
                        if(nextShape == 3 && v[nr][nc] < 2) {
                            dfs(nr, nc, nextShape, nextDir, map);
                        } else if(nextShape != 3 && v[nr][nc] < 1) {
                            dfs(nr, nc, nextShape, nextDir, map);
                        }
                    }
                    
                }
            }
            
        }
        v[r][c]--;
    }
    
    private static boolean check(int[][] map) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] > 0) {
                    if(map[i][j] == 3 && v[i][j] != 2) return false;
                    if(map[i][j] != 3 && v[i][j] != 1) return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
    
}