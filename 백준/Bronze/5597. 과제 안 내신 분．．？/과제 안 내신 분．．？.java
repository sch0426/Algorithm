import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] students = new boolean[30];
        for(int i = 0; i < 28; i++){
            students[Integer.parseInt(br.readLine()) - 1] = true ;
        }
        for(int i = 0; i < students.length; i++){
            if(!students[i]){sb.append(i + 1).append("\n");}
        }

        bw.write(sb.toString());
        bw.close();
    }
}
