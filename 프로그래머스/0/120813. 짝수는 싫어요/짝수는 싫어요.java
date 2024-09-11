class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n+1)/2];
        //홀수 2*n + 1
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = 2*i + 1;
        }
        return answer;
    }
}