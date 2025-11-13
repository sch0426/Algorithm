import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[][] ladder = new int[100][100];
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int testNum = sc.nextInt();
            for(int i = 0; i < 100; i++) { // 사다리 초기화
            	for(int j = 0; j < 100; j++) {
                	ladder[i][j] = sc.nextInt();
                }
            }
            
            int x = 0, y = 99;
            for(int i = 0; i < 100; i++) { // 도착지점 찾기
            	if(ladder[y][i] == 2) {
                	x = i;
                    break;
                }
            }
            
            while(y > 0) {
                	if(x - 1 >= 0 && ladder[y][x - 1] == 1) {
                    	while(x - 1 >= 0 && ladder[y][x - 1] == 1) {
                            x--;
                        	ladder[y][x] = 0;
                        }
                    } else if(x + 1 < 100 && ladder[y][x + 1] == 1) {
                    	while(x + 1 < 100 && ladder[y][x + 1] == 1) {
                        	x++;
                            ladder[y][x] = 0;
                        }
                    } else if(y - 1 >= 0) {
                    	y--;
                        ladder[y][x] = 0;
                    }
            }
                
            System.out.println("#" + testNum + " " + x);
		}
	}
}