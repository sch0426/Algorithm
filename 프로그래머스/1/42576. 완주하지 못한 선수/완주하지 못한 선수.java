import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String complete : completion) {
            hash.put(complete, hash.getOrDefault(complete, 0) + 1);
        }
        
        for(String name : participant) {
            hash.put(name, hash.getOrDefault(name, 0) - 1);
        }
        
        for(String name : participant) {
            if(hash.get(name) < 0) answer = name;
        }
        

        return answer;
    }
}