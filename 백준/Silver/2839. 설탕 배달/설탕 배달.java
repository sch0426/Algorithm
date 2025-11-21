import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quiz = Integer.parseInt(br.readLine());
        int answer = 0;

        while(quiz > 0) {
            if(quiz % 5 == 0) {
                answer += quiz / 5;
                System.out.print(answer);
                return;
            }
            if(quiz < 3) {
                System.out.print(-1);
                return;
            }
            quiz -= 3;
            answer++;
        }
        System.out.print(answer);
    }
}