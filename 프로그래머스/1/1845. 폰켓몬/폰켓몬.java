import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int choice = nums.length / 2;
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int phonketmon : nums) {
            if(answer == choice) break;
            else if(hash.get(phonketmon) == null) {
                hash.put(phonketmon, phonketmon);
                answer++;
            } else {
                continue;
            }
        }
        
        return answer;
    }
}