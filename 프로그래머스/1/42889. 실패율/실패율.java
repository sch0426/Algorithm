import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] temp = new int[N + 2];
        HashMap<Integer, Double> hash = new HashMap<>();
        
        for(int stage : stages) {
            if(stage <= N) {
                temp[stage]++;
            }
        }
        
        // 각 스테이지별 실패율 계산
        int people = stages.length;
        for(int i = 1; i <= N; i++) {
            double fail = 0;
            if(people > 0) {
                fail = (double) temp[i] / people;
                people -= temp[i];
            }
            hash.put(i, fail);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int j = 1; j <= N; j++) {
            list.add(j);
        }
        
        Collections.sort(list, (a, b) -> {
            if (Double.compare(hash.get(b), hash.get(a)) == 0) {
                return a - b;
            }
            return Double.compare(hash.get(b), hash.get(a));
        });
        
        for(int k = 0; k < N; k++) {
            answer[k] = list.get(k);
        }
        
        return answer;
    }
}