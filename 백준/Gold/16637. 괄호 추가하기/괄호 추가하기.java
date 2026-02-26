import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static String[] str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine().split("");

        ans = Integer.MIN_VALUE;
        dfs(Integer.parseInt(str[0]), 1);
        System.out.println(ans);
    }

    private static int operator(int num1, String oper, int num2) {
        if(oper.equals("+")) return num1 + num2;
        else if(oper.equals("-")) return num1 - num2;
        return num1 * num2;
    }

    // 현재 인덱스에서 바로 다음에 오는 숫자를 연산할지,
    // 다음에 오는 순자를 괄호를 묶어서 그 뒤에 결과를 현재에 더할지
    private static void dfs(int currTotal, int idx) {
        if(idx >= N) {
            ans = Math.max(ans, currTotal);
            return;
        }

        String oper = str[idx];
        int nextNum = Integer.parseInt(str[idx + 1]);

        // 현재 인덱스에서 바로 다음에 오는 숫자를 연산할지,
        int result = operator(currTotal, oper, nextNum);
        dfs(result, idx + 2);
        // 다음에 오는 순자를 괄호를 묶어서 그 뒤에 결과를 현재에 더할지
        if(idx + 2 < N) {
            String oper1 = str[idx + 2];
            int num2 = Integer.parseInt(str[idx + 3]);
            int result2 = operator(nextNum, oper1, num2);
            int result3 = operator(currTotal, oper, result2);
            dfs(result3, idx + 4);
        }
    }
}
