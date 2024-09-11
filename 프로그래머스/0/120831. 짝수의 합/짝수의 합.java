class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 0; i <= n/2; i++)
        {
            answer += 2*i;
        }
        
        return answer;
    }
}