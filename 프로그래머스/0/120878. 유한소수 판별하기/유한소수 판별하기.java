class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int[] ab = {a, b};
        
        div(ab, 2);
        a = ab[0];
        b = ab[1];
        
        for(int i = 2; i <= b; i++) {
            if(i % 2 == 0 || i % 5 == 0) continue;
            else if(b % i == 0) answer = 2;
        }
        
        return answer;
    }
    
    public int[] div(int[] ab, int x) {
        if(x > ab[0] || x > ab[1]) return ab;
        else if(ab[0] % x == 0 && ab[1] % x == 0) {
            ab[0] /= x;
            ab[1] /= x;
            return div(ab, 2);
        } else {
            return div(ab, x + 1);
        }
    }
}