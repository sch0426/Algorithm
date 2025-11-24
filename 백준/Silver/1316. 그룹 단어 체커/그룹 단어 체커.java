import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean isGroup;
        boolean[] visited;
        int answer = 0;
        for (int tc = 0; tc < T; tc++) {
            visited = new boolean[26];
            isGroup = true;
            String str = br.readLine();
            if(str.length() == 1){
                answer++;
                continue;
            }
            visited[str.charAt(0) - 'a'] = true;
            for(int i = 1; i < str.length(); i++){
                char before = str.charAt(i - 1);
                char current = str.charAt(i);
                int curr = current - 'a';
                if(current != before && visited[curr]) {
                    isGroup = false;
                    break;
                } else {visited[curr] = true;}
            }
            if(isGroup){answer++;}
        }
        System.out.println(answer);
    }
}