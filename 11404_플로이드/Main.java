import java.io.*;
import java.util.*;

public class Main {
    static int[][] cost;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 도시의 개수
        int m = Integer.parseInt(br.readLine());  // 버스의 개수

        cost = new int[n + 1][n + 1];  // 버스의 정보를 담을 배열
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 사작 도시와 도착 도시가 같은 경우는 없기 때문에
                // 같을 경우를 제외하고 INF 로 업데이트
                if (i != j) {
                    cost[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 시작 도시 정보
            int b = Integer.parseInt(st.nextToken());  // 도착 도시 정보
            int c = Integer.parseInt(st.nextToken());  // 비용
            // 기존 최소 비용과 현재 정보의 비용 중 더 작은 값으로 업데이트
            cost[a][b] = Math.min(cost[a][b], c);
        }

        floydWarshall(n);

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 도시 i에서 j로 갈 수 없는 경우는
                // 0 으로 추가하고 그 외에는 갈 수 있으므로
                // 비용 정보를 추가한다.
                if (cost[i][j] == INF) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(cost[i][j]).append(" ");
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
                    // i -> j 가는 비용과 i -> k -> j 로 가는 비용 중 더 작은 값으로 업데이트
                    if (cost[i][k] != INF && cost[k][j] != INF) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }
    }
}