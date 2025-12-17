import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while(str != null){
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            sb.append(s / (n + 1)).append("\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }
}
