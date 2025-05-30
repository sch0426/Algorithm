import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int k, int[] score) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] temp = new int[k];
        int count = 0;

        for(int i = 0; i < score.length; i++) {
            if(count < k) {
                temp[count] = score[i];
                count++;
            } else if(score[i] > temp[0]) {
                temp[0] = score[i];
            }
            
            Arrays.sort(temp, 0, count);
            answer.add(temp[0]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}