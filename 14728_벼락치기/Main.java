import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 시험의 단원 개수
        int T = Integer.parseInt(st.nextToken());  // 시험까지 공부할 수 있는 총 시간

        int[] K = new int[N];  // 각 단원 별 예상 공부 시간을 담을 배열
        int[] S = new int[N];  // 단원 문제의 배점을 담을 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        System.out.println(knapsack(N, T, K, S));
    }

    public static int knapsack(int N, int T, int[] K, int[] S) {
        // [단원 개수][공부 시간]을 담을 dp
        int[][] dp = new int[N + 1][T + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= T; j++) {
                // 현재 공부 시간보다 각 단원 별 예상 공부 시간이 더 클 경우
                // 이전의 기록된 단원 문제의 배점을 가져온다.
                if (j < K[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // 준석이가 점수를 더 얻을 수 있는 경우
                    // 이전의 기록된 단원 문제의 비점과 현재 늘릴 수 있는 점수와 비교하여 더 큰 값으로 업데이트
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - K[i]] + S[i]);
                }
            }
        }

        // 준석이가 얻을 수 있는 최대 점수
        return dp[N][T];
    }
}