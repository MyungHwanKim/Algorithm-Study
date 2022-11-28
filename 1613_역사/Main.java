import java.io.*;
import java.util.*;

public class Main {
    static int[][] history;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 사건의 개수
        int k = Integer.parseInt(st.nextToken());  // 사건의 전후 관계의 개수

        history = new int[n + 1][n + 1];  //  사건 순서 정보를 담을 배열
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 두 사건의 전후 관계 정보에서 자신과의 관계는 없으므로
                // 제외 후 나머지에 대해 INF 업데이트
                if (i != j) {
                    history[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 사건 번호 시작
            int end = Integer.parseInt(st.nextToken());  // 사건 번호 끝
            history[start][end] = 1;
        }

        floydWarshall(n);

        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 알고 싶은 사건 번호 시작
            int end = Integer.parseInt(st.nextToken());  // 알고 싶은 사건 번호 끝

            // 두 사건의 정보를 유추할 수 없는 경우 0
            if (history[start][end] == INF && history[end][start] == INF) {
                sb.append("0");
            } else {
                // 앞에 있는 번호의 사건이 먼저 일어난 경우 -1
                if (history[start][end] != INF && history[start][end] > 0) {
                    sb.append("-1");
                    // 뒤에 있는 번호의 사건이 먼저 일어난 경우 1
                } else if (history[end][start] != INF && history[end][start] > 0) {
                    sb.append("1");
                }
            }
            sb.append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void floydWarshall(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 역사 관계와 i -> k -> j 역사 관계 중 더 최소인 값으로 업데이트
                    if (history[i][k] != INF && history[k][j] != INF) {
                        history[i][j] = Math.min(history[i][j], history[i][k] + history[k][j]);
                    }
                }
            }
        }
    }
}