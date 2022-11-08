import java.util.*;
import java.io.*;

class Library {
    int day;  // 소요되는 일 수
    int page;  // 페이지 수

    public Library(int day, int page) {
        this.day = day;
        this.page = page;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 남은 기간
        int M = Integer.parseInt(st.nextToken());  // 챕터의 수

        List<Library> libraries = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            libraries.add(new Library(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        // 결과
        System.out.println(knapsack(N, M, libraries));
    }

    public static int knapsack(int N, int M, List<Library> libraries) {
        int[][] dp = new int[M + 1][N + 1];  // [챕터 수][일 수]로 담을 dp

        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                // 현재 일 수보다 소요되는 일 수가 더 클 경우
                // 이전의 기록된 페이지 수를 가져온다.
                if (j < libraries.get(i).day) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    // 읽을 수 있는 페이지 수를 늘릴 수 있는 경우
                    // 이전의 기록된 페이지 수와 현재 늘릴 수 있는 페이지와 비교하여 더 큰 값으로 업데이트
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - libraries.get(i).day] + libraries.get(i).page);
                }
            }
        }
        // 읽을 수 있는 최대 페이지 수
        return dp[M][N];
    }
}