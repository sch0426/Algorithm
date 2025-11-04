import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = sc.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) h[i] = sc.nextInt();

            int answer = 0;
            for (int i = 2; i < n - 2; i++) {
                int highest = Math.max(Math.max(h[i - 2], h[i - 1]), Math.max(h[i + 1], h[i + 2]));
                if (h[i] > highest) answer += h[i] - highest;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
