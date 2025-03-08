class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            if(divisorNum(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
    
    public int divisorNum(int num) {
        int sum = 0;
        for(int i = 1; i * i <= num; i++) {
            if(i * i == num) sum++;
            else if(num % i == 0) sum += 2;
        }
        
        return sum;
    }
    
}