import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int M;  // 가로 칸의 수
    static int N;  // 세로 칸의 수
    static int[][] box;  // 토마토가 있는 상자
    static Queue<int[]> queue = new LinkedList<>();  // 익은 토마토를 넣은 queue
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 토마토가 익었을 경우에만 queue 에 추가
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 결과
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                int x = cur[0] + dx[k];  // 다음 x 좌표 칸
                int y = cur[1] + dy[k];  // 다음 y 좌표 칸

                // 박스를 벗어난 경우 continue
                if (x < 0 || y < 0 || x >= box.length || y >= box[0].length) {
                    continue;
                }

                // 다음 토마토가 익지 않은 경우
                if (box[x][y] == 0) {
                    queue.offer(new int[]{x, y});
                    box[x][y] = box[cur[0]][cur[1]] + 1;
                }
            }
        }

        // 아직 익지 않은 토마토가 있는 경우
        // -1 반환
        if (check()) {
            return -1;
        } else {
            int max = 0;  // 모든 토마토가 익는 최소 일수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    max = Math.max(max, box[i][j]);
                }
            }
            // 기존 토마토가 1이었기 때문에 max - 1 반환
            return max - 1;
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 토마토 칸 중 0 이 존재하면 종료
                if (box[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}