import java.util.*;
import java.io.*;

class Solution
{
    final static int BOARD_SIZE = 100;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int tc = Integer.parseInt(br.readLine());
            for(int i = 0; i < BOARD_SIZE; i++) { // 보드 초기화
                String line = br.readLine();
            	for(int j = 0; j < BOARD_SIZE; j++) {
                	board[i][j] = line.charAt(j);
                }
            }
            
            int answer = 101;
            for(int len = BOARD_SIZE; len > 0; len--) { // 회문의 길이 경우의 수 100부터 1까지
            	for(int y1 = 0; y1 < BOARD_SIZE; y1++) { // 한줄씩
                	for(int x1 = 0; x1 + len < BOARD_SIZE + 1; x1++) { // 전체 길이중에 회문 길이만큼 고를 수 있는 경우의 수
                        boolean isSame = true;
                    	for(int i = 0; i < len / 2; i++) { // 앞뒤로 똑같은지 판별
                        	if(board[y1][x1 + i] != board[y1][x1 + len - i - 1]) {
                            	isSame = false;
                                break;
                            }
                        }
                        if(isSame) {answer = len; break;}
                    }
                    if(answer != 101) break;
                }
                if(answer != 101) break;
                
                // 세로의 경우
                for(int x2 = 0; x2 < BOARD_SIZE; x2++) {
                	for(int y2 = 0; y2 + len < BOARD_SIZE + 1; y2++) {
                        boolean isSame = true;
                    	for(int j = 0; j < len / 2; j++) {
                        	if(board[y2 + j][x2] != board[y2 + len - j - 1][x2]) {
                            	isSame = false;
                                break;
                            }
                        }
                        if(isSame) {answer = len; break;}
                    }
                    if(answer != 101) break;
                }
                if(answer != 101) break;
            }
            
            System.out.println("#" + tc + " " + answer);
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
		}
	}
}