import java.util.HashMap;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) { 
            answer = pass3(answer + 1); 
        } 
        return answer;
    }
    
    public int pass3(int num) {
        String testNum = Integer.toString(num);
        if(num % 3 == 0 || testNum.contains("3")) {
            return pass3(num + 1);
        } else {
            return num;
        }
    }
}