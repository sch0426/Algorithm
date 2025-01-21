class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int l = i; l <= j; l++) {
            String temp = Integer.toString(l);
            String[] temp2 = temp.split("");
            for(String temp3 : temp2) {
                if(temp3.equals(Integer.toString(k))) answer++;
            }
        }
        return answer;
    }
}