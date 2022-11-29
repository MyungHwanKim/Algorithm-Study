import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 건물의 수
        int m = Integer.parseInt(st.nextToken());  // 길의 수

        dist = new int[n + 1][n + 1];  // 일반통행과 양방통행의 정보를 담을 배열
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 자신의 건물에서 자신의 건물로 가는 경우를
                // 제외간 모든 경우를 INF 로 업데이트
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());  // 출발 건물 정보
            int v = Integer.parseInt(st.nextToken());  // 도착 건물 정보
            int b = Integer.parseInt(st.nextToken());  // 일반 OR 양방 정보

            // u에서 v로는 무조건 갈 수 있으므로 비용은 0
            dist[u][v] = 0;
            // v에서 u로 가는 경로는
            // b = 0일 경우에는 양방향을 위해 길을 추가할 비용 1
            // b = 1일 경우에는 이미 양방향이므로 비용 0으로 업데이트
            dist[v][u] = b == 0 ? 1 : 0;
        }

        floydWarshall(n);

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder

        int k = Integer.parseInt(br.readLine());  // 학생들의 질문 수
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());  // 궁금한 출발 건물 정보
            int e = Integer.parseInt(st.nextToken());  // 궁금한 도착 건물 정보

            // 출발건물에서 도착건물까지 가기 위해 필요한 도로의 개수
            sb.append(dist[s][e]).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void floydWarshall(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j로 갈 때 필요한 도로의 개수와 i -> k -> j로 갈 때
                    // 필요한 도로의 개수 중 최소 개수로 업데이트
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}