import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정확하게 만들어야하는 킬로그램의 수
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = -1;
            dp[3] = 1;

            if (dp[i - 3] != -1 && dp[i - 3] != 0) {
                dp[i] = dp[3] + dp[i - 3];
            }

            // i가 5보다 클 경우
            if (i >= 5) {
                dp[5] = 1;
                if (dp[i - 5] != -1 && dp[i - 5] != 0) {
                    int temp = dp[5] + dp[i - 5];
                    // dp[i]가 그대로 -1이라면 temp 값을 아니면 위에 if문에서 나온 dp[i]와 방금 나온 temp값 중 더 작은 값으로 선택
                    dp[i] = dp[i] == -1 ? temp : Math.min(dp[i], temp);
                }
            }
        }
        // 정확히 N 킬로그램을 만들어야하므로 dp[N]값을 가져온다.
        System.out.println(dp[N]);
    }
}
