import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] time = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            // 각 건물별로 사전에 지어야하는 건물의 갯수 저장하는 배열
            int[] preCourse = new int[N];
            ArrayList<Integer>[] course = new ArrayList[N];
            for(int i = 0; i < N; i++) {
                course[i] = new ArrayList<>();
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                // pre를 먼저 지어야 after를 지을 수 있다
                int pre = Integer.parseInt(st.nextToken()) - 1;
                int after = Integer.parseInt(st.nextToken()) - 1;
                preCourse[after]++;
                course[pre].add(after);
            }
            int W = Integer.parseInt(br.readLine()) - 1;

            int[] courseTime = new int[N];
            Deque<Integer> q = new ArrayDeque<>();
            for(int i = 0; i < N; i++) {
                if(preCourse[i] == 0) {
                    q.offer(i);
                    courseTime[i] = time[i];
                }
            }

            while(!q.isEmpty()) {
                int curr = q.poll();

                for(int next : course[curr]) {
                    courseTime[next] = Math.max(courseTime[next], courseTime[curr] + time[next]);
                    preCourse[next]--;
                    if(preCourse[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            sb.append(courseTime[W]).append("\n");
        }
        System.out.println(sb);
    }
}
