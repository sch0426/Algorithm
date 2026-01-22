import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(people);
        int[] time = new int[N];
        time[0] = people[0];
        for (int i = 1; i < N; i++) {
            time[i] = time[i - 1] + people[i];
        }
        int sum = 0;
        for(int t : time) {
            sum += t;
        }
        System.out.println(sum);
    }
}
