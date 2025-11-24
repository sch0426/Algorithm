import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] mem;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T =  Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int tc = Integer.parseInt(br.readLine());
            mem = new int[tc + 1][2];
            mem[0][0] = 1;
            mem[0][1] = 0;
            if(tc > 0) {
                mem[1][0] = 0;
                mem[1][1] = 1;
            }

            fibonacci(tc);
            System.out.println(mem[tc][0] + " " + mem[tc][1]);
        }
    }

    private static void fibonacci(int n) {
        if(n == 0 || n == 1 || mem[n][0] != 0 || mem[n][1] != 0) {
            return;
        }
        fibonacci(n - 1);
        fibonacci(n - 2);
        mem[n][0] = mem[n - 1][0] + mem[n- 2][0];
        mem[n][1] = mem[n - 1][1] + mem[n- 2][1];
    }
}