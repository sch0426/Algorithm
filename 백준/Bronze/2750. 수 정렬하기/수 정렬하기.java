import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[2001];
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000]++;
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i]; j++) {
				System.out.println(i - 1000);
			}
		}
	}

}
