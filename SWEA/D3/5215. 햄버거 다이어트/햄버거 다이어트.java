import java.util.*;
import java.io.*;

class Solution {
    static int[] score;
    static int[] kcal;
    static int maxScore;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 재료의 수
            int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
            maxScore = 0;

            score = new int[N];
            kcal = new int[N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }

            recursive(0, L, 0, 0, N);

            sb.append("#" + tc + " ").append(maxScore).append("\n");
        }
        System.out.println(sb);

    }

    /**
     * @param idx : 선택하는 값의 인덱스 번호
     * @param L   : 제한 칼로리
     * @param sumScore : 현재 합산 점수
     * @param sumKcal  : 현재 합산 칼로리
     * @param N   : 총 재료 수
     */
    static void recursive(int idx, int L, int sumScore, int sumKcal, int N) {
        // basis part
        if(sumKcal > L) {
            return ;
        }

        if(idx == N) {
            maxScore = Math.max(maxScore, sumScore);
            return ;
        }

        // inductive part 선택하는 경우에 가지의 수
        // 선택하는 경우
        recursive(idx + 1, L, sumScore + score[idx], sumKcal + kcal[idx], N);

        // 선택하지 않는 경우
        recursive(idx + 1, L, sumScore, sumKcal, N);
    }

}
