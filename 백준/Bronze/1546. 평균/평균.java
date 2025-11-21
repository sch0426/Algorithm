import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = 0;
        Double sum = (double)0;
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            if(temp > M) M = temp;
            sum += temp;
        }
        Double answer = sum * 100 / N / M;
        System.out.print(answer);
    }
}