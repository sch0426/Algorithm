import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String temp1 = st.nextToken();
        String temp2 = st.nextToken();
        StringBuilder sb = new StringBuilder();
        while(!temp1.equals("0") && !temp2.equals("0")){
            sb.append(Integer.parseInt(temp1) + Integer.parseInt(temp2)).append("\n");
            st = new StringTokenizer(br.readLine());
            temp1 = st.nextToken();
            temp2 = st.nextToken();
        }

        System.out.println(sb);
    }
}
