class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        String[] temp = s.split("");
        
        for(int i = 0; i < temp.length; i++) {
            if(temp[i].equals(" ")) {
                index = 0;
            } else {
                if(index % 2 == 0) {
                    temp[i] = temp[i].toUpperCase();
                } else {
                    temp[i] = temp[i].toLowerCase();
                }
                index++;
            }
        }
        answer += String.join("", temp);
        
        return answer;
    }
}