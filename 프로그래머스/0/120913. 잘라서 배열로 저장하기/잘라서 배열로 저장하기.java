class Solution {
    public String[] solution(String my_str, int n) {
        int len = 0;
        int j = 0;
        if(my_str.length() % n != 0) {
            len = my_str.length() / n + 1;
        } else {
            len = my_str.length() / n;
        }
        String[] answer = new String[len];
        for(int i = 0; i < my_str.length(); i += n) {
            answer[j] = my_str.substring(i, Math.min(i + n, my_str.length()));
            j++;
        }
        return answer;
    }
}