class Solution {
    public String solution(String my_string) {
        String[] answer = new String[my_string.length()];
        String[] temp = my_string.split("");
        for(int i = 0; i < my_string.length(); i++)
            answer[i] = temp[my_string.length() - 1 - i];
        return String.join("", answer);
    }
}