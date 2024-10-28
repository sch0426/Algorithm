class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        String[] temp = cipher.split("");
        for(int i = code-1; i < temp.length; i += code) {
            answer += temp[i];
        }
        return answer;
    }
}