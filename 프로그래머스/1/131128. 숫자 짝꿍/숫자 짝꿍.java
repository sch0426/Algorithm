import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] xList = new int[10];
        int[] yList = new int[10];
        
        for(String x : X.split("")) {
            xList[Integer.parseInt(x)]++;
        }
        
        for(String y : Y.split("")) {
            yList[Integer.parseInt(y)]++;
        }
        
        for(int i = 9; i >= 0; i--) {
            while(xList[i] > 0 && yList[i] > 0) {
                answer.append(Integer.toString(i));
                xList[i]--;
                yList[i]--;
            }
        }
        
        if(answer.length() == 0) return "-1";
        if(answer.charAt(0) == '0') return "0";
        
        
        return answer.toString();
    }
}