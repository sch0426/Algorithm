import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 색종이 수
        int[][] arr = new int[100][100];
        int r, c; // 색종이 시작 좌표
        StringTokenizer st;
        int ans = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            for(int j = 0; j < 10; j++){
                int nr = r + j;
                for(int k = 0; k < 10; k++){
                    int nc = c + k;
                    if(arr[nr][nc] != 1) {
                        ans++;
                        arr[nr][nc] = 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
