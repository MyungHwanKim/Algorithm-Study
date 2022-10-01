import java.util.*;
import java.io.*;

public class BFS {
    static int[] dx = {0, 1, 0, -1};  // x축 이동
    static int[] dy = {1, 0, -1, 0};  // y축 이동
    static boolean[][] isCheck;
    static int[][] regions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 2차원 배열의 크기
        regions = new int[N][N];

        int maxHeight = 0;  // 최대 높이
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                regions[i][j] = num;
                maxHeight = Math.max(maxHeight, num);
            }
        }

        int max = 0;  // 최종 결과 값
        for (int height = 0; height <= maxHeight; height++) {
            int count = 0;  // height 별 안전 영역의 크기
            isCheck = new boolean[N][N];  // 지역 확인
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 확인하지 않은 지역이면서 안전 영역인 경우
                    if (!isCheck[i][j] && regions[i][j] > height) {
                        bfs(height, i, j);
                        count++;
                    }
                }
            }
            // 현재 안전 영역의 크기와 이전 최대 안전 영역의 크기 비교
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    public static void bfs(int height, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        isCheck[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x < 0 || y < 0 || x >= regions.length || y >= regions[0].length || isCheck[x][y]) {
                    continue;
                }

                // 다음 이동한 지역이 height 보다 높은 안전 영역인 경우
                if (regions[x][y] > height) {
                    queue.offer(new int[]{x, y});
                    isCheck[x][y] = true;
                }
            }
        }
    }
}