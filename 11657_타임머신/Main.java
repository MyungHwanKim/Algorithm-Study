import java.util.*;

public class Main {

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    final static int INF = 1000000000;
    static Edge[] edge;
    static long[] dist;

    public static void solution(int N, int M, int[][] data, int start) {
        edge = new Edge[M];
        for (int i = 0; i < M; i++) {
            edge[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }

        dist = new long[N + 1];  // 최단 경로 배열 초기화
        for (int i = 1; i < N + 1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        if (bellmanFord(N, M)) {  // 음수 사이클이 나올 경우
            System.out.println(-1);
        } else {
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] == INF) {
                    // 음수 사이클은 아니지만, 갈 수 있는 방법이 없을 때
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    public static boolean bellmanFord(int N, int M) {
        boolean isMinusCycle = false;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge cur = edge[j];

                if (dist[cur.from] == INF) {
                    continue;
                }

                if (dist[cur.to] > dist[cur.from] + cur.weight) {
                    // 현재 위치에서 다른 노드로 이동하는 거리가 더 짧을 경우
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    // 음수 사이클 체크
                    if (i == N) {
                        isMinusCycle = true;
                    }
                }
            }
        }
        return isMinusCycle;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 도시의 개수
        int M = sc.nextInt();  // 버스 노선의 개수

        int[][] data = new int[M][3];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        solution(N, M, data, 1);
    }
}