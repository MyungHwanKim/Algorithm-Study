import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 테스트 개수	
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            // 테스트할 수
            int N = Integer.parseInt(st.nextToken());
            long[] dp = new long[N + 1];
            // N이 4보다 작은 1,2,3에 대해서는 1로 반환
            if (N < 4) {
                sb.append(1).append("\n");
                continue;
            }
            // N이 4일 경우
            if (N == 4) {
                sb.append(2).append("\n");
                continue;
            }
            // N이 4보다 클 때 dp에 입력값
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = 2;

            for (int j = 5; j < N + 1; j++) {
                dp[j] = dp[j - 1] + dp[j - 5];
            }
            sb.append(dp[N]).append("\n");
        }
        //최종 결과
        System.out.println(sb.toString());
    }
}