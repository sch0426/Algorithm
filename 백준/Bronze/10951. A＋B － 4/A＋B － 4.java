import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(A + B).append("\n");
            String str = br.readLine();
            if(str == null) break;
            st =  new StringTokenizer(str);
        }

        bw.write(sb.toString());
        bw.close();
    }
}
