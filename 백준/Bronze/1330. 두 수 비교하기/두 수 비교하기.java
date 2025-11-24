import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final String BIG = ">";
    static final String SMALL = "<";
    static final String SAME = "==";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a =  Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a - b > 0) System.out.println(BIG);
        else if(a - b < 0) System.out.println(SMALL);
        else System.out.println(SAME);
    }
}