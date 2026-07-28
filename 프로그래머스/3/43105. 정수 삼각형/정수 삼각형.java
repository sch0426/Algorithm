import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = triangle.clone();

        // i: 꼭대기 층부터 몇층인지 의미
        // dp[i-1][j-1] 랑 dp[i-1][j] 중에 큰걸로 
        // j-1과 j
        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j - 1 < 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j >= triangle[i-1].length) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                
            }
        }
        Arrays.sort(dp[dp.length - 1]);
        answer = dp[dp.length - 1][dp[dp.length - 1].length - 1];
        return answer;
    }
}

