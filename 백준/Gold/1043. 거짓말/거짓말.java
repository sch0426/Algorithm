import java.util.*;
import java.io.*;

public class Main {
	static int N, M, person[];
	static boolean[] know;
	static ArrayList<Integer> knowPerson;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int knowNum = Integer.parseInt(st.nextToken());
		knowPerson = new ArrayList<>();
		know = new boolean[N + 1];
		if(knowNum != 0) {
			for(int i = 0; i < knowNum; i++) {
				int num = Integer.parseInt(st.nextToken());
				know[num] = true;
				knowPerson.add(num);
			}
		}
		
		person = new int[N + 1];
		makeSets();
		
		ArrayList<Integer>[] party = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}
		
		for(int p = 0; p < M; p++) {
			st = new StringTokenizer(br.readLine());
			int pNum = Integer.parseInt(st.nextToken());
			int pRoot = Integer.parseInt(st.nextToken());
			party[p].add(pRoot);
			for(int i = 0; i < pNum - 1; i++) {
				int pSub = Integer.parseInt(st.nextToken());
				party[p].add(pSub);
				union(pRoot, pSub);
			}
		}
		
		int ans = 0;
		for(int i = 0; i < M; i++) {
			boolean isLier = true;
			for(int pNum : party[i]) {
				if(know[findSet(pNum)]) {isLier = false; break;}
			}
			if(isLier) ans++;
		}
		
		System.out.println(ans);
	}
	
	static void makeSets() {
		for(int i = 1; i < N + 1; i++) {
			person[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(person[a] == a)return a; // 나 자신이 루트면 나를 리턴 

		return person[a] = findSet(person[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		// 합치는 과정에 둘중 하나의 무리에 진실을 아는 사람이 있으면 두 무리에 있는 모든 사람들을
		// know 배열에 true로 바꾸기
		if(know[aRoot] || know[bRoot]) {
			know[aRoot] = true;
			know[bRoot] = true;
		}
		person[bRoot] = aRoot;
		
		return true;
	}
	
}
