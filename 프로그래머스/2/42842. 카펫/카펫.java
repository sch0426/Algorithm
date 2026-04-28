class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = null;
        
        // 가로 * 세로 = brown + yellow
        int area = brown + yellow;
        for(int width = yellow; width >= 1; width--) {
            // 나누어 떨어진거, 노란색으로 사각형 만든경우임
            if(yellow % width == 0 && (width + 2) * (area / (width + 2)) == area) {
                answer = new int[] {width + 2, area / (width + 2)};
                return answer;
            }
        }
        
        answer = new int[] {yellow + 2, 3};
        
        return answer;
    }
}