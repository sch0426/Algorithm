class Solution {
    public int[] solution(long n) {
        String[] temp = String.valueOf(n).split("");
        int[] answer = new int[temp.length];
        
        for(int i = 0; i < temp.length; i++) {
            answer[i] = Integer.parseInt(temp[temp.length-i-1]);
        }
        
        return answer;
    }
}