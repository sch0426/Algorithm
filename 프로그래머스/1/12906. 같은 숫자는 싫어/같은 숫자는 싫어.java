import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stackInt = new ArrayDeque<>();
        
        for(int num : arr) {
            if(stackInt.isEmpty()) {
                stackInt.addLast(num);
                continue;
            } else {
                if(stackInt.peekLast() == num) continue;
                else stackInt.addLast(num);
            }
        }
        
        int[] answer = new int[stackInt.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = stackInt.pollFirst();
        }
            
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}