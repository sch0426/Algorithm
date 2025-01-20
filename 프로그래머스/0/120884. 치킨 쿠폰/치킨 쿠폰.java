class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        
        while(coupon >= 10) {
            int changeChicken = coupon / 10;
            
            answer += changeChicken;
            coupon = changeChicken + (coupon % 10);
        }
        
        return answer;
    }
}