class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        answer = div(a, b, n);
        return answer;
    }
    
    public int div(int a, int b, int n) {
        if(a > n) return 0;
        return n / a * b + div(a, b, n / a * b + n % a);
    }
}