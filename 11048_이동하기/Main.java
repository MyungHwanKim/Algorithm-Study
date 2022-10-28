import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 미로의 x축 크기
        int M = Integer.parseInt(st.nextToken());  // 미로의 y축 크기
        int[][] board = new int[N + 1][M + 1];  // 미로
        int[][] dp = new int[N + 1][M + 1];  // 미로를 나가기 위해 이동한 위치마다 쌓인 사탕의 최대의 개수를 담을 dp

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                // 이동은 아래, 우측, 대각선 3가지로만 이동이 가능하므로
                // dp 값의 아래, 우측, 대각선 값 중 최댓값과 현재 board 위치의 사탕 개수를 더하면 현재 위치에서
                // 최대 사탕의 개수가 나온다.
                dp[i][j] = board[i][j] + Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }
        // 탈출할 때까지 가져온 최대 사탕의 개수
        System.out.println(dp[N][M]);
    }
}