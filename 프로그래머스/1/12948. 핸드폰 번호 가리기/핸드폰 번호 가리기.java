class Solution {
    public String solution(String phone_number) {
        if(phone_number.length() == 4) return phone_number;
        
        String answer = "";
        
        String lastString = phone_number.substring(phone_number.length() - 4);
        String frontString = "";
        for(int i = 0; i < phone_number.length() - 4; i++) {
            frontString += "*";
        }
        
        answer = frontString + lastString;
        return answer;
    }
}