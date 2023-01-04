import java.util.*;
import java.io.*;


// 회의실 정보를 담은 class
class Meeting {
    int start;  // 시작 시간
    int end;  // 끝나는 시간
    int personnel;  // 회의 인원

    public Meeting(int start, int end, int personnel) {
        this.start = start;
        this.end = end;
        this.personnel = personnel;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];  // 회의 정보를 담을 배열
        int[] dp = new int[N];  /// 시간마다 최대 인원을 담을 배열
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 시작 시간
            int end = Integer.parseInt(st.nextToken());  // 끝나는 시간
            int personnel = Integer.parseInt(st.nextToken());  // 회의 인원
            meetings[i] = new Meeting(start, end, personnel);
        }

        dp[0] = meetings[0].personnel;
        // 임의의 회의 K(1 ≤ K ≤ N)는 회의 K − 1과 회의 K + 1과는
        // 회의 시간이 겹치고 다른 회의들과는 회의 시간이 겹치지 않으므로
        // 현재 회의 이전과 이후를 고려해야하므로 N을 2이상일 경우로 고려한다.
        if (N >= 2) {
            dp[1] = Math.max(dp[0], meetings[1].personnel);

            for (int i = 2; i < N; i++) {
                // 이전 회의 인원과
                // 이전의 이전 회의 인원과현재 회의 인원의 합 중
                // 더 큰 값으로 업데이트한다.
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + meetings[i].personnel);
            }
        }

        // 결과
        System.out.println(dp[N - 1]);
    }
}