import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		int n = S.length();
		int m = P.length();
		
		if(n < m) {
			System.out.println(0);
			return;
		}
		
		long mod = 1_000_000_007;
		long hashKey = 31;
		
		long pHashVal = 0;
		long sHashVal = 0;
		long power = 1;
		
		for(int i = 0; i < m; i++) {
			sHashVal = (sHashVal * hashKey + S.charAt(i)) % mod;
			pHashVal = (pHashVal * hashKey + P.charAt(i)) % mod;
			if(i < m - 1) power = (power * hashKey) % mod;
		}
		
		for(int i = 0; i <= n - m; i++) {
			if(pHashVal == sHashVal) {
				if(S.substring(i, i + m).equals(P)) {
					System.out.println(1);
					return;
				}
			}
			
			if(i < n - m) {
				sHashVal = (hashKey * (sHashVal - S.charAt(i) * power) + S.charAt(i + m)) % mod;
				
				if(sHashVal < 0) sHashVal += mod;
			}
		}
		
		System.out.println(0);
	}

}
