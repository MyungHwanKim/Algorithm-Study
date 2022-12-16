import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-2, -2, 0, 0, 2, 2};  // x축 이동
    static int[] dy = {-1, 1, -2, 2, -1, 1};  // y축 이동
    static int[][] board;  // 체스판
    static boolean[][] visit;  // 방문 여부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 체스판의 크기
        board = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] start = new int[2];  // 시작 좌표
        int[] end = new int[2];  // 도착 좌표
        for (int i = 0; i < 2; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 2; i++) {
            end[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[N][N];

        // 결과
        System.out.println(bfs(start, end));
    }

    public static int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = true;  // 현재 위치 방문 체크

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int x = cur[0] + dx[i];  // 다음 이동 x좌표
                int y = cur[1] + dy[i];  // 다음 이동 y좌표

                // 체스판을 벗어나는 경우 continue
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                    continue;
                }

                // 방문하지 않은 경우
                if (!visit[x][y]) {
                    // 이동할 체스판 좌표값은
                    // 현재 체스판 좌표의 이동 횟수 + 1
                    // 현재 위치 방문 체크
                    board[x][y] = board[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }

        // 촤소 이동 횟수가 0 이라면 -1 아니면 체스판의 값을 가져온다.
        return board[end[0]][end[1]] == 0 ? -1 : board[end[0]][end[1]];
    }
}