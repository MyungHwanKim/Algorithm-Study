import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // n이 10000보다 작은 수이기 때문에 BigInteger 사용
        BigInteger[] dp = new BigInteger[n + 1];
        // n이 0도 가능하여 n = 0일 때와 아닐 때 구분
        if (n == 0) {
            dp[0] = BigInteger.valueOf(0);
        } else {
            dp[0] = BigInteger.valueOf(0);
            dp[1] = BigInteger.valueOf(1);
        }

        for (int i = 2; i <= n; i++) {
            // 현재 값은 바로 앞 두 수의 합
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }
        // n번째 피보나치 수 출력하기 위해 dp[n]
        System.out.println(dp[n]);
    }
}