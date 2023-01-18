import java.util.*;
import java.io.*;

public class BFS {
    static int[] dx = {1, 1, 0, -1, -1, -1,  0, 1};  // x축 이동
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};  // y축 이동
    static int[][] board;  // 지도
    static boolean[][] visit;  // 방문 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());  // 지도의 너비
            int h = Integer.parseInt(st.nextToken());  // 지도의 높이

            // 너비와 높이 모두 0 일 경우 테스트 케이스 종료
            if (w == 0 && h == 0) {
                break;
            }

            board = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visit = new boolean[h][w];

            int count = 0;  // 섬의 개수
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 방문한 위치이거나 바다일 경우 continue
                    if (visit[i][j] || board[i][j] == 0) {
                        continue;
                    }

                    bfs(i, j);
                    count++;
                }
            }

            // 섬의 개수 반영
            sb.append(count).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];  // 이동한 x좌표
                int y = cur[1] + dy[k];  // 이동한 y좌표

                // 지도를 벗어나거나 이미 방문한 섬일 경우 continue
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visit[x][y]) {
                    continue;
                }

                // 이동한 지도가 섬일 경우
                if (board[x][y] == 1) {
                    visit[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}