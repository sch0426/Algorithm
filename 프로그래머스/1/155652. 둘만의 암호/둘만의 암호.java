class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] skipToCharArray = skip.toCharArray();
        char[] sToCharArray = s.toCharArray();
        
        for(char sChar : sToCharArray) {
            for(int i = 0; i < index; i++) {
                sChar++;
                if(sChar > 122) sChar = 97;
                while(skip.contains(String.valueOf(sChar))) {
                    sChar++;
                    if(sChar > 122) sChar = 97;
                }
            }
            answer += sChar;
        }
        
        return answer;
    }
}