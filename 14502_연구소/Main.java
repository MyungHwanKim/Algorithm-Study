import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int N, M;  // 세로, 가로 크기
    static int[][] map;  // 지도
    static int[][] spreadMap;  // 바이러스 확산할 지도
    static int maxArea = 0;  // 최대 안전 영역
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 3개 세우기
        buildWall(0, 0);
        // 결과
        System.out.println(maxArea);
    }

    public static void buildWall(int idx, int count) {
        // 벽 3개 세운 경우
        if (count == 3) {
            // 바이러스 확산할 지도에 복사한다.
            copyMap();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 바이러스 확산할 지도에 영역 중 바이러스가 있는 경우
                    if (spreadMap[i][j] == 2) {
                        spreadVirus(i, j);
                    }
                }
            }
            // 이전의 최대 안전 영역과 현재 구한 안전 영역의 크기 중
            // 더 큰 값으로 업데이트
            maxArea = Math.max(maxArea, countSafeArea());
            return;
        }

        for (int i = idx; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            // 이동한 위치가 빈 칸인 경우
            // 벽을 세우고 탐색한 후 이후 벽을 다시 없애준다.
            if (map[x][y] == 0) {
                map[x][y] = 1;
                buildWall(i + 1, count + 1);
                map[x][y] = 0;
            }
        }
    }

    public static void copyMap() {
        spreadMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                spreadMap[i][j] = map[i][j];
            }
        }
    }

    public static void spreadVirus(int i, int j) {
        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];  // 이동한 x좌표
            int y = j + dy[k];  // 이동한 y좌표

            // 지도를 벗어난 경우
            if (x < 0 || y < 0 || x >= N || y >= M) {
                continue;
            }

            // 빈 칸인경우 2로 업데이트한 후 바이러스를 확산시킨다.
            if (spreadMap[x][y] == 0) {
                spreadMap[x][y] = 2;
                spreadVirus(x, y);
            }
        }
    }

    public static int countSafeArea() {
        int count = 0;  // 안전영역의 개수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 바이러스를 확산한 후 빈 칸인 곳이 있다면
                // 안전 영역이므로 count 업데이트
                if (spreadMap[i][j] == 0) {
                    count++;
                }
            }
        }

        // 결과
        return count;
    }
}