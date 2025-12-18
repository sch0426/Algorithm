import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        // ext, sort_by를 index 값으로 변환
        int ext_idx = strToIdx(ext);
        int sort_by_idx = strToIdx(sort_by);
        
        List<int[]> list = new ArrayList<>();
        // val_ext 보다 작은 값들 추출
        for(int i = 0; i < data.length; i++) {
            if(data[i][ext_idx] < val_ext) list.add(data[i]);
        }
        
        // sort_by 로 오름차순 정렬
        answer = list.stream()
            .sorted(Comparator.comparingInt(a -> a[sort_by_idx]))
            .toArray(int[][]::new);
        
        return answer;
    }
    
    private int strToIdx(String str) {
        if(str.equals("code")) return 0;
        else if(str.equals("date")) return 1;
        else if(str.equals("maximum")) return 2;
        else return 3;
    }
}