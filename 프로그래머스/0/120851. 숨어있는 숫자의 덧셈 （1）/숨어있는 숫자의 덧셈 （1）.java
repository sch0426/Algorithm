class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] temp = my_string.split("");
        for(int i = 0; i < temp.length; i++){
            switch(temp[i]){
                case "1" :
                case "2" :
                case "3" :
                case "4" :
                case "5" :
                case "6" :
                case "7" :
                case "8" :
                case "9" :
                    answer += Integer.parseInt(temp[i]);
                    break;
            }
        }
        return answer;
    }
}