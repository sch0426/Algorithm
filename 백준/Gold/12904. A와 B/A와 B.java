import java.util.*;
import java.io.*;

/*
 * 문자열의 뒤에 A를 추가한다.
 * 문자열을 뒤집고 뒤에 B를 추가한다.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
	
		while(true) {
			if(T.charAt(T.length() - 1) == 'A') {
				T = T.substring(0, T.length() - 1);
			} else {
				T = T.substring(0, T.length() - 1);
				T = new StringBuilder(T).reverse().toString();
			}
			if(T.length() == S.length()) break;
		}
		if(T.equals(S)) System.out.println(1);
		else System.out.println(0);
	}

}
