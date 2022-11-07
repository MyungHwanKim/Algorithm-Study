import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 세준이를 생각해준 사람

        int[] stamina = new int[N];  // 잃은 체력을 담을 배열
        int[] joy = new int[N];  // 얻을 기쁨을 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stamina[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(backpack(N, stamina, joy));
    }

    public static int backpack(int N, int[] stamina, int[] joy) {
        // N명과 전체 체력이 100이므로 사이즈는 N + 1과 100
        // 101이 아닌 이유는 체력이 0이 되었을 때 죽어서 기쁨을 느낄 수 없으므로 99일 때 최대가 된다.
        int[][] dp = new int[N + 1][100];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 100; j++) {
                // 현재 체력이 잃은 체력보다 작을 경우
                // 이전의 기록된 기쁨을 가져온다.
                if (j < stamina[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // 기쁨을 얻을 수 있는 경우
                    // 이전에 기록된 기쁨과 현재 얻을 수 있는 기쁨과 비교하여 더 큰 값으로 덥데이트
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - stamina[i]] + joy[i]);
                }
            }
        }
        // 최대로 얻을 수 있는 기쁨
        return dp[N][99];
    }
}