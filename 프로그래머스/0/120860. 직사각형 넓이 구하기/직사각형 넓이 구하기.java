class Solution {
    public int solution(int[][] dots) {
        int width = 0;
        int height = 0;
        int answer = 0;
        for(int i = 1; i < dots.length; i++) {
            if(dots[0][0] - dots[i][0] != 0) {
                width = dots[0][0] - dots[i][0];
            }
            if(dots[0][1] - dots[i][1] != 0) {
                height = dots[0][1] - dots[i][1];
            }
        }
        answer = width * height;
        if(answer < 0) answer *= -1;
        return answer;
    }
}