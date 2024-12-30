class Solution {
    public int solution(int num, int k) {
        String tempNum = "" + num;
        String tempK = "" + k;
        int answer = 0;
        
        String[] temp = tempNum.split("");
        
        for(int i = 0; i < temp.length; i++) {
            if(temp[i].equals(tempK)) {
                return ++i;
            } else {
                answer = -1;
            }
        }

        return answer;
    }
}