import java.util.*;

class Solution {
    public String solution(String rsp) {
        String answer = "";
        // 가위 2 바위 0 보 5
        // 2 이기려면 0, 0 이기려면 5, 5 이기려면 2
        Map<String, String> map = new HashMap<>();
        map.put("2", "0");
        map.put("0", "5");
        map.put("5", "2");
        String[] temp = rsp.split("");
        for(int i = 0; i < temp.length; i++){
            answer += map.get(temp[i]);
        }
        return answer;
    }
}