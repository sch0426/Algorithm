import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] ladder = new int[100][100];
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int minCnt = 10000;
			int tc = Integer.parseInt(br.readLine().trim());
            for(int i = 0; i < 100; i++) { // 사다리 초기화
                st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < 100; j++) {
                	ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int answer = 0;
            for(int i = 0; i < 100; i++) {
            	if(ladder[0][i] == 1) {
                    int x = i, y = 0, cnt = 0;
                	while(y < 99) {
                    	if(x + 1 < 100 && ladder[y][x + 1] == 1) {
                        	while(x + 1 < 100 && ladder[y][x + 1] == 1) {
                            	x++;
                                cnt++;
                            }
                        } else if(x - 1 >= 0 && ladder[y][x - 1] == 1) {
                        	while(x - 1 >= 0 && ladder[y][x - 1] == 1) {
                            	x--;
                                cnt++;
                            }
                        }
                        y++;
                        cnt++;
                    }
                    if(minCnt > cnt || (minCnt == cnt && answer < i)) {minCnt = cnt; answer = i;}
                }
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