import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 파티장의 크기
        int M = Integer.parseInt(st.nextToken());  // 서비스를 요청한 손님의 수

        dist = new int[N + 1][N + 1];  // 시간 정보를 담을 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 직접적으로 연결된 도로를 통해 이동하는 시간
                dist[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall(N);

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());  // 손님이 위치한 파티장 번호
            int B = Integer.parseInt(st.nextToken());  // 다음 파티가 열러는 파티장 번호
            int C = Integer.parseInt(st.nextToken());  // 지금부터 다음 파티가 열리는데 걸리는 시간

            // 시간내에 다른 파티장에 도착할 수 있는 경우
            if (dist[A][B] <= C) {
                sb.append("Enjoy other party").append("\n");
            } else {
                // 시간내에 도착할 수 없을 경우
                sb.append("Stay here").append("\n");
            }
        }

        // 결과
        System.out.println(sb);
    }

    public static void floydWarshall(int v) {
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i -> j 시간와 i -> j -> k 시간 중 최소 시간으로 업데이트
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}