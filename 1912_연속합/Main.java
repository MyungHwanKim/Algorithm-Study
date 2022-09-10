import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정수의 개수
        int n = Integer.parseInt(br.readLine());
        // n개의 정수로 이루어진 수열
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연속된 정수 중 가장 큰 정수 합을 담을 배열
        int[] dp = new int[n];
        dp[0] = arr[0];
        // 가장 큰 합
        int maxSum = dp[0];
        for (int i = 1; i < n; i++) {
            // 연속 합 + 현재 정수 값, 현재 정수 값 중 큰 값
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            // 현재 가장 큰 합, dp[i] 중 큰 수
            maxSum = Math.max(maxSum, dp[i]);
        }
        // 결과
        System.out.println(maxSum);
    }
}