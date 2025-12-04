import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int distance = Integer.parseInt(br.readLine());
        int answer = 0;
        while(distance > 5) {
            distance -= 5;
            answer++;
        }
        answer++;

        System.out.println(answer);
    }
}
