import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 최대 공부 시간
        int K = Integer.parseInt(st.nextToken());  // 과목 수

        int[] I = new int[K];  // 중요도를 담을 배열
        int[] T = new int[K];  // 필요한 공부시간을 담을 배열
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            I[i] = Integer.parseInt(st.nextToken());
            T[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        System.out.println(maxI(I, T, K, N));
    }

    public static int maxI(int[] I, int[] T, int K, int N) {
        // [과목 수][공부시간]
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                // 현재 공부시간보다 필요한 공부시간이 더 클 경우
                // 이전에 기록된 중요도를 가져온다.
                if (j < T[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // 중요도를 더 얻을 수 있는 경우
                    // 이전의 기록된 중요도와 현재 얻을 수 있는 중요도와 비교하여 업데이트
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - T[i]] + I[i]);
                }
            }
        }

        // 얻을 수 있는 최대 중요도
        return dp[K][N];
    }
}