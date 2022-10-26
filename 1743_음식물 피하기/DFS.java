import java.io.*;
import java.util.*;

public class DFS {
    static int[] dx = {0, 1, 0, -1};  // x축 이동
    static int[] dy = {1, 0, -1, 0};  // y축 이동
    static int[][] board;
    static boolean[][] check;
    static int count = 0;  // 현재 음식물 쓰레기 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 세로 길이
        int M = Integer.parseInt(st.nextToken());  // 가로 길이
        int K = Integer.parseInt(st.nextToken());  // 음식물 쓰레기의 개수

        board = new int[N + 1][M + 1];  // 통로
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 1;  // 좌표 (r, c)에 음식물 표시
        }

        check = new boolean[N + 1][M + 1];  // 방문 확인

        int max = 0;  // 제일 큰 음식물의 크기
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                // 아직 방문하지 않고 음식물이 있을 경우
                if (!check[i][j] && board[i][j] == 1) {
                    dfs(i, j);
                    // 방금 구한 음식물의 크기와 현재 가장 큰 음식물의 크기 비교
                    max = Math.max(max, count);
                    count = 0;  // 다시 음식물 쓰레기 개수를 0개로 초기화
                }
            }
        }
        // 결과
        System.out.println(max);
    }

    public static void dfs(int i, int j) {
        check[i][j] = true;
        count++;  // 음식물 쓰레기 추가

        for (int k = 0; k < dx.length; k++) {
            // 다음 이동한 좌표
            int x = i + dx[k];
            int y = j + dy[k];

            // 통로의 크기를 벗어나거나 이미 방문한 곳인 경우
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || check[x][y]) {
                continue;
            }

            // 음식물이 있는 경우
            if (board[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}