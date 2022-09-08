import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 크기
        int N = Integer.parseInt(br.readLine());
        // 수열
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 크기를 담을 배열
        int[] dp = new int[N];
        // 결과
        int max = -1;
        for (int i = 0; i < N; i++) {
            // 기본적으로 1로 초기화
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 현재 위치에서 값이 0 ~ 현재 전까지 값들을 비교
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            // for문을 통해 나온 dp[i]와 max 비교
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}