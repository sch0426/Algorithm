class Solution {
    public double solution(int balls, int share) {
        double answer = 0;
        double a = 1;
        double b = 1;
        for(int i = 0; i < balls - share; i++){
            a *= balls - i;
            b *= i + 1;
        }
        answer = a / b;
        return (int)answer;
    }
}