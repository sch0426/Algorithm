import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static int ans = 0;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        recursive(arr, 0, 1, 1);
        System.out.println(ans);
    }
    
    /**
     * @param arr	: 배열 
     * @param r		: 행 위치
     * @param c		: 열 위치
     * @param status: 가로(1), 세로(2), 대각선(3) 중 어떤 상태인지
     */
    static void recursive(int[][] arr, int r, int c, int status) {
    	// basis part
    	if(r == N - 1 && c == N - 1 && arr[r][c] != 1) {
    		ans++;
    		return ;
    	}
    	// 맵을 벗어나면 탈출
    	if(r < 0 || r >= N || c < 0 || c >= N) return;
    	// 벽(1)을 만나면 탈출
    	if(arr[r][c] == 1) return;
    	
    	// inductive part
    	if(status == 1) { // 파이프가 가로 상태
    		// 가로로 이동
        	recursive(arr, r, c + 1, 1);
        	// 대각선으로 이동
        	if(r + 1 >= 0 && r + 1 < N && c + 1 >= 0 && c + 1 < N) {
        		if(arr[r][c + 1] != 1 && arr[r + 1][c] != 1) {
        			recursive(arr, r + 1, c + 1, 3);
        		}
        	}
    	} else if(status == 2) { // 파이프가 세로 상태
    		// 세로로 이동
        	recursive(arr, r + 1, c, 2);
        	// 대각선으로 이동
        	if(r + 1 >= 0 && r + 1 < N && c + 1 >= 0 && c + 1 < N) {
        		if(arr[r][c + 1] != 1 && arr[r + 1][c] != 1) {
        			recursive(arr, r + 1, c + 1, 3);
        		}
        	}
    	} else { // 파이프가 대각선 상태
    		// 가로로 이동
        	recursive(arr, r, c + 1, 1);
    		// 세로로 이동
        	recursive(arr, r + 1, c, 2);
        	// 대각선으로 이동
        	if(r + 1 >= 0 && r + 1 < N && c + 1 >= 0 && c + 1 < N) {
        		if(arr[r][c + 1] != 1 && arr[r + 1][c] != 1) {
        			recursive(arr, r + 1, c + 1, 3);
        		}
        	}
    	}
    }

}
