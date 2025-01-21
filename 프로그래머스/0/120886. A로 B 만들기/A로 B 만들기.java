import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        String[] temp1 = before.split("");
        String[] temp2 = after.split("");
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        if(Arrays.equals(temp1, temp2)) answer = 1;
        else answer = 0;
        return answer;
    }
}