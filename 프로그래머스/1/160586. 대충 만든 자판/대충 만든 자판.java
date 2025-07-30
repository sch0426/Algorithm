class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int MAX = Integer.MAX_VALUE;
        
        int[] keyboard = new int[26];
        for(int i = 0; i < 26; i++) {
            keyboard[i] = MAX;
        }
        
        // 각 알파벳 별 최소 누름횟수
        for(String key : keymap) {
            for(int j = 0; j < key.length(); j++) {
                char c = key.charAt(j);
                int index = c - 'A';
                keyboard[index] = Math.min(keyboard[index], j + 1);
            }
        }
        
        // 총 누름횟수 계산
        for(int k = 0; k < targets.length; k++) {
            String target = targets[k];
            int count = 0;
            
            for(int l = 0; l < target.length(); l++) {
                if(keyboard[target.charAt(l) - 'A'] == MAX) {
                    count = -1;
                    break;
                }
                else count += keyboard[target.charAt(l) - 'A'];
            }
            
            answer[k] = count;
        }
        
        return answer;
    }
}