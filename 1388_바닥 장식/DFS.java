import java.util.*;
import java.io.*;

public class DFS {
    static int[] dx = {1, -1};  // x축 이동
    static int[] dy = {1, -1};  // y축 이동
    static char[][] board;  // 방 바닥
    static boolean[][] isCheck;  // 확인한 바닥
    static int N, M;  // 세로, 가로
    static int count = 0;  // 나무 판자의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] rows = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = rows[j];
            }
        }

        isCheck = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 이미 확인한 바닥
                if (isCheck[i][j]) {
                    continue;
                }
                dfs(i, j);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int i, int j) {
        // 방문했으니 true로 체크
        isCheck[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            int x;
            int y;
            // 나무 판자가 '-'일 경우
            if (board[i][j] == '-') {
                x = i;
                y = j + dy[k];
            } else {
                x = i + dx[k];
                y = j;
            }

            // 방바닥을 벗어나거나 이미 확인한 바닥일 경우
            if (x < 0 || y < 0 || x >= N || y >= M || isCheck[x][y]) {
                continue;
            }
            // dfs에 들어온 좌표의 board의 값과 이동한 board의 값이 같을 경우
            if (board[i][j] == board[x][y]) {
                dfs(x, y);
            }
        }
    }
}