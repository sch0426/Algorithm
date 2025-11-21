import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[] arr = new int[26];
        for(int i = 0; i < str.length(); i++) {
            int alpa = str.charAt(i) - 'A';
            arr[alpa]++;
        }

        int maxIdx = 0;
        int max = 0;
        boolean isSame = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIdx = i;
                isSame = false;
            }
            else if(arr[i] == max) isSame =true;
        }
        if(isSame) {
            System.out.print("?");
        } else {
            char c = (char) (maxIdx + 'A');
            System.out.print(c);
        }
    }
}