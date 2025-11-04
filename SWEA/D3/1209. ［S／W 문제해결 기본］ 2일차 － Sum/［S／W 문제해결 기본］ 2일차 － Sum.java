import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int testNum = sc.nextInt(); // 테스트 번호
            int highRow = 0; // 행 최대값
            int[] highCol = new int[100]; // 열 최대값
            int highRightCross = 0; // 오른쪽 대각선 최대값
            int highLeftCross = 0; // 왼쪽 대각선 최대값
            int answer = 0;
            for(int i = 0; i < 100; i++) { // 100 * 100 배열 저장
                int row = 0;
            	for(int j = 0; j < 100; j++) {
                	int current = sc.nextInt();
                    highCol[j] += current;
                    row += current;
                    if(i == j) highRightCross += current;
                    if(i + j == 100) highLeftCross += current;
                }
                if(row > highRow) highRow = row;
            }
            
            Arrays.sort(highCol);
            
            answer = Math.max(Math.max(highRow, highCol[99]), Math.max(highRightCross, highLeftCross));
            
            System.out.println("#" + testNum + " " + answer);
		}
	}
}