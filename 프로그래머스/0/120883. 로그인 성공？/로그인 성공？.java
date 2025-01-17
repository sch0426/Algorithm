class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for(String[] schema : db) {
            if(id_pw[0].equals(schema[0]) && id_pw[1].equals(schema[1])) {
                answer = "login";
                break;
            } else if(id_pw[0].equals(schema[0])) {
                answer = "wrong pw";
                break;
            }
        }

        return answer;
    }
}