import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] chess = {1, 1, 2, 2, 2, 8};
        for(int i = 0; i < chess.length; i++) {
            chess[i] -= Integer.parseInt(st.nextToken());
            sb.append(chess[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
