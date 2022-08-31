import java.io.*;

public class DFS {
    static int[] dx = {0, 1, 0, -1};  // x축 이동
    static int[] dy = {1, 0, -1, 0};  // y축 이동
    static int N;  // 그림의 크기
    static boolean[][] visited;  // 그리드 방문 확인
    static char[][] board;  // 그림
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String rgb = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = rgb.charAt(j);
            }
        }

        check();
        // 적록색약일 경우
        changeColorRG();
        check();
        System.out.println(sb);
    }

    public static void check() {
        // 구역의 개수
        int cnt = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문한 경우
                if (visited[i][j]) {
                    continue;
                }
                dfs(i, j);
                cnt++;
            }
        }
        sb.append(cnt).append(" ");
    }

    public static void changeColorRG() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 적록색약일 경우('R'을 'G'로 변경)
                if (board[i][j] == 'R') {
                    board[i][j] = 'G';
                }
            }
        }
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            // 다음 그림의 그리드 위치
            int x = i + dx[k];
            int y = j + dy[k];

            // 그림의 크기를 벗어나거나 확인한 그리드일 경우
            if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) {
                continue;
            }

            // 들어온 색과 다음 위치의 색이 같을 경우
            if (board[i][j] == board[x][y]) {
                dfs(x, y);
            }
        }
    }
}