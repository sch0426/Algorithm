import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] aList = {1, 2, 3, 4, 5};
        int[] bList = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cList = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 0;
        int b = 0;
        int c = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == aList[i % aList.length]) a++;
            if(answers[i] == bList[i % bList.length]) b++;
            if(answers[i] == cList[i % cList.length]) c++;
        }
        
        int maxScore = Math.max(a, Math.max(b, c));
        
        ArrayList<Integer> result = new ArrayList<>();
        if(maxScore == a) result.add(1);
        if(maxScore == b) result.add(2);
        if(maxScore == c) result.add(3);
        
        answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}