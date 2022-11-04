import java.util.*;
import java.io.*;

public class BFS {
    static int[] dx = new int[]{1, 0, -1, 0};  // x축 이동
    static int[] dy = new int[]{0, 1, 0, -1};  // y축 이동
    static boolean[][] visit;  // 제외할 영역 및 방문 확인
    static List<Integer> list = new ArrayList<>();  // 넓이를 담을 list
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());  // x축 길이
        int N = Integer.parseInt(st.nextToken());  // y축 길이
        int K = Integer.parseInt(st.nextToken());  // 직사각형의 좌표 개수

        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    // 주어진 좌표 영역은 제외하기 위해 방문 처리
                    visit[j][k] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 제외된 자표가 아닌 경우
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }
        // 넓이 오름차순을 위한 정렬
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        // 영역의 개수 추가
        sb.append(list.size()).append("\n");
        for (int item : list) {
            sb.append(item).append(" ");
        }
        // 결과
        System.out.println(sb);
    }

    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;

        int count = 1;  // 방금 방문한 곳 처리
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];  // 이동한 x좌표
                int y = cur[1] + dy[k];  // 이동한 y좌표

                // 영역을 벗어나거나 이미 방문한 곳 or 제외 영역인 경우
                if (x < 0 || y < 0 || x >= visit.length || y >= visit[0].length || visit[x][y]) {
                    continue;
                }

                queue.offer(new int[]{x, y});
                visit[x][y] = true;
                count++;
            }
        }

        // 영역의 넓이 list 추가
        list.add(count);
    }
}