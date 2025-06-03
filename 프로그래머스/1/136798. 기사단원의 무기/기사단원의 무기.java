class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numberArr = new int[number];
        
        for(int j = 1; j < number + 1; j++) {
            numberArr[j - 1] = divisor(j);
        }
        
        for(int num : numberArr) {
            if(num > limit) answer += power;
            else answer += num;
        }
        
        return answer;
    }
    
    public int divisor(int num) {
        int total = 0;
        
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                if(i * i == num) {
                    total++;
                } else {
                    total += 2;
                }
            }
        }
        
        return total;
    }
}