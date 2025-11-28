import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 대문자 65부터 소문자 97부터
        char[] str = br.readLine().toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(str[i] > 96) str[i] -= 32;
            else str[i] += 32;
        }
        for(char c : str) {
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.close();
    }
}
