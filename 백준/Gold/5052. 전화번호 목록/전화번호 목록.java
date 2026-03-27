import java.util.*;
import java.io.*;

public class Main {
	
	static class Node {
		Map<Character, Node> child;
		boolean endOfWord;
		
		public Node() {
			this.child = new HashMap<>();
			this.endOfWord = false;
		}
	}
	
	static class Trie {
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void insert(String num) {
			Node node = this.root;
			
			for(int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);
				node.child.putIfAbsent(c, new Node());
				node = node.child.get(c);
			}
			node.endOfWord = true;
		}
		
		public boolean search(String num) {
			Node node = this.root;
			
			for(int i = 0; i < num.length(); i++) {
				char c = num.charAt(i);
				
				if(node.child.containsKey(c)) {
					node = node.child.get(c);
				} else {
					return false;
				}
			}
			return node.child.size() > 0 ? false : true;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			Trie trie = new Trie();
			int n = Integer.parseInt(br.readLine());
			String[] numBook = new String[n];
			for(int i = 0; i < n; i++) {
				String num = br.readLine();
				numBook[i] = num;
				trie.insert(num);
			}
			boolean isAvailable = true;
			for(String num : numBook) {
				if(!trie.search(num)) {
					isAvailable = false;
					break;
				}
			}
			if(isAvailable) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb);
	}

}
