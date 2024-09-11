import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int MAX = 0;
        
        // 오름차순 정렬
        Arrays.sort(array);
        //array 배열에서 제일 큰 값 크기만큼 배열 생성
        MAX = array[array.length - 1];
        int[] MAX_arr = new int[MAX+1];
        
        //array의 index를 하나씩 읽어가며 해당 값을 index로 하는
        //MAX_arr 의 값을 1씩 증가시킨다
        //해당 index의 값이 array에서 몇번 나오는지 의미
        for(int i = 0; i < array.length; i++)
        {
            MAX_arr[array[i]] += 1;
        }
        
        int MAX_test = 0;
        //MAX_arr에서 최빈값 찾기
        for(int j = 0; j < MAX_arr.length; j++)
        {
            //배열에서 최대값 찾기
            //answer 보다 MAX_arr[j] 값이 크면 answer 값 대체
            if(MAX_test < MAX_arr[j])
            {
                MAX_test = MAX_arr[j];
                answer = j;
            }
            //최대값이 중복이면 answer = -1
            else if(MAX_test == MAX_arr[j])
                answer = -1;
        }
        return answer;
    }
}