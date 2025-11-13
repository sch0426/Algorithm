import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = Integer.parseInt(br.readLine());
            String param = br.readLine();
            String quiz = br.readLine();
            int answer = 0;
            for(int i = 0; i <= quiz.length() - param.length(); i++) {
                boolean same = true;
            	for(int j = 0; j < param.length(); j++) {
                	if(quiz.charAt(i + j) != param.charAt(j)) {same = false; break;}
                }
                if(same) answer++;
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