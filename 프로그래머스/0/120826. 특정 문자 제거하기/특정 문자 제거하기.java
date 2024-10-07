class Solution {
    public String solution(String my_string, String letter) {
        String[] answer = new String[my_string.length()];
        String[] temp = my_string.split(letter);
        return String.join("", temp);
    }
}