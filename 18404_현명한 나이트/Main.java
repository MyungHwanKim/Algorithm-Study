import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};  // x축 이동
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};  // y축 이동
    static int[][] map;  // 체스판
    static boolean[][] visit;  // 방문 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 체스판의 크기
        int M = Integer.parseInt(st.nextToken());  // 상대편 말의 위치의 개수

        map = new int[N][N];
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());  // 나이트의 위치 x 좌표
        int Y = Integer.parseInt(st.nextToken());  // 나이트의 위치 y 좌표
        visit = new boolean[N][N];
        bfs(X - 1, Y - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // 상대편 말의 위치까지 최소 이동 수
            sb.append(map[A - 1][B - 1]).append(" ");
        }

        // 결과
        System.out.println(sb);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();  // 체스판의 현재 위치

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];  // 이동한 x좌표
                int y = cur[1] + dy[k];  // 이동한 y좌표

                // 체스판을 벗어난 경우 continue
                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
                    continue;
                }

                // 만약 방문하지 않은 위치일 경우
                if (!visit[x][y]) {
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    visit[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}