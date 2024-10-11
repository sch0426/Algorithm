class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] temp = my_string.toCharArray();
        for(int i = 0; i < temp.length; i++){
            if(temp[i] < 91) {
                answer += (char)(int)(temp[i] + 32);
            } else {
                answer += (char)(int)(temp[i] - 32);
            }
        }
        return answer;
    }
}