import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()); // N * M 값

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M]; // N * M 행렬 초기화

        int row = 0;
        st = new StringTokenizer(br.readLine());
        String str;
        while(st.hasMoreTokens()) {
            row %= N;
            for(int i = 0; i < M; i++) {
                arr[row][i] += Integer.parseInt(st.nextToken());
            }
            row++;
            if((str = br.readLine()) != null) st = new StringTokenizer(str);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
