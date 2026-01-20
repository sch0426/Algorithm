import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        String ans = Integer.toString(sum);
        int[] arr = new int[10];
        for(int i = 0; i < ans.length(); i++){
            int c = ans.charAt(i) - '0';
            arr[c]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

}
