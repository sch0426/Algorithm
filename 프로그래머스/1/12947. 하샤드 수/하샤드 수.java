class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String[] temp = String.valueOf(x).split("");
        int num = 0;
        for(String str : temp) {
            num += Integer.parseInt(str);
        }
        if(x % num != 0) answer = false;
        
        return answer;
    }
}