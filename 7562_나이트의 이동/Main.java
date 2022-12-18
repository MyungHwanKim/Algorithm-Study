import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {2, 1, -2, -1, 2, 1, -2, -1};  // x축 이동
    static int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};  // y축 이동
    static int[][] board;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());  // 체스판의 한 변의 길이

            board = new int[I][I];  // 체스판
            visit = new boolean[I][I];  // 방문 확인
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());  // 현재 위치 x좌표
            int startY = Integer.parseInt(st.nextToken());  // 현재 위치 y좌표
            bfs(startX, startY);

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());  // 도착 위치 x좌표
            int endY = Integer.parseInt(st.nextToken());  // 도착 위치 y좌표

            sb.append(board[endX][endY]).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int a = cur[0] + dx[i];  // 이동한 x축 좌표
                int b = cur[1] + dy[i];  // 이동한 y축 좌표

                // 체스판을 벗어날 경우 continue
                if (a < 0 || b < 0 || a >= board.length || b >= board[0].length) {
                    continue;
                }

                // 방문하지 않았을 경우 queue 에 추가
                // 방문 확인 후
                // 다음 위치 = 현재 위치 + 1
                if (!visit[a][b]) {
                    queue.offer(new int[]{a, b});
                    visit[a][b] = true;
                    board[a][b] = board[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}