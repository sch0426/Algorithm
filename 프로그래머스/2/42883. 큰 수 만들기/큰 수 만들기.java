import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < number.length(); i++) {
            char curr = number.charAt(i);
            
            while(k > 0 && sb.length() > 0) {
                int lastIdx = sb.length() - 1;
                int last = sb.charAt(lastIdx);
                
                if(last < curr) {
                    sb.deleteCharAt(lastIdx);
                    k--;
                } else {
                    break;
                }
            }
            sb.append(curr);
        }
        
        while(k > 0) {
            int lastIdx = sb.length() - 1;
            sb.deleteCharAt(lastIdx);
            k--;
        }
        
        return sb.toString();
    }
}