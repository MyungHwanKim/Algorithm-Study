import java.util.*;
import java.io.*;

public class DFS {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int[][] board;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());  // 높이
            int W = Integer.parseInt(st.nextToken());  // 너비
            board = new int[H][W];  // 그리드
            for (int j = 0; j < H; j++) {
                char[] chars = br.readLine().toCharArray();
                for (int k = 0; k < W; k++) {
                    board[j][k] = chars[k];
                }
            }

            visit = new boolean[H][W];  // 방문 확인
            int count = 0;  // 양의 무리 수
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    // 이미 방문한 위치이거나 현재 위치가 풀일 경우 continue
                    if (visit[j][k] || board[j][k] == '.') {
                        continue;
                    }

                    dfs(j, k);
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int i, int j) {
        visit[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];  // 이동한 x 좌표
            int y = j + dy[k];  // 이동한 y 좌표

            // 그리드를 벗어나거나 이미 방문한 위치일 경우 continue
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visit[x][y]) {
                continue;
            }

            // 이동한 위치가 양일 경우
            if (board[x][y] == '#') {
                dfs(x, y);
            }
        }
    }
}