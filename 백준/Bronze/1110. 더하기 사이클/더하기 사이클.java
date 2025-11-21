import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = N;
        int cnt = 0;
        while(true) {
            int a = M / 10;
            int b = M % 10;
            int c = a + b;
            int newNum = b * 10 + c % 10;
            cnt++;
            if(N == newNum) break;
            M = newNum;
        }
        System.out.print(cnt);
    }
}