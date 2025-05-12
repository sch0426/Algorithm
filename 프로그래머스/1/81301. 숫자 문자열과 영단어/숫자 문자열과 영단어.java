class Solution {
    public int solution(String s) {
        String answer = "";
        
        String[] temp = s.split("");
        String tempStr = "";
        
        for(int i = 0; i < temp.length; i++) {
            if(!temp[i].matches("[a-z]")) answer += temp[i];
            else {
                tempStr += temp[i];
                if(!findIntegerByS(tempStr).equals("null")) {
                    answer += findIntegerByS(tempStr);
                    tempStr = "";
                } else {
                    continue;
                }
            }
        }
        
        return Integer.parseInt(answer);
    }
    
    public String findIntegerByS (String tempString) {
        String s = "";
        switch(tempString) {
            case "zero":
                return "0";
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                s = "null";
                break;
        }
        return s;
    }
}