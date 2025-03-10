import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split("");
        Arrays.sort(temp, Collections.reverseOrder());
        for(String str : temp) {
            answer += str;
        }
        
        return answer;
    }
}