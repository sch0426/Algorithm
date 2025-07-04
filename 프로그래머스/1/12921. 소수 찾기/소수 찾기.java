class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 2; i <= n; i++) {
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(int num) {
        for(int j = 2; j <= Math.sqrt(num); j++) {
            if(num % j == 0) return false;
        }
        return true;
    }
}