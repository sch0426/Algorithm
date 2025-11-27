import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str =  br.readLine();
        String[] cro = {"č", "ć", "ž", "đ", "ł", "ñ", "š", "ž"};
        String[] alpa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i < cro.length; i++) {
            str = str.replaceAll(alpa[i], cro[i]);
        }

        sb.append(str.length());

        bw.write(sb.toString());
        bw.close();
    }
}
