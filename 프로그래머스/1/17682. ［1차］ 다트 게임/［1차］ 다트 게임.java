class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int round = 0;
        String tempScore = "";
        
        int[] score = new int[3];
        
        for(int i = 0; i < dartResult.length(); i++) {
            char current = dartResult.charAt(i);
            
            if(current >= '0' && current <= '9') {
                tempScore += current;
            }
            
            if(current == 'S' || current == 'D' || current == 'T') {
                score[round] = Integer.parseInt(tempScore);
                tempScore = "";
                
                if(current == 'S') {
                    
                } else if(current == 'D') {
                    score[round] = score[round] * score[round];
                } else {
                    score[round] = score[round] * score[round] * score[round];
                }
                round++;
            } else if(current == '#' || current == '*') {
                if(current == '*') {
                    score[round - 1] *= 2;
                    if(round - 2 >= 0) {
                        score[round - 2] *= 2;
                    }
                } else {
                    score[round - 1] *= (-1);
                }
            }
        }
        
        for(int point : score) {
            answer += point;
        }
        
        return answer;
    }
}