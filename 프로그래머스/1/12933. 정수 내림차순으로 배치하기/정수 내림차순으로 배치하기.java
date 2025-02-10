import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String answer = "";
        String temp = Long.toString(n);
        String[] templist = temp.split("");
        Arrays.sort(templist);
        for(int i = templist.length - 1; i >= 0; i--) {
            answer += templist[i];
        }
        
        return Long.parseLong(answer);
    }
}