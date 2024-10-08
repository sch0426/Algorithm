import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] temp = emergency.clone();
        int[] answer = new int[emergency.length];
        Arrays.sort(emergency);
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp.length; j++){
                if(temp[i] == emergency[j]){
                    answer[i] = temp.length - j;
                    break;
                }
            }
        }
        return answer;
    }
}