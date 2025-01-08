class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String num = "";
        String[] temp = my_string.split("");
        for(String str : temp) {
            if(str.matches("[0-9]")) {
                num += str;
            } else {
                if(!num.isEmpty()) {
                    answer += Integer.parseInt(num);
                    num = "";
                }
            }
        }
        if(!num.isEmpty()) {
            answer += Integer.parseInt(num);
        }
        return answer;
    }
}