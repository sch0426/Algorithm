import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
            
        int cameraCnt = 0;
        int lastCameraPoint = -30001;
        
        for(int[] route : routes) {
            // 현재 검사중인 구간의 시작 위치가 마지막 카메라가 설치된 위치보다 크다면
            if(lastCameraPoint < route[0]) {
                lastCameraPoint = route[1];
                cameraCnt++;
            }
        }
        
        return cameraCnt;
    }
}