import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int ans = 0;
    static ArrayList<ArrayList<Integer>> computers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine()); // 총 노드의 수
        N = Integer.parseInt(br.readLine()); // 간선의 수

        for (int i = 0; i <= computer; i++) { // 컴퓨터 수 만큼 노드 만들기
            computers.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) { // 각 컴퓨터마다 연결 시켜주기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 노드 번호
            int y = Integer.parseInt(st.nextToken()); // 노드 번호
            computers.get(x).add(y); // x노드와 y노드 사이를 간선으로 연결
            computers.get(y).add(x);
        }

        visited = new boolean[computer + 1]; // 방문했는지 체크
        visited[1] = true; // 1번부터 시작이라 1번은 방문처리
        recursive(1); // 탐색 시작
        System.out.println(ans);
    }

    static void recursive(int idx) {
        for(int i = 0; i < computers.get(idx).size(); i++) { // 1번에 연결된 노드의 수 만큼 반복 탐색
            if(!visited[computers.get(idx).get(i)]) { // 연결된 노드에 방문하지 않았다면
                visited[computers.get(idx).get(i)] = true; // 방문처리 하고
                ans++; // 연결된 노드의 수 1 증가하고
                recursive(computers.get(idx).get(i)); // 재귀
            }
        }

    }
}
