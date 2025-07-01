import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int max = score.length - m;
        
        Arrays.sort(score);
        
        for(int i = 0; i < score.length / m; i++) {
            answer += score[max] * m;
            max -= m;
        }
        
        return answer;
    }
}