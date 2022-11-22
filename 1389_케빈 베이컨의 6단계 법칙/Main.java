import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 유저의 수
        int M = Integer.parseInt(st.nextToken());  // 친구 관계의 수

        // 최단 거리 인접 행렬 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                // 자기 자신으로 가는 경로를 제외한 모든 경로 INF
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        // A 와 B 서로 친구이므로 양방향으로 업데이트
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = dist[B][A] = 1;
        }

        floydWarshall(N);

        int baconCnt = INF;  // 가장 작은 케빈 베이컨의 수
        int idx = -1;  // 사람의 번호
        for (int i = 1; i < N + 1; i++) {
            int count = 0;  // 케빈 베이컨의 수
            for (int j = 1; j < N + 1; j++) {
                count += dist[i][j];
            }

            // 현재 가장 작은 케빈 베이컨 수가
            // 방금 계산한 케빈 케이컨 수보다 클 경우 업데이트
            if (baconCnt > count) {
                baconCnt = count;
                idx = i;
            }
        }

        // 결과
        System.out.println(idx);
    }

    public static void floydWarshall(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 거리와 i -> k -> j 거리 중 최소 거리로 업데이트
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}