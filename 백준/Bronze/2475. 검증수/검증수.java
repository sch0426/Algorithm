import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        while(st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            answer += a * a;
        }
        answer %= 10;

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
