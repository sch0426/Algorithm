import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        int a = x * (y % 10);
        int b = x * ((y / 10) % 10);
        int c = x * (y / 100);
        int sum = a + 10 * b + 100 * c;

        StringBuilder sb = new StringBuilder();
        sb.append(a).append("\n");
        sb.append(b).append("\n");
        sb.append(c).append("\n");
        sb.append(sum);

        System.out.println(sb);

    }
}
