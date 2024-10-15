class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] temp = my_string.split("a|e|i|o|u");
        for(int i = 0; i < temp.length; i++){
            answer += temp[i];
        }
        return answer;
    }
}