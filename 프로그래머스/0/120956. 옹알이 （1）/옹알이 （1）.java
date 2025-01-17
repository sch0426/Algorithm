class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] say = {"aya", "ye", "woo", "ma"};
        
        for(String str : babbling) {
            for(String sound : say) {
                if(str.contains(sound)) {
                    str = str.replace(sound, " ");
                }
            }
            str = str.replace(" ", "");
            if(str.equals("")) answer++;
        }
        
        return answer;
    }
}