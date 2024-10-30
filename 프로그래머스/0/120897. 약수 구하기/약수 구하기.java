import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                temp.add(i);
            }
        }
        answer = new int[temp.size()];
        for(int j = 0; j < temp.size(); j++){
            answer[j] = temp.get(j);
        }
        return answer;
    }
}