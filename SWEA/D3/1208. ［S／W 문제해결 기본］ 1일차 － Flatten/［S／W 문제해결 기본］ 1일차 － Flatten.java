import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] box = new int[100]; // 가로길이 100으로 고정
        
		for(int test_case = 1; test_case <= 10; test_case++) // 테스트케이스 10개로 고정
		{
			int dumpCnt = sc.nextInt(); // 덤프횟수
            
            for(int i = 0; i < 100; i++) {
            	box[i] = sc.nextInt();
            }
            
            for(int i = 0 ; i < dumpCnt; i++) {
            	int maxIdx = 0, minIdx = 0;
                for(int j = 1; j < 100; j++) {
                	if(box[j] > box[maxIdx]) maxIdx = j;
                    if(box[j] < box[minIdx]) minIdx = j;
                }
                if(box[maxIdx] - box[minIdx] <= 1) break;
                box[maxIdx]--;
                box[minIdx]++;
            }
            
            int max = box[0], min = box[0];
            for(int i = 1; i < 100; i++) {
            	if(box[i] > max) max = box[i];
                if(box[i] < min) min = box[i];
            }
            int answer = max - min;
            System.out.println("#" + test_case + " " + answer);
		}
	}
}