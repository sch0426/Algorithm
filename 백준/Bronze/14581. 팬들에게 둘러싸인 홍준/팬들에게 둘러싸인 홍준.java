import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(":fan:").append(":fan:").append(":fan:").append("\n");
        sb.append(":fan:").append(":").append(br.readLine()).append(":").append(":fan:").append("\n");
        sb.append(":fan:").append(":fan:").append(":fan:");
        System.out.println(sb);
    }
}
