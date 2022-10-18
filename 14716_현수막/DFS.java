import java.io.*;
import java.util.*;

public class DFS {
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};  // x축 이동 (상, 하, 좌, 우, 대각선)
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};  // y축 이동 (상, 하, 좌, 우, 대각선)
    static boolean[][] isVisited;  // 현수막 방문 확인
    static int[][] arr;  // 현수막
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());  // 현수막 세로 길이
        int N = Integer.parseInt(st.nextToken());  // 현수막 가로 길이
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[M][N];
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // i, j 번째 현수막을 방문하지 않았고, 현수막의 정보가 1인 경우
                if (!isVisited[i][j] && arr[i][j] != 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        // 결과
        System.out.println(count);
    }

    public static void dfs(int i, int j) {
        isVisited[i][j] = true;  // i, j 번째 현수막 방문

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];  // 이동한 현수막의 x 좌표
            int y = j + dy[k];  // 이동한 현수막의 y 좌표

            // 이동한 현수막의 좌표가 현수막의 크기를 벗어나거나 이미 방문한 현수막일 경우
            if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || isVisited[x][y]) {
                continue;
            }

            // 현수막의 정보가 1인 경우
            if (arr[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}