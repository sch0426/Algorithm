import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	int start, end;
	double weight;

	public Edge(int start, int end, double weight) {
		super();
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.weight);
	}
}

// SWEA 1251. 하나로
public class Solution {
	static int N;
	static int[][] islands;
	static int[] parents;
	static double E;
	static ArrayList<Edge> edgeList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			islands = new int[2][N]; // 각 섬의 좌표 저장 배열
			parents = new int[N]; // 각 섬의 루트를 저장하는 배열
			
			makeSets(); // 각 섬마다 본인의 섬을 루트로 초기화
			
			for(int i = 0; i < 2; i++) { // 각 섬의 x, y좌표 입력
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					islands[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			E = Double.parseDouble(br.readLine()); // 환경 부담 세율
			
			edgeList = new ArrayList<>();
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					int x1 = islands[0][i];
					int y1 = islands[1][i];
					int x2 = islands[0][j];
					int y2 = islands[1][j];
					double charge = getCharge(x1, y1, x2, y2);
					edgeList.add(new Edge(i, j, charge));
				}
			}
			
			Collections.sort(edgeList);
			
			int count = 0;
			double result = 0; 
			for(Edge edge : edgeList) {
				if(union(edge.start, edge.end)) { 
					result += edge.weight;
					if(++count == N - 1) break;
				}
			}
			sb.append("#" + tc + " ").append(Math.round(result)).append("\n");
		}
		System.out.println(sb);
	}

	// 두 섬 사이의 환경 부담금
	static double getCharge(int x1, int y1, int x2, int y2) {
		return E * (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}

	static void makeSets() {
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	
	static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
 		return true;
	}
	
}
