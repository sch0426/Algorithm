import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("The largest square has side length ");

        int n = Integer.parseInt(br.readLine());
        sb.append((int)Math.sqrt(n)).append(".");
        System.out.println(sb);
    }
}
