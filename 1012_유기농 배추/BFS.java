import java.io.*;
import java.util.*;

public class BFS {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static boolean[][] visit;  // 방문 확인
    static int[][] board;  // 배추밭
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());  // 가로길이
            int N = Integer.parseInt(st.nextToken());  // 세로길이
            int K = Integer.parseInt(st.nextToken());  // 배추가 심어져 있는 위치의 개수

            board = new int[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());  // 배추가 심어져 있는 x좌표
                int Y = Integer.parseInt(st.nextToken());  // 배추가 심어져 있는 y좌표
                // 1은 배추가 심어져 있는 곳
                // 0은 배추가 심어져 있지 않는 곳
                board[X][Y] = 1;
            }

            visit = new boolean[M][N];
            int count = 0;  // 배추흰지렁이 마리 수
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    // 아직 방문하지 않은 배추일 경우
                    if (!visit[j][k] && board[j][k] == 1) {
                        bfs(j, k);
                        count++;
                    }
                }
            }
            // 테스트 케이스별 결과 StringBuilder 에 추가
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
            int[] cur = queue.poll();  // 현재 배추흰지렁이의 위치

            for (int k = 0; k < dx.length; k++) {
                // 이동한 좌표
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                // 배추밭을 벗어나거나 이미 방문한 배추일 경우 continue
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visit[x][y]) {
                    continue;
                }

                // 이동한 곳이 배추가 있는 경우
                if (board[x][y] == 1) {
                    queue.offer(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }
    }
}