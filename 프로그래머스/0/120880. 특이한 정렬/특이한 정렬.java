import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] numlist, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int num : numlist) {
            arr.add(num);
        }
        
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int diffA = Math.abs(a - n);
                int diffB = Math.abs(b - n);
                
                if(diffA == diffB) {
                    return b - a;
                } else {
                    return diffA - diffB;
                }
            }
        });
        
        int[] answer = new int[arr.size()];
        for(int j = 0; j < answer.length; j++) {
            answer[j] = arr.get(j);
        }
        return answer;
    }
}