import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int[][] map;  // 지도
    static int[][] result;  // 목표 지점까지의 거리를 담을 배열
    static boolean[][] visit;  // 방문 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 세로의 크기
        int m = Integer.parseInt(st.nextToken());  // 가로의 크기

        map = new int[n][m];
        result = new int[n][m];
        // 목표 지점까지 도달할 수 없는 경우를 대비해 모두 -1로 업데이트
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }

        int x = 0;  // 목표 지점이 저장된 x좌표
        int y = 0;  // 목표 지점이 저장된 y좌표
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 현재 지점이 목표 지점인 경우
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        visit = new boolean[n][m];
        bfs(x, y);

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 갈 수 없는 땅일 경우 0으로 반환
                if (map[i][j] == 0) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;
        result[i][j] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];  // 이동한 x좌표
                int y = cur[1] + dy[k];  // 이동한 y좌표

                // 지도를 벗어나거나 이미 방문한 좌표일 경우 continue
                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || visit[x][y]) {
                    continue;
                }

                // 이동한 좌표가 갈 수 없는 땅일 경우 continue
                if (map[x][y] == 0) {
                    continue;
                }

                result[x][y] = result[cur[0]][cur[1]] + 1;
                visit[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}