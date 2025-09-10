class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] set = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            set[i] = 1;
        }
        
        for(int lostIdx : lost) {
            set[lostIdx]--;
        }
        
        for(int reserveIdx : reserve) {
            set[reserveIdx]++;
        }

        for(int i = 1; i <= n; i++) {
            if(set[i] >= 2) {
                if(i > 1 && set[i - 1] == 0){
                    set[i - 1]++;
                    set[i]--;
                } else if(i < n && set[i + 1] == 0) {
                    set[i + 1]++;
                    set[i]--;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(set[i] >= 1) answer++;
        }
        
        return answer;
    }
}