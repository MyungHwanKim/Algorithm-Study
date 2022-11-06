import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // int 의 범위는 2,147,483,647 이지만
        // n의 최대인 35일 때 3,116,285,494,907,301,262로
        // int 의 범위를 넘어서므로 long 최대 값인 9,223,372,036,854,775,807 이내이므로 long 사용
        long[] dp = new long[36];
        dp[0] = 1;  // 기본적으로 시작 값을 1로 주어짐
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0) 점화식을 따르므로 아래와 같다.
                // dp[n] = dp[0] * dp[n - 1] + dp[1] * dp[n - 2] + ... + dp[n-1] * dp[0]
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        // 결과
        System.out.println(dp[n]);
    }
}