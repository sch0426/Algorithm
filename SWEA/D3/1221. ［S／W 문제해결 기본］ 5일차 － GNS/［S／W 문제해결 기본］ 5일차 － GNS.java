import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tc = st.nextToken();
            int len = Integer.parseInt(st.nextToken());
            String[] arr1 = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
            HashMap<String, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < len; i++) {
                String temp = st.nextToken();
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            System.out.println(tc);
            for(String str : arr1) {
                for(int i = 0; i < map.getOrDefault(str, 0); i++) {
                    System.out.print(str + " ");
                }
            }
            System.out.println();

        }
    }
}