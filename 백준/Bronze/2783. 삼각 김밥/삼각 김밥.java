import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double sevenX = Integer.parseInt(st.nextToken()); // 세븐 가격
        double sevenY = Integer.parseInt(st.nextToken()); // 그람 수
        double total = sevenX / sevenY * 1000;

        int T = Integer.parseInt(br.readLine()); // 다른 편의점 갯수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            double temp = x / y * 1000;
            if(total > temp) total = temp;
        }
        System.out.println(total);
    }
}
