import java.util.ArrayList;

class Solution {
    public String[] solution(String[] quiz) {
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < quiz.length; i++) {
            String[] q = quiz[i].split(" ");
            int left = Integer.parseInt(q[0]);
            String operator = q[1];
            int right = Integer.parseInt(q[2]);
            int result = Integer.parseInt(q[4]);
            
            boolean isCorrect;
            if(operator.equals("+")) {
                isCorrect = left + right == result;
            } else {
                isCorrect = left - right == result;
            }
            
            if(isCorrect) {
                temp.add("O");
            } else {
                temp.add("X");
            }
        }
        String[] answer = new String[temp.size()];
        for(int j = 0; j < answer.length; j++) {
            answer[j] = temp.get(j);
        }
        return answer;
    }
}