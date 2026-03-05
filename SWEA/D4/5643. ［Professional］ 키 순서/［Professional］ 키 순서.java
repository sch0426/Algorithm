import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, smallStu[], bigStu[];
    static ArrayList<Integer>[] student;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine()); // 학생 수
            M = Integer.parseInt(br.readLine()); // 비교 횟수
            student = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                student[i] = new ArrayList<>();
            }
            for(int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int smallStuNum = Integer.parseInt(st.nextToken());
                int bigStuNum = Integer.parseInt(st.nextToken());
                student[smallStuNum].add(bigStuNum); // 작은 학생이 큰 학생 바라보도록 리스트 연결
            }

            smallStu = new int[N + 1];
            bigStu = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                bfs(i);
            }

            int ans = 0;
            for(int i = 1; i <= N; i++) {
                if(smallStu[i] + bigStu[i] == N - 1) ans++;
            }
            sb.append("#" + tc + " ").append(ans).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(int startStu) {
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        visited[startStu] = true;
        q.offer(startStu);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next : student[curr]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);

                    bigStu[startStu]++;
                    smallStu[next]++;
                }
            }
        }

    }
}