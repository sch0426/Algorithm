import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        int sum = 0;
        for(int i = 1; i <= list.size(); i++) {
            sum += list.get(i - 1);
            if(sum >= k) {
                answer = i;
                break;
            }
            
        }
        
        return answer;
    }
}