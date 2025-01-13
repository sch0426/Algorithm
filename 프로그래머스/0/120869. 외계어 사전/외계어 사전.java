class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(int i = 0; i < dic.length; i++) {
            int test = 0;
            for(int j = 0; j < spell.length; j++) {
                if(dic[i].contains(spell[j])) {
                    test++;
                }
            }
            if(test == spell.length) {
                return 1;
            }
        }
        return answer;
    }
}