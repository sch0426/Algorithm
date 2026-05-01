import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        long start = 0;
        long end = 1_000_000_000L * 1_000_000_000L;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            
            for(int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
                if(cnt >= n) break;
            }
            
            if(cnt >= n) {
                answer = mid;
                end = mid - 1;
            } else if(cnt < n) {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}