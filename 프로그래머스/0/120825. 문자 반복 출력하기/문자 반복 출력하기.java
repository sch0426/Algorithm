class Solution {
    public String solution(String my_string, int n) {
        String[] answer = new String[my_string.length()*n];
        String[] temp = my_string.split("");
        int num = 0;
        for(int i = 0; i < my_string.length(); i++){
            String tempChar = temp[i];
            for(int j = 0; j < n; j++){
                answer[num] = tempChar;
                num++;
            }
        }
        return String.join("", answer);
    }
}