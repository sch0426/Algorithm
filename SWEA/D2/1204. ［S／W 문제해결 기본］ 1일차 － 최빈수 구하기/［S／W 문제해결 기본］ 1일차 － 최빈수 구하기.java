import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] arr = new int[101];
            int max = 0;
            int maxIdx = 0;
            int testNum = sc.nextInt();
            
            for(int i = 0; i < 1000; i++) {
            	arr[sc.nextInt()]++;
            }
            for(int j = 1; j < 101; j++) {
            	if(max <= arr[j]) {
                	max = arr[j];
                    maxIdx = j;
                }
            }
            
            System.out.println("#" + testNum + " " + maxIdx);
		}
	}
}