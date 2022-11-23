import java.io.*;

public class Main {
    static int[][] dist;
    static int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 전제의 수

        dist = new int[27][27];  // a ~ z까지 있으므로 총 27 × 27로 초기화
        for (int i = 1; i < 27; i++) {
            for (int j = 1; j < 27; j++) {
                // 자신으로 오는 전제는 없다고 가정
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            // 전제에 대한 거리는 1로 전부 표기
            dist[chars[0] - 'a' + 1][chars[5] - 'a' + 1] = 1;
        }

        floydWarshall(26);

        int m = Integer.parseInt(br.readLine());  // 결론의 수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            char[] chars = br.readLine().toCharArray();
            // 결론이 INF 로 도달할 수 없다면 거짓이다.
            // INF 를 제외한 다른 값은 모두 참이다.
            if (dist[chars[0] - 'a' + 1][chars[5] - 'a' + 1] == INF) {
                sb.append("F").append("\n");
            } else {
                sb.append("T").append("\n");
            }

        }

        // 결과
        System.out.println(sb);
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