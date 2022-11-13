import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 커피의 개수
        int K = Integer.parseInt(st.nextToken());  // 섭취해야하는 카페인의 양

        int[] caffeine = new int[N];  // 카페인을 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            caffeine[i] = Integer.parseInt(st.nextToken());
        }

        // 결과
        System.out.println(minCoffee(N, K, caffeine));
    }

    public static int minCoffee(int N, int K, int[] caffeine) {
        // 카페인별 섭취해야할 커피의 개수를 담을 배열
        // 인덱스는 카페인의 함유량
        int[] dp = new int[K + 1];
        // 최대 얻을 수 있는 커피의 개수는 100개이므로 101로 초기화
        Arrays.fill(dp, 101);
        dp[0] = 0;  // 카페인이 0일때는 커피의 개수가 0이므로 0으로 초기화

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= caffeine[i]; j--) {
                // 현재 카페인에 필요한 커피의 개수와
                // 현재 카페인에서 섭취하려는 커피의 카페인을 뺸 카페인의 커피의 개수 + 1 중
                // 더 작은 값으로 업데이트
                dp[j] = Math.min(dp[j], dp[j - caffeine[i]] + 1);
            }
        }

        // 정확히 K 만큼의 카페인을 섭취하귀 위해
        // dp[K] 값이 101이라면 K 만큼의 카페인을 마실 수 없으므로 -1
        // 그 외 커피의 최소 개수를 출력한다.
        return dp[K] == 101 ? -1 : dp[K];
    }
}