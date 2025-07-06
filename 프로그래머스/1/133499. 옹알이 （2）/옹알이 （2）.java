class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String regex = "^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$";
        
        for (String babb : babbling) {
            if (babb.matches(regex)) answer++;
        }
        
        return answer;
    }
}