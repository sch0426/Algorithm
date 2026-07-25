import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int count = 0;
        int right = people.length - 1;
        int left = 0;
        while(count < people.length) {
            if(people[right] + people[left] <= limit) {
                count += 2;
                answer++;
                left++;
                right--;
            } else {
                count++;
                answer++;
                right--;
            }
        }
        
        return answer;
    }
}