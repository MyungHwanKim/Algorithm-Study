import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[][] weightVal = new int[N][2]; // {무게, 가치} 배열
        for (int i = 0; i < weightVal.length; i++) {
            st = new StringTokenizer(br.readLine());
            weightVal[i][0] = Integer.parseInt(st.nextToken());
            weightVal[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(backpack(N, K, weightVal));
    }

    // 배낭에 넣을 수 있는 최대 가치 합
    public static int backpack(int N, int K, int[][] weightVal) {
        int[][] dp = new int[N + 1][K + 1]; // dp배열

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K + 1; j++) {
                // (j - weightVal[i][0]) 음수인 경우
                if (j < weightVal[i][0]) {
                    dp[i + 1][j] = dp[i][j];
                } else { // (j - weightVal[i][0]) 음수가 아닌 경우
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - weightVal[i][0]] + weightVal[i][1]);
                }
            }
        }
        return dp[N][K];
    }
}