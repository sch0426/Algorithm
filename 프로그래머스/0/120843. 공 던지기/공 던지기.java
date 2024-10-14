class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int curr_index = 0;
        for(int i = 0; i < k-1; i++){
            curr_index += 2;
            if(curr_index >= numbers.length) {
                curr_index %= numbers.length;
            }
        }
        return answer = numbers[curr_index];
    }
}