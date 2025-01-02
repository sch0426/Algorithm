class Solution {
    public int solution(String str1, String str2) {
        String[] listStr1 = str1.split("");
        String[] listStr2 = str2.split("");
        int answer = 2;
        // 1번과 2번의 i번째 단어가 같다면 검증 시작
        // i번째부터 2번의 길이만큼 1번과 2번이 모두 같은지 확인
        // 만약 같다면 count를 1씩 증가
        // 검사가 끝나고 count가 2번의 길이와 같다면 answer = 1 다르면 answer = 2
        for(int i = 0; i <= listStr1.length - listStr2.length; i++) {
            if(listStr1[i].equals(listStr2[0])) {
                int count = 0;
                for(int j = 0; j < listStr2.length; j++) {
                    if(listStr1[j + i].equals(listStr2[j])) {
                        count++;
                    }
                }
                if(count == str2.length()) {
                    return 1;
                }
            }
        }
        return answer;
    }
}