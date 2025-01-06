class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < keyinput.length; i++) {
            if(keyinput[i].equals("left")) {
                x -= 1;
            } else if(keyinput[i].equals("right")) {
                x += 1;
            } else if(keyinput[i].equals("up")) {
                y += 1;
            } else {
                y -= 1;
            }

            if(Math.abs(x) > board[0] / 2 && x < 0) {
                x = board[0] / 2 * -1;
            } else if(Math.abs(x) > board[0] / 2 && x >= 0) {
                x = board[0] / 2;
            }

            if(Math.abs(y) > board[1] / 2 && y < 0) {
                y = board[1] / 2 * -1;
            } else if(Math.abs(y) > board[1] / 2 && y >= 0) {
                y = board[1] / 2;
            }
        }

        int[] answer = {x, y};
        return answer;
    }
}
