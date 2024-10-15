import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String temp_str = my_string.replaceAll("[a-z]", "");
        String[] temp_arr = temp_str.split("");
        int [] answer = new int[temp_arr.length];
        for(int i = 0; i < temp_arr.length; i++){
            answer[i] += Integer.parseInt(temp_arr[i]);
        }
        Arrays.sort(answer);
        return answer;
    }
}