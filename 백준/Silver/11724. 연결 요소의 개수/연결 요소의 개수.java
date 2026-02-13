import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, connectedCompo;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			graph[u].add(v);
			graph[v].add(u);
		}
		// 각 노드 방문배열
		visited = new boolean[N];
		connectedCompo = 0;
		
		for(int node = 0; node < N; node++) {
			if(!visited[node]) {
				visited[node] = true;
				dfs(node);
				connectedCompo++;
			}
		}
		System.out.println(connectedCompo);
	}
	
	static void dfs(int node) {
		
		for(int i : graph[node]) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

}
