import java.util.*;
import java.io.*;

public class Main {
    static int N;  // 수열의 크기
    static int[] arr;  // 수열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(longDecreasingSeq());
    }

    public static int longDecreasingSeq() {
        int count = 0;  // 가장 긴 감소하는 부분 수열의 길이
        int[] dp = new int[N];  // 길이를 담을 배열
        Arrays.fill(dp, 1);  // 기본 자신의 개수 1개씩 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // 현재 값보다 이전의 값이 더 작을 경우
                // ( + 현재 개수도 이전의 개수 + 1보다 작을 경우)
                if (arr[i] < arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            // 현재 개수와 dp[i]의 개수 중 더 큰 값
            count = Math.max(count, dp[i]);
        }
        return count;
    }
}