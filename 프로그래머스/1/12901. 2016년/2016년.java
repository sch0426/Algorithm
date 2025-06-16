class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] weeks = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        
        for(int i = 0; i < a - 1; i++) {
            totalDays += dayOfMonth[i];
        }
        
        totalDays += b - 1;
        
        answer = weeks[totalDays % 7];
        
        /*
            윤년 = 2월 29일까지 있는 년도 = 1년 366일
            31 29 31 30 31 30 31 31 30 31 30 31
        */
        
        return answer;
    }
}