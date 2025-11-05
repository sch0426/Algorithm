import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int[] dirI = {0, 1, 0, -1}; // i 값 이동방향
        int[] dirJ = {1, 0, -1, 0}; // j 값 이동방향

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = sc.nextInt(); // 달팽이 크기
            int[][] arr = new int[test][test]; // 달팽이 크기 배열
            int i = 0; // 행
            int j = 0; // 열
            int cnt = 1; // 입력값
            int dir = 0; // 방향값 (우, 하, 좌, 상)
            
            arr[i][j] = cnt;
            cnt++;
            
            while(cnt <= test * test) {
            	int ni = i + dirI[dir];
                int nj = j + dirJ[dir];
                if(0 <= ni && ni < test && 0 <= nj && nj < test && arr[ni][nj] == 0) {
                	arr[ni][nj] = cnt;
                    cnt++;
                    i = ni;
                    j = nj;
                } else {
                	dir = (dir + 1) % 4;
                }
            }
            
            System.out.println("#" + test_case);
            for(i = 0; i < test; i++) {
            	for(j = 0; j < test; j++) {
                	System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
		}
	}
}