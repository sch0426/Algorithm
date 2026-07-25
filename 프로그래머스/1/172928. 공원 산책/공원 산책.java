import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int w = park[0].length();
        int h = park.length;
        char[][] map = new char[h][w];
        int startR = 0;
        int startC = 0;
        
        for(int i = 0; i < h; i++) {
            String p = park[i];
            for(int j = 0; j < w; j++) {
                map[i][j] = p.charAt(j);
                if(map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        int[] dr = new int[] {0, 1, 0, -1};
        int[] dc = new int[] {1, 0, -1, 0};
        
        for(String r : routes) {
            StringTokenizer st = new StringTokenizer(r);
            String op = st.nextToken();
            int set = Integer.parseInt(st.nextToken());
            
            int d = 0;
            if(op.equals("S")) d = 1;
            else if(op.equals("W")) d = 2;
            else if(op.equals("N")) d = 3;
            
            int endR = startR + (dr[d] * set);
            int endC = startC + (dc[d] * set);
                
            if(endR < 0 || endC < 0 || endR >= h || endC >= w) continue;
            boolean isOk = true;
            int tempR = startR;
            int tempC = startC;
            for(int k = 0; k < set; k++) {
                int nr = tempR + dr[d];
                int nc = tempC + dc[d];
                
                if(map[nr][nc] == 'X') {
                    isOk = false;
                    break;
                }
                tempR = nr;
                tempC = nc;
            }
            if(isOk) {startR = endR; startC = endC;}
        }
        
        return new int[] {startR, startC};
    }
}