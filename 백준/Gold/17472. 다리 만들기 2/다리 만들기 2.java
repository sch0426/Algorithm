import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 0 : 바다
 * 1 : 섬
 * 다리는 섬(1)에서 섬(1)으로만 이을 수 있다
 * (0,0)부터 섬(1)인 곳에서 오른쪽,아래 방향으로 2방탐색하여 다리를 놓는다
 */
public class Main {
	
	static int N, M, map[][], ans;
	static char island[][], alpha = 'A';
	static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
	static int[] dc = {1, 0, -1, 0};
	static int[][] bridgeLen;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 배열을 만들어서 각 분리된 섬을 알파벳으로 분류함
		island = new char[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && island[i][j] == 0) {
					dfs(i, j, alpha);
					alpha += 1; // 다음 알파벳으로 표시하도록 +1 해줌
				}
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(island[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		// alpha - 'A'은 총 분류된 섬의 갯수
		bridgeLen = new int[alpha - 'A'][alpha - 'A'];
		// 무한대로 배열 채워놓기
		for(int i = 0; i < bridgeLen.length; i++) {
			Arrays.fill(bridgeLen[i], Integer.MAX_VALUE);
		}
		
		// 분류된 섬 수만큼 그래프 생성
		graph = new ArrayList[alpha - 'A' + 1];
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList();
		}
		
		// 섬 배열 순회하면서 섬 만나면 다리 짓기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(island[i][j] != 0) {
					setBridge(i, j, island[i][j]);
				}
			}
		}
		
//		for(int i = 0; i < bridgeLen.length; i++) {
//			System.out.print(bridgeLen[i] + " ");
//		}
		
		// 방문배열  
		visited = new boolean[alpha - 'A'];
		prim(0);
	
		for (boolean v : visited) {
//			System.out.print(v + " ");
			if(!v) ans = -1;
		}
		
		System.out.println(ans);
		
	}

    
    private static void prim(int startNode) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{startNode, 0});
        
        int count = 0; // 방문한 섬 개수
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int dist = curr[1];
            
            if (visited[node]) continue;
            
            visited[node] = true;
            ans += dist;
            count++;
            
            for (int next = 0; next < (alpha - 'A'); next++) {
                // 연결되어 있고 방문하지 않은 섬이 있다면
                if (bridgeLen[node][next] != Integer.MAX_VALUE && !visited[next]) {
                    pq.offer(new int[]{next, bridgeLen[node][next]});
                }
            }
        }
        
        // 모든 섬을 방문하지 못했다면 -1
        if (count != (alpha - 'A')) ans = -1;
    }
    
    
    /**
     * @param idx : 시작 인덱스
     */
//    private static void prim(int idx) {
////    	System.out.print(idx + " > ");
//    	// 시작지점 방문처리
//		visited[idx] = true;
//		// 해당 섬에서 연결된 섬마다
//		for(int i : graph[idx]) {
//			// 아직 방문하지 않은 섬이면
//			if(!visited[i]) {    
//				// 해당 섬까지 제일 짧은 다리길이 더해주고
//				ans += bridgeLen[idx][i];
//				// 다시 그 섬으로 들어가서 반복하기
//				prim(i);
//			}
//		}
//	}

	// 다리짓기
    // 다리는 가로, 세로만 지을 수 있다. 그런데 (0,0)부터 순회해서 다리를 짓기때문에
    // 위나 왼쪽으로 다리를 짓는 시도는 안해도된다. 오른쪽, 아래로 다리를 지어보면 모든 다리 짓는 경우를 시도할 수 있다
    private static void setBridge(int r, int c, char alpha) {
    	// 다리 지을 방향의 인덱스와 다리 길이를 누적할 cnt변수
		for(int d = 0; d < 4; d++) {
			int nr = r, nc = c, cnt = 0;
			while(true) {
				nr += dr[d];
				nc += dc[d];
				
				// 행이나 열 끝을 만나면 중간에 섬을 못만난 경우니까 다리를 못지은거임.
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) {cnt = 0; break;}
				
				// 행이나 열로 뻗어나가는데 같은 섬(alpha로 체크)을 만나면 다리를 못지음
				if(island[nr][nc] == alpha) {cnt = 0; break;}
				
				// 다른 섬 만났는데 다리 길이가 2보다 짧으면 패스
				if(island[nr][nc] > 0 && island[nr][nc] != alpha && cnt < 2) {cnt = 0; break;}
				
				// 다른 섬(alpha)를 만나면 다리 지은거니까 해당 섬까지 다리길이 배열에 최소값 갱신하기, 다리길이 최소 2
				if(island[nr][nc] > 0 && island[nr][nc] != alpha && cnt > 1) {
					int start = alpha - 'A';
					int end = island[nr][nc] - 'A';
					int islandIdx = island[nr][nc] - 'A';
//					System.out.println(islandIdx + " : " + alpha + " > " + island[nr][nc] + " : " + cnt);
					// 다리길이 배열에 해당 섬까지 지은 다리길이중 최소값으로 갱신
					bridgeLen[start][end] = Math.min(bridgeLen[start][end], cnt);
					bridgeLen[end][start] = Math.min(bridgeLen[end][start], cnt);
					// 그래프에 두 섬 연결 표시 해주기
					graph[start].add(end);
					graph[end].add(start);
					break;
				}
				
				cnt++;
			}
		}
		
	}

	// 섬 분류하는 dfs
	private static void dfs(int r, int c, char alpha) {
		island[r][c] = alpha;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 맵을 벗어나거나, 다음 본 곳이 바다(0)이거나, 이미 같은 섬으로 분류됐으면 패스
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] != 1 || island[nr][nc] == alpha) continue;
			// 다음 육지 표시하러
			dfs(nr, nc, alpha);
		}
		
	}
}
