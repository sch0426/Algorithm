import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] gArr, iArr;
	static int M = 9;
	static int winCnt, loseCnt;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			boolean[] picked = new boolean[2*M+1];
			gArr = new int[M];
			iArr = new int[M];
			
			winCnt = loseCnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				gArr[i] = Integer.parseInt(st.nextToken());
				picked[gArr[i]] = true;
			} // 규영이의 카드를 저장하고 카드번호에 선택여부 true 처리
			
			// 인영이의 카드 리스트 만들기
			for(int i = 1, j=0; i < 2*M+1; i++) {
				if(!picked[i]) iArr[j++] = i;
			}
			
			permutation(0, new boolean[M], 0, 0);
			System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
		}
		
	}
	
	// 인영이의 카드의 순서를 결정하는 메소드
	public static void permutation(int cnt, boolean[] isSelected, int gScore, int iScore) {
		
		if(cnt == M) {
			if(gScore > iScore) ++winCnt;
			else ++loseCnt;
			
			return;
		}
		
		for(int i = 0; i < M; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			int sum = gArr[cnt] + iArr[i];	// 이 라운드에서 획득할 점수
			int diff = gArr[cnt] - iArr[i]; // 양수 : 규영이 승, 음수 : 인영이 승
			permutation(cnt+1, isSelected, gScore+(diff>0?sum:0), iScore+(diff<0?sum:0));
			isSelected[i] = false;
		}
		
	}

}
