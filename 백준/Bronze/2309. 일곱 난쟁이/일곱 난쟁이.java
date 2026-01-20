import java.util.*;
import java.io.*;

public class Main {
    static int N = 9; // 총 난쟁이 수
    static int M = 7; // 뽑을 난쟁이 수
    static int GOAL = 100; // 일곱난쟁이 키의 합

    static int[] arr = new int[N]; // 총 난쟁이 저장 배열
    static int[] ans = new int[M]; // 일곱난쟁이 저장 배열
    static boolean found = false; // 정답을 찾았는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine()); // 아홉난쟁이 저장

        Arrays.sort(arr); // 오름차순이라 미리 정렬

        dfs(0, 0, 0); // 일곱난쟁이 찾기

        StringBuilder sb = new StringBuilder();
        for(int p : ans) {
            sb.append(p).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int depth, int sum) { // 시작지점, 찾은 난쟁이 수, 난쟁이 키의 합
        if(found) return ; // 정답 찾았으면 끝

        if(depth == M) { 
            if(sum == GOAL) found = true; // 찾은 난쟁이 수, 키의 합이 정답인 경우
            return ;
        }

        for(int i = start; i < N; i++) {
            ans[depth] = arr[i];
            dfs(i + 1, depth + 1, sum + arr[i]);
            if(found) return;
        }
    }

}
