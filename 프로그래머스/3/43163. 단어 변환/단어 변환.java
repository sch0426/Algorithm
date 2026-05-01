import java.util.*;

class Solution {
    class Node {
        String word;
        int cnt;
        
        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0));
        boolean[] v = new boolean[words.length];
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            if(curr.word.equals(target)) {
                return curr.cnt;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!v[i] && canChange(curr.word, words[i])) {
                    v[i] = true;
                    q.offer(new Node(words[i], curr.cnt + 1));
                }
            }
        }
        
        
        return answer;
    }
    
    
    
    // 두 단어가 하나만 다르면 return true
    private boolean canChange(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}