import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 건물의 개수
        M = Integer.parseInt(st.nextToken());  // 도로의 개수

        // 최단 거리 인접 행렬 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // 자신 건물에서 자신 건물로 가는 경우를 제외한 모든 경로에 대한 시간은 INF 로 업데이트
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 도로 정보
            int end = Integer.parseInt(st.nextToken());  // 도로 정보
            // 왕복 시간을 업데이트해야하기 때문에 2로 업데이트한다.
            dist[start][end] = dist[end][start] = 2;
        }

        floydWarshall(N);

        int building1 = Integer.MAX_VALUE;  // 작은 번호의 건물 번호
        int building2 = Integer.MAX_VALUE;  // 큰 번호의 건물 번호
        int timeSum = Integer.MAX_VALUE;  // 최소 왕복 시간의 합
        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                int sum = timeSum(i, j);

                // 구한 왕복 시간의 합이 현재 최소 왕복 시간의 합보다 작을 경우 업데이트
                if (sum < timeSum) {
                    building1 = i;
                    building2 = j;
                    timeSum = sum;
                }
            }
        }

        // 결과
        System.out.println(building1 + " " + building2 + " " + timeSum);
    }

    public static void floydWarshall(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 건물 사이의 왕복 시간과 i -> k -> j 건물 사이의 왕복 시간 중
                    // 최소 시간으로 업데이트
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static int timeSum(int x, int y) {
        int sum = 0;  // 왕복 시간의 합
        for (int i = 1; i < N + 1; i++) {
            sum += Math.min(dist[x][i], dist[y][i]);
        }

        // 결과
        return sum;
    }
}