import java.util.*;
import java.io.*;

public class Main {
	final static int N = 9;
	static int map[][];
	static ArrayList<int[]> zeros;
	static boolean isFinish = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zeros = new ArrayList<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) zeros.add(new int[] {i, j});
			}
		}

		sudoku(0);
		
	}
	
	private static void sudoku(int idx) {
		if(isFinish) return;
		if(idx == zeros.size()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			isFinish = true;
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			int[] curr = zeros.get(idx);
			
			if(!isAvailable(curr[0], curr[1], i)) continue;
			setNum(curr[0], curr[1], i);
			sudoku(idx + 1);
			setNum(curr[0], curr[1], 0);
		}
	}

	private static void setNum(int r, int c, int num) {
		map[r][c] = num;
		return;
	}

	private static boolean isAvailable(int r, int c, int num) {
		int nr = r, nc = c;
		// 가로줄 체크 
		for(int col = 0; col < N; col++) {
			if(num == map[nr][col]) return false;
		}
		// 세로줄 체크
		for(int row = 0; row < N; row++) {
			if(num == map[row][nc]) return false;
		}
		// 본인 칸 체크
		for(int row = nr/3*3; row < nr/3*3 + 3; row++) {
			for (int col = nc/3*3; col < nc/3*3 + 3; col++) {
				if(map[row][col] == num) return false;
			}
		}
		return true;
	}
}
