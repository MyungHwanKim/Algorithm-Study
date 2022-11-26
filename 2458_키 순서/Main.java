import java.io.*;
import java.util.*;

public class Main {
    static int[][] orders;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 학생의 수
        int M = Integer.parseInt(st.nextToken());  // 키를 비교한 횟수

        orders = new int[N + 1][N + 1];  // 키의 순서를 담을 배열
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // 자기 자신과는 키를 비교할 수 없으므로
                // 그 외에 경우만 INF 업데이트
                if (i != j) {
                    orders[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 학생의 번호
            int b = Integer.parseInt(st.nextToken());  // 학생의 번호
            orders[a][b] = 1;
        }

        orderCheck(N);

        int count = 0;  // 자신이 키가 몇 번째인지 알 수 있는 학생의 수
        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;  // 연결된 횟수
            for (int j = 1; j < N + 1; j++) {
                if (i != j && (orders[i][j] != INF || orders[j][i] != INF)) {
                    cnt++;
                }
            }

            // 자신을 제외하고 모두 연결되어 있을 경우만
            // 자신의 순서를 아는 것이므로 count 추가
            if (cnt == N - 1) {
                count++;
            }
        }

        // 결과
        System.out.println(count);
    }

    public static void orderCheck(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 키 순서보다 i -> k -> j 키 순서 중 더 작은 값으로 업데이트
                    if (orders[i][k] != INF && orders[k][j] != INF) {
                        orders[i][j] = Math.min(orders[i][j], orders[i][k] + orders[k][j]);
                    }
                }
            }
        }
    }
}