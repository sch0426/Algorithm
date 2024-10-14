class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i < 11; i++){
            if(factorial(i) > n){
                return answer = i-1;
            } else if(factorial(i) == n){
                return answer = i;
            }
        }
        return answer;
    }
    public int factorial(int num) {
        if(num <= 1) return num;
        return num * factorial(num - 1);
    }
}