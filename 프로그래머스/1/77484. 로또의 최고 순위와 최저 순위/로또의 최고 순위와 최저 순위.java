import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        
        for(int win_num : win_nums) {
            hash.put(win_num, 1);
        }
        
        for(int lotto : lottos) {
            if(lotto == 0) zeroCount++; 
            else if(hash.get(lotto) != null) count++;
        }
        
        int maxRank = getRank(count + zeroCount);
        int minRank = getRank(count);
        
        answer[0] = maxRank;
        answer[1] = minRank;
        
        return answer;
    }
    
    private int getRank(int matchCount) {
        switch(matchCount) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}