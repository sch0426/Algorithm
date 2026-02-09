import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] people;
    static int[] v;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 구역 수 입력
        N = Integer.parseInt(br.readLine());
        // 지역 별 인구비중 배열
        people = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        // 각 지역별 인구수 입력
        for(int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 지역 그래프
        graph = new ArrayList[N + 1];
        // 지역 수만큼 반복, 각 지역 별 연결된 지역 연결하기
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
            st = new StringTokenizer(br.readLine());
            // 각 선거구 별 연결된 선거구 수
            int m = Integer.parseInt(st.nextToken());
            for(int j = 0; j < m; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        // 각 지역별로 출발해서 DFS를 돌려서 선거구가 나뉘어 질 수 있는 모든 경우의 수를 구함
        // 각 경우의 수 마다 모든 노드를 기준으로  BFS를 돌린다. BFS 돌은 횟수 != 2 -> 불가능한 방법
        // BFS 돌기전에 변수 2개를 만들어서 각 변수에 bfs 돌때마다 각 변수에 인구수 합을 구함
        // (선거구 개수)C(1~선거구 개수-1)
        // graph 순회
        v = new int[N + 1]; //
        permutation(1, v, 1);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    /**
     * @param idx : 현재 가리키고 있는 인덱스
     * @param sel : 선택한 값을 저장하는 배열
     * @param k   : 저장배열의 인덱스
     */
    private static void permutation(int idx, int[] sel, int k) {
        if(k == sel.length) {
            // 1, 2 선거구로 모두 나뉘어 지고 나면 각 선거구마다 bfs 돌리기
            // 1 -> 3으로 2->4로 표시하기
//			System.out.println(Arrays.toString(sel));
            int[] choice = sel.clone();
            // 여기서 이제 bfs를 돌려서 해당 방문 배열을 사용해서  bfs가 2번만 도는지 확인
            // bfs 돈 횟수
            int aBfsCnt = 0, bBfsCnt = 0;
            int aSum = 0, bSum = 0;
            for(int i = 1; i <= N; i++) {
                // A선거구(1) 만 bfs 탐색
                if(choice[i] == 1) {
                    aSum = bfs(i, choice, 1);
                    aBfsCnt++;
                }
            }

            // -----------------------
            for(int i = 1; i <= N; i++) {
                // B선거구(2) 만 bfs 탐색
                if(choice[i] == 2) {
                    bSum = bfs(i, choice, 2);
                    bBfsCnt++;
                }
            }
            if(aBfsCnt == 1 && bBfsCnt == 1) {
                answer = Math.min(answer, Math.abs(aSum - bSum));
            }
            return;
        }
        if(idx == sel.length) return;

        // inductive part
        // A선거구로 지정
        sel[k] = 1;
        permutation(idx + 1, sel, k + 1);
        // B선거구로 지정
        sel[k] = 2;
        permutation(idx + 1, sel, k + 1);
    }

    /**
     * @param idx   : 시작 인덱스
     * @param sel   : 몇번 선거구로 나누는지 체크하는 배열
     * @param target: 1이 들어오면 1만 체크하고 2가 들어오면 2만 체크
     */
    private static int bfs(int idx, int[] sel, int target) {
        Deque<Integer> q = new ArrayDeque<>();
        int sumPeople = 0;

        q.offer(idx);
        sel[idx] = (sel[idx] == 1) ? 3 : 4;
        sumPeople += people[idx];

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int node : graph[tmp]) {
                if(sel[node] == target) {
                    sel[node] = (sel[node] == 1) ? 3 : 4;
                    q.offer(node);
                    sumPeople += people[node];
                }
            }
        }
        return sumPeople;
    }

}

