import java.util.Scanner;

class Solution
{
    public static int power(int N, int M, int answer) {
    	if(M == 0) return answer;
        return power(N, M - 1, answer * N);
    }
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int answer = 1;
            
            answer = power(N, M, answer);
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}