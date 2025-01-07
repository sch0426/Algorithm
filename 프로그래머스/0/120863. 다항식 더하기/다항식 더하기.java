class Solution {
    public String solution(String polynomial) {
        String[] polylist = polynomial.split(" \\+ ");
        int xtemp = 0;
        int numtemp = 0;
        String answer = "";
        
        for(String item : polylist) {
            if(item.contains("x")) {
                String temp = item.replace("x", "");
                if(temp.equals("")) {
                    xtemp += 1;
                } else {
                    xtemp += Integer.parseInt(temp);
                }
            } else {
                numtemp += Integer.parseInt(item);
            }
        }
             
        if(xtemp != 0 && numtemp != 0) {
            if(xtemp == 1) {
                answer = "x" + " + " + Integer.toString(numtemp);
            } else {
                answer += Integer.toString(xtemp) + "x" + " + " + Integer.toString(numtemp);
            }
        } else if(xtemp != 0) {
            if(xtemp == 1) {
                answer += "x";
            } else {
                answer += Integer.toString(xtemp) + "x";
            }
        } else if(numtemp != 0) {
            answer += Integer.toString(numtemp);
        }
        
        return answer;
    }
}