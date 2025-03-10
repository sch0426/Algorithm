class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long totalPrice = ((long)count * (2 * price + (count - 1) * price)) / 2;
        
        answer = money >= totalPrice ? 0 : totalPrice - money;
        
        return answer;
    }
}