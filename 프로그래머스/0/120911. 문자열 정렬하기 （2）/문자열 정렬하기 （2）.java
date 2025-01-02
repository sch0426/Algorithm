import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        int[] numlist = new int[my_string.length()];
        String[] temp = my_string.split("");
        for(int i = 0; i < temp.length; i++) {
            if(temp[i].charAt(0) < 97) {
                numlist[i] = temp[i].charAt(0) + 32;
            } else {
                numlist[i] = temp[i].charAt(0);
            }
        }
        Arrays.sort(numlist);
        for(int j = 0; j < numlist.length; j++) {
            char ch = (char)numlist[j];
            answer += Character.toString(ch);
        }
        return answer;
    }
}