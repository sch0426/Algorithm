import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double answer = 0;

        int c = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(c % b == 0) System.out.println(c / b);
        else {
            answer = (double)c / b;
            System.out.println(answer);
        }
    }
}
