class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 100;
        int linear = 0;
        for(int i = 0; i < array.length; i++){
            int sub = Math.abs(n - array[i]);
            
            if(sub < min) {
                min = sub;
                linear = array[i];
            } else if(sub == min) {
                if(array[i] < linear) {
                    linear = array[i];
                }
            }
        }
        answer = linear;
        return answer;
    }
}