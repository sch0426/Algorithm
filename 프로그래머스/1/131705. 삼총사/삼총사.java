class Solution {
    public int answer = 0;
    public boolean[] visited;
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        backtracking(0, 0, 0, number);
        return answer;
    }
    
    public void backtracking(int index, int depth, int sum, int[] number) {
        if(depth == 3) {
            if(sum == 0) {
                answer++;
            }
            return;
        }
        
        for(int i = index; i < number.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, depth + 1, sum + number[i], number);
                visited[i] = false;
            }
        }
    }
}