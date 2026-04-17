import java.util.*;

class Solution {
    static class Node {
        String str;
        int weight;
        
        Node (String str, int weight) {
            this.str = str;
            this.weight = weight;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean flag = false;
        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }
        
        if (!flag) return 0;
        
        Queue<Node> q = new ArrayDeque<>();
        Map<String, Boolean> m = new HashMap<>();
        q.offer(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.str.equals(target)) {
                answer = now.weight;
                break;
            }
            
           
            for (String word : words) {
                int count = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != now.str.charAt(i)) count++;
                }
                if (count == 1 && !m.containsKey(word)) {
                    q.offer(new Node(word, now.weight + 1));
                    m.put(word, true);
                }
            }
        }
        
        return answer;
    }
}