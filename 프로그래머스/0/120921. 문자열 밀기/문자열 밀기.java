import java.util.Arrays;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;

        if(A.equals(B)) return 0;
        else{
            int count = 0;
            for(int i = 0; i < A.length(); i++) {
                if(A.equals(B)) {
                    return count;
                }
                A = rightShift(A);
                count++;
            }
            return -1;
        }
    }
    
    public String rightShift(String str) {
        return str.charAt(str.length() - 1) + str.substring(0, str.length() - 1);
    }
}

/*
    오른쪽으로 한칸식 이동
    A -> B 변환 가능 시 이동횟수 리턴
    변환 불가능 시 -1 리턴
    
    1. 오른쪽으로 한칸씩 이동하는 로직 구현
    
    
    1 2 3 
    temp = list[1]
    list[1] = list[0]
    
*/