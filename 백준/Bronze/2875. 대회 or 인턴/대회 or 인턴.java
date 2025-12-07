import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 여학생 수
        int M = Integer.parseInt(st.nextToken()); // 남학생 수
        int K = Integer.parseInt(st.nextToken()); // 인턴 인원 수

        // 인턴 고려 없이 만들 수 있는 최대 팀 수
        int team = Math.min(N / 2, M);

        // 남는 인원 수
        int rest = N + M - team * 3;

        // 인턴 K명을 채울 수 있을 때까지 팀을 줄이기
        while (rest < K && team > 0) {
            team--;
            rest += 3;
        }

        System.out.println(team);
    }
}
