class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] temp = my_string.split("");
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < i; j++){
                if(temp[i].equals(temp[j])) temp[i] = "";
            }
            answer += temp[i];
        }
        return answer;
    }
}