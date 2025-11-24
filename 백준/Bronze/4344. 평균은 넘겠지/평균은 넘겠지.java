import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double[] students = new double[Integer.parseInt(st.nextToken())];
            double sum = 0;
            for(int j = 0; j < students.length; j++) {
                students[j] = Integer.parseInt(st.nextToken());
                sum += students[j];
            }
            sum /= students.length;
            double over = 0;
            for(int j = 0; j < students.length; j++) {
                if(students[j] > sum) {
                    over++;
                }
            }
            over /= students.length;
            over *= 100;
            DecimalFormat df = new DecimalFormat("0.000");
            String s = df.format(over);
            sb.append(s).append("%").append("\n");
        }
        System.out.println(sb);
    }
}
