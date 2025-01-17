import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(int[][] score) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < score.length; i++) {
            arr.add(score[i][0] + score[i][1]);
        }
        Collections.sort(arr, Comparator.reverseOrder());

        int[] answer = new int[arr.size()];
        for(int j = 0; j < arr.size(); j++) {
            answer[j] = arr.indexOf(score[j][0] + score[j][1]) + 1;
        }
        
        return answer;
    }
}