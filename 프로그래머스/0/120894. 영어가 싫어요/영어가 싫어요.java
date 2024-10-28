class Solution {
    public long solution(String numbers) {
        String answer = "";
        String number = "";

        for (int i = 0; i < numbers.length(); i++) {
            number += numbers.charAt(i);

            switch (number) {
                case "zero":
                    answer += "0";
                    number = "";
                    break;
                case "one":
                    answer += "1";
                    number = "";
                    break;
                case "two":
                    answer += "2";
                    number = "";
                    break;
                case "three":
                    answer += "3";
                    number = "";
                    break;
                case "four":
                    answer += "4";
                    number = "";
                    break;
                case "five":
                    answer += "5";
                    number = "";
                    break;
                case "six":
                    answer += "6";
                    number = "";
                    break;
                case "seven":
                    answer += "7";
                    number = "";
                    break;
                case "eight":
                    answer += "8";
                    number = "";
                    break;
                case "nine":
                    answer += "9";
                    number = "";
                    break;
                default:
                    break;
            }
        }
        
        return Long.parseLong(answer);
    }
}
