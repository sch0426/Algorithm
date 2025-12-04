import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int distance = Integer.parseInt(br.readLine());
        int answer = 0;
        if(distance % 5 == 0){answer = distance / 5;}
        else answer = distance / 5 + 1;

        System.out.println(answer);
    }
}
