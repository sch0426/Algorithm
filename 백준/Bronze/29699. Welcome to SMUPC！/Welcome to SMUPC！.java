import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = Integer.parseInt(br.readLine());
        String str = "WelcomeToSMUPC";
        System.out.println(str.charAt((idx - 1) % 14));
    }
}
