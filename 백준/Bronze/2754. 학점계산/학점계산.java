import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String grade = br.readLine(); // ex) A0
        double answer = 43; // A+인 경우를 디폴트
        if(grade.length() == 2){
            char c1 =  grade.charAt(0);
            char c2 = grade.charAt(1);

            if(c1 == 'B') answer -= 10;
            else if(c1 == 'C') answer -= 20;
            else if(c1 == 'D') answer -= 30;

            if(c2 == '0') answer -= 3;
            else if(c2 == '-') answer -= 6;
            answer /= 10;

            sb.append(answer);
        } else {
            sb.append(0.0); // F학점
        }

        bw.write(sb.toString());
        bw.close();
    }
}
