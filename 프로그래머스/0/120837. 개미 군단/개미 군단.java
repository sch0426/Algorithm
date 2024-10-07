//장군 5, 병정 3, 일 1
//사냥감 체력 hp 최소한의 병력 

class Solution {
    public int solution(int hp) {
        int answer = 0;
        int a = hp / 5;
        int b = hp % 5 / 3;
        int c = hp % 5 % 3 / 1;
        answer = a + b + c;
        return answer;
    }
}