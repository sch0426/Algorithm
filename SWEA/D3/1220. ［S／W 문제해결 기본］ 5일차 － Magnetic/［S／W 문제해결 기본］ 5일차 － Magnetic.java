import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int boardLen = Integer.parseInt(br.readLine());
            int[][] board = new int[boardLen][boardLen];
            for(int i = 0; i < boardLen; i++) { // 보드 초기화
                StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < boardLen; j++) {
                	board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;
            boolean meetedN = false;
            for(int i = 0; i < boardLen; i++) {
            	for(int j = 0; j < boardLen; j++) {
                	if(board[j][i] == 0) continue;
                    if(board[j][i] == 2 && meetedN) {
                    	answer++;
                        meetedN = false;
                    } else if(board[j][i] == 2) {
                    	continue;
                    }
                    if(board[j][i] == 1) meetedN = true;
                }
                meetedN = false;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}