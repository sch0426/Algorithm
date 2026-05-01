import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i = 0; i < n; i++) {
            int h = n - i; // 현재 위치 기준 내 이후에 있는 논문
            
            if(citations[i] >= h) {
                return h;
            }
        }
        
        return answer;
    }
}