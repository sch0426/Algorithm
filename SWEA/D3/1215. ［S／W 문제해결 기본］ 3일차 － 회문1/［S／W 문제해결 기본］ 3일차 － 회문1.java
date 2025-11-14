import java.util.*;
import java.io.*;

class Solution
{
    final static int BOARD_SIZE = 8;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int answer = 0;
			int len = Integer.parseInt(br.readLine()); // 회문 길이
            for(int i = 0; i < BOARD_SIZE; i++) { // 보드 초기화
                String line = br.readLine();
            	for(int j = 0; j < BOARD_SIZE; j++) {
                	board[i][j] = line.charAt(j);
                }
            }
            
            // 가로 탐색
            for(int y = 0; y < BOARD_SIZE; y++) { // 각 줄을 선택
            	for(int x = 0; x < BOARD_SIZE - len +1; x++) { // 가로 길이중에 회문 길이만큼 뽑는 경우의 수
                    boolean same = true;
                	for(int i = 0; i < len / 2; i++) { // 각 회문별로 앞뒤가 같은지 확인
                    	if(board[y][x + i] != board[y][x + len - i - 1]) {
                        	same = false;
                            break;
                        }
                    }
                    if(same) answer++;
                }
            }
            
            // 세로 탐색
            for(int x = 0; x < BOARD_SIZE; x++) { // 각 줄을 선택
            	for(int y = 0; y < BOARD_SIZE - len +1; y++) { // 세로 길이중에 회문 길이만큼 뽑는 경우의 수
                    boolean same = true;
                	for(int i = 0; i < len / 2; i++) { // 각 회문별로 앞뒤가 같은지 확인
                    	if(board[y + i][x] != board[y + len - i - 1][x]) {
                        	same = false;
                            break;
                        }
                    }
                    if(same) answer++;
                }
            }

			System.out.println("#" + test_case + " " + answer);
		}
	}
}