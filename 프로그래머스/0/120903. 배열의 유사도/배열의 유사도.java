import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < s1.length; i++) {
            map.put(s1[i], s1[i]);
        }
        for(int j = 0; j < s2.length; j++) {
            if(map.containsKey(s2[j]) && map.get(s2[j]).equals(s2[j])) {
                answer += 1;
            }
        }
        return answer;
    }
}