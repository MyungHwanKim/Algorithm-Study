import java.util.*;
import java.io.*;

public class DFS {
    static int[] dx = {0, 1, 0, -1};  // x축 이동
    static int[] dy = {1, 0, -1, 0};  // y출 이동
    static int N;  // 지도의 크기
    static int[][] board;  // 지도
    static List<Integer> result = new ArrayList<>();  // 집의 수를 담을 list
    static boolean[][] visited;   // 집 방문 확인
    static int cnt = 0; // 단지 내 집의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 집이 없거나(board[i][j] == 0) 이미 방문한 집일 경우
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                dfs(i, j);
                result.add(cnt);
                // list에 단지 내 집의 개수를 추가 후 0으로 초기화
                cnt = 0;
            }
        }
        // 총 단지 수
        sb.append(result.size()).append("\n");
        // 집의 수의 적은 순으로
        Collections.sort(result);
        for (int item: result) {
            sb.append(item).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        cnt++;

        for (int k = 0; k < dx.length; k++) {
            // 다음 지도의 위치
            int x = i + dx[k];
            int y = j + dy[k];

            // 지도를 벗어나거나 방문한 집일 경우
            if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y]) {
                continue;
            }

            // 집이 있을 경우
            if (board[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}