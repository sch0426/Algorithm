import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 17135.캐슬 디펜스
 * 성을 향해 몰려오는 적을 잡는 '턴 방식'의 게임
 * 맵 사이즈: N * M
 * 각 칸에 포함된 적의 수는 '최대 한명'
 * -궁수-
 * 인원 및 배치: 궁수는 3명 배치, 한 칸에는 궁수 한명
 * 공격: 1) 각각의 턴마다 궁수는 적 하나만 공격, 모든 궁수는 동시에 공격
 *      2) 궁수는 D거리 이하에 있는 적 중에서 '제일 가까운 적'을 공격한다
 *      3) 가까운 적이 여러명일 경우 '가장 왼쪽'에 있는 적을 공격한다
 * 공격 거리 제한: D (입력값으로 주어짐)
 * -게임 순서-
 * 1) 궁수를 배치한다
 * 2) 궁수가 선으로 먼저 공격한다
 * 3) 공격에 맞은 적(1)은 맵에서 제외된다(0)
 * 4) 적은 아래로 아래로 한칸 이동한다
 *      -> 적을 아래로 내리는 방식 or 궁수를 위로 올리는 방식
 * 5) 궁수가 있는 행(성벽)으로 이동하면 맵에서 제외된다(0)
 * 6) 맵에서 모든 적이 제외되면 게임 종료
 */

public class Main {
    static int N, M, D, map[][], kill, archerRow, totalTarget, targetCnt, ans;
    static ArrayList<int[]> target = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전장 사이즈 행
        M = Integer.parseInt(st.nextToken()); // 전장 사이즈 열
        D = Integer.parseInt(st.nextToken()); // 궁수 사정거리
        map = new int[N + 1][M]; // 전장+성벽 크기만큼 행을 설정
        for(int i = 0; i < N; i++) { // 맵 입력
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) totalTarget++; // 맵에 있는 적 마릿수 누적
            }
        }
        // 궁수 배치 후 게임 시작
        setArcher(0, new int[3], 0);

        System.out.println(ans);
    }

    // 행에 궁수 3명을 배치하는 모든 경우의 수
    private static void setArcher(int idx, int[] archers, int aCnt) {
        // 궁수 3명 다 고른 경우 -> 게임시작
        if(aCnt == 3) {
            int[][] cloneMap = new int[N + 1][M];
            for(int i = 0; i < N + 1; i++) {
                for(int j = 0; j < M; j++) {
                    cloneMap[i][j] = map[i][j];
                }
            }
            for(int archer : archers) {
                cloneMap[N][archer] = 2;
            }

            kill = 0;
            archerRow = N;
            targetCnt = totalTarget;
            while(targetCnt > 0 && archerRow > 0) {
                target.clear();
                // 궁수가 공격할 수 있는 적들을 찾음
                for(int aIdx : archers) {
                    attack(aIdx, cloneMap);
                }
                // 목표로 한 적들을 잡음
                for(int[] t : target) {
                    if(cloneMap[t[0]][t[1]] == 1) {
                        cloneMap[t[0]][t[1]] = 0;
                        kill++;
                        targetCnt--;
                    }
                }

                // 적이 성벽으로 한칸 내려온다 -> 궁수를 한칸 올리는걸로 구현함
                archerRow--;

                for(int i = 0; i < M; i++) {
                    if(cloneMap[archerRow][i] == 1) {
                        cloneMap[archerRow][i] = 0;
                        targetCnt--;
                    }
                }
            }

            ans = Math.max(ans, kill);
            return;
        }

        if(idx == M) {
            return;
        }

        // 고른 경우
        archers[aCnt] = idx;
        setArcher(idx + 1, archers, aCnt + 1);
        // 안고른 경우
        setArcher(idx + 1, archers, aCnt);
    }

    // 궁수 공격 메서드 | 공격 가능 범위: |r1-r2| + |c1-c2| <= D | 궁수 위치: (N, aIdx)
    private static void attack(int aIdx, int[][] map) {
        // 궁수 위치에서 공격할 수 있는 적을 담는 리스트
        ArrayList<int[]> tmpTargets = new ArrayList<>();

        for(int i = archerRow - 1; i >= archerRow - D; i--) { // 궁수로부터 사정거리(D)만큼 떨어진 행부터
            for(int j = aIdx - D; j <= aIdx + D; j++) { // 궁수로부터 양옆으로 사정거리(D)만큼 떨어진 열만큼
                if(i  < 0 || i >= N || j < 0 || j >= M) continue; // 탐색 범위가 열 크기를 벗어나면 패스

                // 적이 공격 범위에 들어왔으면 공격
                int dist = Math.abs(i - (archerRow)) + Math.abs(j - aIdx);
                if(dist <= D && map[i][j] == 1) {
                    tmpTargets.add(new int[]{i, j, dist});
                }
            }
        }
        
        // 리스트에 담긴 적들의 위치가 제일 가깝고 제일 왼쪽인 적을 target에 추가
        if(!tmpTargets.isEmpty()) {
            int[] currTarget = tmpTargets.get(0);

            for(int i = 1; i < tmpTargets.size(); i++) {
                int[] tmp = tmpTargets.get(i);
                // 거리가 더 가까우면 바꾸기
                if(currTarget[2] > tmp[2]) {
                    currTarget = tmp;
                }
                // 같은 거리면 왼쪽에 있는거로 바꾸기
                else if(currTarget[2] == tmp[2]) {
                    if(currTarget[1] > tmp[1]) {
                        currTarget = tmp;
                    }
                }
            }
            target.add(new int[] {currTarget[0], currTarget[1]});
        }

    }

}
