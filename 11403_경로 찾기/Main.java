import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 정점의 개수

        List<int[]> data = new ArrayList<>();  // 인접 행렬의 정보
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 간선이 존재한 경우에만 정보에 추가
                if (num == 1) {
                    data.add(new int[]{i + 1, j + 1});
                }
            }
        }

        // 최단 거리 인접 행렬 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // 자신으로 갈 수 있는 경우를 제외한 모든 경로에 대해 INF 업데이트
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        // 그래프로 구성
        for (int[] item : data) {
            dist[item[0]][item[1]] = 1;
        }

        floydWarshall(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // 경로가 INF 이거나 0 이라면 갈 수 있는 방법이 없기에 0
                // 그 외 경로가 1 이상이라면 무조건 갈 수 있는 경로가 있으므로 1
                if (dist[i][j] == INF || dist[i][j] == 0) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(1).append(" ");
                }
            }
            sb.append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void floydWarshall(int v) {
        // 노드 각각을 거쳐가는 경우에 대한 반복
        for (int k = 1; k < v + 1; k++) {
            // 노드 i -> j 로 이동하는 경우에 대한 거리
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 거리와 i -> k -> j 거리 중 저 작은 값으로 업데이트
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        // 자신으로 출발하여 자기 자신으로 돌아올 수 있는 경우
                        if (dist[i][j] == 0) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        } else {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
    }
}