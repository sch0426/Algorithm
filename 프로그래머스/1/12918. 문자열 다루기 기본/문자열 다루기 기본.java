import java.util.Arrays;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] temp = s.toCharArray();
        if(temp.length == 4 || temp.length == 6) {
            for(char c : temp) {
                if(!Character.isDigit(c)) answer = false;
            }
        } else {
            answer = false;
        }
        return answer;
    }
}