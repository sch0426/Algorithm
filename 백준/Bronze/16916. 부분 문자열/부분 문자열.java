import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		int[] pi = getPi(P);
		
		System.out.println(search(S, P, pi));
	}

	private static int[] getPi(String P) {
		int[] pi = new int[P.length()];
		int j = 0;
		
		for(int i = 1; i < P.length(); i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	private static int search(String S, String P, int[] pi) {
		int n = S.length();
		int m = P.length();
		int j = 0;
		
		for(int i = 0; i < n; i++) {
			while(j > 0 && S.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(S.charAt(i) == P.charAt(j)) {
				if(j == m - 1) {
					return 1;
				} else {
					j++;
				}
			}
		}
		
		return 0;
	}
	
}
