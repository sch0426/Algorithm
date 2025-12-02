import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] turtle = new int[st.countTokens()];
        for (int i = 0; i < turtle.length; i++) {
            turtle[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(turtle);
        sb.append(turtle[0] * turtle[2]);

        bw.write(sb.toString());
        bw.close();
    }
}
