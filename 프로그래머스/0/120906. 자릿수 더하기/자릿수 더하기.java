class Solution {
    public int solution(int n) {
        String temp = String.valueOf(n);
        String[] templist = temp.split("");
        int answer = 0;
        for(int i = 0; i < templist.length; i++) {
            answer += Integer.parseInt(templist[i]);
        }
        return answer;
    }
}