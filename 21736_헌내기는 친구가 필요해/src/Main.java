import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M; // 캠퍼스 사이즈
    static char[][] board; // 캠퍼스 크기
    static boolean[][] visited; // 방문 여부
    static int count = 0; // 만날 수 있는 사람 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        // 도연이 위치
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            String info = br.readLine();
            for (int j = 0; j < M; j++) {
                // 도연이일 경우 기록
                if (info.charAt(j) == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
                board[i][j] = info.charAt(j);
            }
        }

        bfs(start[0], start[1]);

        // 아무도 만나지 못한 경우
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                // 캠퍼스 위치를 벗어나거나, 이미 방문했거나 벽인 경우 제외
                if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || board[x][y] == 'X') {
                    continue;
                }
                // 사람인 경우 위치 추가
                if (board[x][y] == 'P') {
                    count++;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}