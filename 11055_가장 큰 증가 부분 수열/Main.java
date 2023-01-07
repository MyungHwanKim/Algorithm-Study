import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 수열의 크기
        int[] arr = new int[N];  // 수열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        System.out.println(increaseSeq(arr));
    }

    public static int increaseSeq(int[] arr) {
        int max = arr[0];

        int[] dp = new int[arr.length];  // 각 원소의 가장 큰 증가 부분 수열 합
        dp[0] = arr[0];  // 0번째는 이 값 이전 값이 없으므로 고정
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                // 해당 원소 값이 이전의 원소들 값보다 클 경우
                // 현재 증가 수열 합은 현재 값과 이전 합들 중 하나 + 현재 원소 값
                // 중 더 큰 값으로 업데이트
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            // 해당 증가 부분 수열 합과 이전 최대 수열 합 중 더 큰 값으로 업데이트
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}