import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        if(s.length() < 2) {
            return s;
        }
        String[] temp = s.split("");
        int[] ascii = new int[temp.length];        
        
        for(int i = 0; i < temp.length; i++){
            int tempNumber = temp[i].charAt(0);
            ascii[i] = tempNumber;
        }
        Arrays.sort(ascii);
        if(ascii[0] != ascii[1]) {
            answer += String.valueOf((char)ascii[0]);
        }
        for(int j = 1; j < ascii.length-1; j++){
            if(ascii[j] != ascii[j-1] && ascii[j] != ascii[j+1]){
                answer += String.valueOf((char)ascii[j]);
            }
        }
        if(ascii[ascii.length-1] != ascii[ascii.length-2]){
            answer += String.valueOf((char)ascii[ascii.length-1]);
        }
        return answer;
    }
}