import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 목표 금액

        int[] coin = new int[N];
        for(int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        for(int i = N - 1; i >= 0; i--) {
            ans += K / coin[i];
            K %= coin[i];
        }
        System.out.println(ans);
    }
}
