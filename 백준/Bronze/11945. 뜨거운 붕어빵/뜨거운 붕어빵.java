import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n줄
        int m = Integer.parseInt(st.nextToken()); // m길이

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = m - 1; j >= 0; j--){
                sb.append(str.charAt(j));
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
