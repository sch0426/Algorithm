class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int isX = 0;
        int isNotX = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(x == s.charAt(i)) isX++;
            else isNotX++;
            if(isX == isNotX) {
                answer++;
                isX = 0;
                isNotX = 0;
                if(i + 1 < s.length()) x = s.charAt(i + 1);
            }
        }
        
        if(isX > 0 || isNotX > 0) {
            answer++;
        }
        
        return answer;
    }
}