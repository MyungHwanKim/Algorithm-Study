import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // Test case 수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());  // 층
            int n = Integer.parseInt(br.readLine());  // 호

            int[][] dp = new int[k + 1][n + 1];  // 아파트
            for (int j = 0; j < k + 1; j++) {
                for (int l = 1; l < n + 1; l++) {
                    // 0층 l호에는 l명이 신다.
                    if (j == 0) {
                        dp[j][l] = l;
                    } else {
                        // 바로 아래층 같은 호 + 같은 층 이전 호 인원의 합
                        dp[j][l] += dp[j][l - 1] + dp[j - 1][l];
                    }
                }
            }
            sb.append(dp[k][n]).append("\n");
        }
        // 결과
        System.out.println(sb);
    }
}