import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int times;
    boolean isGram;

    public Point(int x, int y, int times, boolean isGram) {
        this.x = x;
        this.y = y;
        this.times = times;
        this.isGram = isGram;
    }
}

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, T;
    static int[][] board;
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 성의 가로 길이
        M = Integer.parseInt(st.nextToken());  // 성의 세로 길이
        T = Integer.parseInt(st.nextToken());  // 공주에게 도달해야할 제한 시간

        board = new int[N][M];  // 성의 내부
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0 : 그람이 없을 경우
        // 1 : 그람이 있을 경우
        visit = new boolean[N][M][2];

        // 공주에게 도달하는 시간
        int time = timeCount(0, 0);
        // -1 일 경우 공주에게 도달할 수 없으므로 Fail 그 외에는 시간을 반환
        System.out.println(time == -1 ? "Fail" : time);
    }

    public static int timeCount(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j, 0, false));
        visit[i][j][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            // 제한 시간을 초과할 경우 종료
            if (cur.times > T) {
                break;
            }

            // 공주가 있는 위치에 도달했을 경우 종료
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.times;
            }

            for (int k = 0; k < dx.length; k++) {
                int x = cur.x + dx[k];  // 이동한 x좌표
                int y = cur.y + dy[k];  // 이동한 y좌표

                // 성을 벗어난 경우 continue
                if (x < 0 || y < 0 || x >= N || y >= M) {
                    continue;
                }

                // 그람을 얻지 못했을 경우
                if (!cur.isGram) {
                    // 아직 방문하지 않았고 빈 공간일 경우
                    if (!visit[x][y][0] && board[x][y] == 0) {
                        queue.offer(new Point(x, y, cur.times + 1, false));
                        visit[x][y][0] = true;
                        // 아직 방문하지 않았고 그람이 있는 경우
                        // queue 에 넣을 때 isGram 을 true 로 바꾸어준다.
                    } else if (!visit[x][y][0] && board[x][y] == 2) {
                        queue.offer(new Point(x, y, cur.times + 1, true));
                        visit[x][y][0] = true;
                    }
                } else {
                    // 그람을 가지고 있는 경우이므로
                    // 마법의 벽이 있더라도 무시하고
                    // 방문하지 않은 모든 공간을 탐색한다.
                    if (!visit[x][y][1]) {
                        queue.offer(new Point(x, y, cur.times + 1, true));
                        visit[x][y][1] = true;
                    }
                }
            }
        }

        // 공주에게 도달할 수 없는 경우 -1 반환
        return -1;
    }
}