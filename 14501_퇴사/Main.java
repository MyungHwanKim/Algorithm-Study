import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 퇴사 전 남은 근무일
        int[][] schedules = new int[N + 1][2];  // 상담 일정과 금액

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];  // 최대 이익을 담을 dp
        for (int i = N; i > 0; i--) {
            // 현재 일자에서 상담 일정을 더했을 때 퇴사일일 경우
            if (i + schedules[i][0] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], dp[i + schedules[i][0]] + schedules[i][1]);
            }
        }
        System.out.println(dp[1]);
    }
}