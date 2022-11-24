import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 회원의 수

        // 최단 거리 인접 행렬 초기화
        dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 자기 자신은 친구할 수 없으므로 제외한 모든 경로 INF 업데이트
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());  // 친구 1
            int y = Integer.parseInt(st.nextToken());  // 친구 2
            // 친구 정보가 둘 다 -1일 경우 회원 정보가 끝이다.
            if (x == -1 && y == -1) {
                break;
            }
            // 서로 친구이므로 양방향으로 업데이트
            dist[x][y] = dist[y][x] = 1;
        }

        floydWarshall(n);

        int minScore = Integer.MAX_VALUE;  // 회장 후보의 점수
        for (int i = 1; i < n + 1; i++) {
            int score = 0;
            for (int j = 1; j < n + 1; j++) {
                score = Math.max(score, dist[i][j]);
            }
            minScore = Math.min(minScore, score);
        }

        int count = 0;  // 회장 후보의 수
        List<Integer> list = new ArrayList<>();  // 회장 후보를 담을 List
        for (int i = 1; i < n + 1; i++) {
            int score = 0;
            for (int j = 1; j < n + 1; j++) {
                score = Math.max(score, dist[i][j]);
            }
            if (minScore == score) {
                count++;
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        sb.append(minScore).append(" ").append(count).append("\n");
        for (int item : list) {
            sb.append(item).append(" ");
        }

        // 결과
        System.out.println(sb);
    }

    public static void floydWarshall(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 친구 사이와 i -> k -> j 친구 사이 거리 중 최소 사이 거리로 업데이트
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}