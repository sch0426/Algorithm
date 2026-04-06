import java.util.*;
import java.io.*;

public class Solution {
    static int N, map[][], minTime;
    static ArrayList<int[]> student, steps;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            student = new ArrayList<>();
            steps = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        student.add(new int[] {i, j});
                    } else if(map[i][j] >= 2) {
                        steps.add(new int[] {i, j, map[i][j]});
                    }
                }
            }

            minTime = Integer.MAX_VALUE;
            permutation(0, new int[student.size()]);

            sb.append("#" + tc + " ").append(minTime).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int idx, int[] sel) {
        if(idx == sel.length) {
            // 각 사람별 어느 계단으로 갈지 정해짐
            // 이제 각 계단에서 내려가는 시뮬 시작, 계단은 두개
            ArrayList<Integer> step1 = new ArrayList<>();
            ArrayList<Integer> step2 = new ArrayList<>();
            for(int i = 0; i < sel.length; i++) {
                int[] stu = student.get(i); // i번 학생 위치
                int[] step = steps.get(sel[i]);// sel[i]번 계단 위치
                if(sel[i] == 0) {
                    step1.add(getDist(stu, step));
                } else {
                    step2.add(getDist(stu, step));
                }
            }
            Collections.sort(step1);
            Collections.sort(step2);

            int time1 = getTime(step1, steps.get(0)[2]);
            int time2 = getTime(step2, steps.get(1)[2]);

            int endTime = Math.max(time1, time2);

            minTime = Math.min(minTime, endTime);

            return;
        }

        for(int i = 0; i < steps.size(); i++) {
            sel[idx] = i;
            permutation(idx + 1, sel);
        }

    }

    private static int getTime(ArrayList<Integer> list, int h) {
        if(list.isEmpty()) {
            return 0;
        }

        int[] endTime = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            int currTime = list.get(i);

            if(i < 3) {
                endTime[i] = currTime + h + 1;
            } else {
                endTime[i] = Math.max(currTime + 1, endTime[i - 3]) + h;
            }
        }

        return endTime[list.size() - 1];
    }

    private static int getDist(int[] stu, int[] step) {
        return Math.abs(stu[0] - step[0]) + Math.abs(stu[1] - step[1]);
    }

}