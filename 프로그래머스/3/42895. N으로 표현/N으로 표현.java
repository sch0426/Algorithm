import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if(N == number) {
            return 1;
        }
        
		// list의 인덱스는 N을 그 수만큼 사용한다는 것
		// N을 인덱스 수 만큼 사용했을때 나올 수 있는 결과값을 set에 저장
        List<Set<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i = 2; i <= 8; i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < i; j++) {
        		sb.append(N);
        	}
        	list.get(i).add(Integer.parseInt(sb.toString()));
        	
        	for(int j = 1; j < i; j++) {
        		int k = i - j;
        		
        		for(int a : list.get(j)) {
        			for(int b : list.get(k)) {
        				list.get(i).add(a + b);
        				list.get(i).add(a - b);
        				list.get(i).add(a * b);
        				if(b != 0) list.get(i).add(a / b);
        			}
        		}
        	}
        	if(list.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}