class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] temp = my_string.split(" ");
        int num1 = Integer.parseInt(temp[0]);
        for(int i = 1; i < temp.length; i += 2){
            int num2 = Integer.parseInt(temp[i+1]);
            if(temp[i].equals("+")){
                num1 += num2;
            } else if(temp[i].equals("-")){
                num1 -= num2;
            }
        }
        answer = num1;
        return answer;
    }
}