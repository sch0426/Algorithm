import java.util.*;
import java.io.*;

public class Main {
	static int count;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		
		int[] pi = getPi(p);
		search(s, p, pi);
		
		System.out.println(count);
		System.out.println(sb);
	}

	private static int[] getPi(String p) {
		int m = p.length();
		int[] pi = new int[m];
		int j = 0;
		
		for(int i = 1; i < m; i++) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(p.charAt(i) == p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}

	private static void search(String s, String p, int[] pi) {
		int n = s.length();
		int m = p.length();
		int j = 0;
		
		for(int i = 0; i < n; i++) {
			while(j > 0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(s.charAt(i) == p.charAt(j)) {
				if(j == m - 1) {
					count++;
					sb.append(i - m + 2).append(" ");
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		
	}
	
}
