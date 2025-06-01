class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            int match = arr1[i] | arr2[i];
            String toBinary = String.format("%" + n + "s", Integer.toBinaryString(match));
            toBinary = toBinary.replace("1", "#").replace("0", " ");
            answer[i] = toBinary;
        }
        
        return answer;
    }
}