import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1 ,0, 0, 0, 0}; // x축 이동
    static int[] dy = {0, 0, 1, -1, 0, 0}; // y축 이동
    static int[] dz = {0, 0, 0, 0, 1, -1}; // z축 이동
    static int M; // 가로 칸의 수
    static int N; // 세로 칸의 수
    static int H; // 높이 수
    static int[][][] box;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    // 토마토가 익었을 경우에만 queue 에 추가
                    if (box[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
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
                int z = cur[0] + dz[k]; // 다음 z 좌표 칸
                int y = cur[1] + dy[k]; // 다음 y 좌표 칸
                int x = cur[2] + dx[k]; // 다음 x 좌표 칸

                // 박스를 벗어난 경우 continue
                if (z < 0 || y < 0 || x < 0 || z >= box.length || y >= box[0].length || x >= box[0][0].length) {
                    continue;
                }

                // 다음 토마토가 익지 않은 경우
                if (box[z][y][x] == 0) {
                    queue.offer(new int[]{z, y, x});
                    box[z][y][x] = box[cur[0]][cur[1]][cur[2]] + 1;
                }
            }
        }

        // 아직 익지 않은 토마토가 있는 경우 -1 반환
        if (check()) {
            return -1;
        } else {
            int max = 0; // 모든 토마토가 익은 최소 일수
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        max = Math.max(max, box[i][j][k]);
                    }
                }
            }
            // 기존 토마토가 1이었기 때문에 max - 1 반환
            return max - 1;
        }
    }

    public static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 토마토 칸 중 0이 존재하면 종료
                    if (box[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}