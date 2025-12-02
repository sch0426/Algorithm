import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        * 현 위치 버스정류장
        * N : 지하철역까지 가는데 소요시간
        * A : A분 뒤 버스 도착
        * B : B분 뒤 지하철 도착
        * */
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if(A < B) sb.append("Bus");
        else {
            if(A == B) {
                if(N <= B) sb.append("Anything");
                else sb.append("Bus");
            } else {
                if(N <= B) sb.append("Subway");
                else sb.append("Bus");
            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}
