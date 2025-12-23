import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T - 1; i++){
            for(int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i = 0; i < T; i++) sb.append("*");
        sb.append("\n");
        for(int i = T - 1; i > 0; i--) {
            for(int j = i; j > 0; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
