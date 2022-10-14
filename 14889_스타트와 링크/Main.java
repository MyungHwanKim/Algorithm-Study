import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] isVisited;
    static int[] start;
    static int min = Integer.MAX_VALUE;  // 두 팀의 능력치 차의 최소를 위해 최댓값으로 설정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 사람 수 (짝수)
        int team = N / 2;  // 스타트 팀과 링크 팀 두 팀으로 나눈 인원
        arr = new int[N][N];  // 번호별 같은 팀에 속했을 때 추가 능력치

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[N];  // 방문 파악
        start = new int[team];  // 스타트 팀 등 번호
        permutation(N, team, 0);
        // 두 팀의 능력치 차의 최소
        System.out.println(min);
    }

    public static void permutation(int N, int team, int depth) {
        // 팀당 인원이 depth 와 같을 경우
        if (team == depth) {
            int sSynergy = 0;  // 스타트 팀의 능력치 합
            int lSynergy = 0;  // 링크 팀의 능력치 합
            boolean[] check = new boolean[N];  // 스타트 팀의 등 번호 확인
            int[] link = new int[team];  // 링크 팀 등 번호
            for (int s : start) {
                check[s] = true;
            }

            int idx = 0;
            for (int i = 0; i < check.length; i++) {
                // 스타트 팀의 등번호가 아닌 경우
                // 링크 팀에 추가
                if (!check[i]) {
                    link[idx++] = i;
                }
            }

            for (int i = 0; i < start.length - 1; i++) {
                for (int j = i + 1; j < start.length; j++) {
                    //  i, j 번째와 j, i 번째 능력치 모두 추가
                    sSynergy += arr[start[i]][start[j]];
                    sSynergy += arr[start[j]][start[i]];
                    lSynergy += arr[link[i]][link[j]];
                    lSynergy += arr[link[j]][link[i]];
                }
            }
            // 이전 두 팀의 능력치 최소보다 현재 두 팀의 능력치 최소인지 파악
            min = Math.min(min, Math.abs(sSynergy - lSynergy));
            return;
        }

        for (int i = 0; i < N; i++) {
            //  방문하지 않았을 경우
            if (!isVisited[i]) {
                // isVisited 를 true 로 만들면서 중복 수열 제거
                for (int j = 0; j <= i; j++) {
                    isVisited[j] = true;
                }
                // 스타트 팀의 등 번호 추가
                start[depth] = i;
                permutation(N, team, depth + 1);
                for (int j = 0; j <= i; j++) {
                    isVisited[j] = false;
                }
            }
            // 첫 번째 등번호를 가진 사람의 기준으로 파악
            // 굳이 모든 loop 를 돌 필요는 없다.
            // 어차피 스타트 팀에 속하지 않은 등 번호는 자동으로 링크 팀 등 번호이므로
            // loop 를 다 돌고나면 중복이 발생
            if (!isVisited[0] && depth == 0) {
                break;
            }
        }
    }
}