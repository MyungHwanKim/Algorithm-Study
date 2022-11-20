import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 사람 수

        List<int[]> data = new ArrayList<>();  // 친구 정보를 담을 List
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");  // 친구 확인 정보
            for (int j = 0; j < N; j++) {
                // 서로 친구이면 data 에 사람 정보 추가
                if (s[j].equals("Y")) {
                    data.add(new int[]{i + 1, j + 1});
                }
            }
        }

        // 최단 친구 사이 인접 행렬 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        // 그래프로 구성
        for (int[] d : data) {
            dist[d[0]][d[1]] = 1;
        }

        floydWarshall(N);

        int maxCnt = 0;  // 가장 유명한 사람의 2-친구의 수
        for (int i = 1; i < N + 1; i++) {
            int count = 0;
            for (int j = 1; j < N + 1; j++) {
                // 바로 친구이거나 다른 친구를 한 번 건너 친구인 경우
                if (dist[i][j] >= 1 && dist[i][j] <= 2) {
                    count++;
                }
            }
            // 현재 친구의 수와 방금 구한 친구의 수 중 더 큰 값으로 업데이트
            maxCnt = Math.max(maxCnt, count);
        }

        // 결과
        System.out.println(maxCnt);
    }

    public static void floydWarshall(int v) {
        // 노드 각각을 거쳐가는 경우에 대한 반복
        for (int k = 1; k < v + 1; k++) {
            // 노드 i -> j 의 친구인 경우에 대한 사이 정보 업데이트
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 친구 사이와 i -> k -> j 친구 사이 중 최소 거리 사이 업데이트
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}