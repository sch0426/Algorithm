import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville) {
            pq.offer(scov);
        }
        
        boolean isAvailable = false;
        while(!pq.isEmpty()) {
            int min = pq.peek();
            if(min >= K) {
                isAvailable = true;    
                break;
            }
            
            if(pq.size() == 1) break;
            
            int first = pq.poll();
            int second = pq.poll();
            int mix = first + second * 2;
            pq.offer(mix);
            answer++;
        }
        
        return isAvailable ? answer : -1;
    }
}