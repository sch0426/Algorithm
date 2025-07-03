class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = section[0] - 1;
        
        for(int i = 0; i < section.length; i++) {
            if(section[i] > idx) {
                answer++;
                idx = section[i] + m - 1;
            }
        }
        
        
        return answer;
    }
}