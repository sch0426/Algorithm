import java.util.*;
import java.io.*;

public class Main {
	static int F, cnt;
	static Map<String, String> parents;
	static Map<String, Integer> friends;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			F = Integer.parseInt(br.readLine());
			parents = new HashMap<>();
			friends = new HashMap<>();
			
			for(int i = 0; i < F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();
				
				makeSets(f1);
				makeSets(f2);
				
				sb.append(union(f1, f2)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void makeSets(String name) {
		if(!parents.containsKey(name)) {
			parents.put(name, name);
			friends.put(name, 1);
		}
	}
	
	static String findSet(String name) {
		if(parents.get(name).equals(name)) return name;
		parents.put(name, findSet(parents.get(name)));
		return parents.get(name);
	}
	
	static int union(String name1, String name2) {
		String name1Root = findSet(name1);
		String name2Root = findSet(name2);
		
		if(!name1Root.equals(name2Root)) {
			parents.put(name2Root, name1Root); // 2의 루트를 1의 루트로 변경하면서 합친다
			friends.put(name1Root, friends.get(name1Root) + friends.get(name2Root));
		}
		
		return friends.get(name1Root);
	}
	
}
