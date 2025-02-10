class Solution {
    public long solution(long n) {
        long answer = 0;
        double sqrt = Math.sqrt(n);
        long temp = (long) sqrt;
        
        if(Math.pow(temp, 2) == n) answer = (long) Math.pow(temp + 1, 2);
        else answer = -1;
            
        return answer;
    }
}