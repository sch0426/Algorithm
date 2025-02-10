import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                arrList.add(arr[i]);
                cnt++;
            }
        }
        
        if(cnt == 0) return new int[] {-1};
        
        int[] answer = arrList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
}