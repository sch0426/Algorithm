import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            hash.put(name[i], yearning[i]);
        }
        
        for(int j = 0; j < photo.length; j++) {
            int totalYearning = 0;
            for(String photoName : photo[j]) {
                totalYearning +=  hash.getOrDefault(photoName, 0);
            }
            answer[j] = totalYearning;
        }
        
        return answer;
    }
}