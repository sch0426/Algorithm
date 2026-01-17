import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sch = new int[n + 1];
        for(int i = 1; i < n + 1; i++) {
            sch[i] = Integer.parseInt(st.nextToken());
        }
        int student = Integer.parseInt(br.readLine());
        // 남자 1 여자 2
        for(int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if(gender == 1) {
                for(int j = idx; j <= n; j += idx) {
                    sch[j] = (sch[j] - 1) * (-1);
                }
            } else {
                sch[idx] = (sch[idx] - 1) * (-1);
                for(int j = 1; idx - j >= 1 && idx + j <= n && sch[idx - j] == sch[idx + j]; j++) {
                    sch[idx - j] = (sch[idx - j] - 1) * (-1);
                    sch[idx + j] = (sch[idx + j] - 1) * (-1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n + 1; i++) {
            sb.append(sch[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.print(sb);
    }
}
