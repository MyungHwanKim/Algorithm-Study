import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n < 2 ? 2 : n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // i의 바로 앞 두 수의 합
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // n번째 피보나치 수
        System.out.println(dp[n]);
    }
}
