import java.util.*;
import java.io.*;

public class DFS {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static char[][] map;  //  울타리 공간
    static boolean[][] visit;  // 방문 확인
    static int sheep = 0;  // 현재 공간의 존재하는 양의 수
    static int wolf = 0;  // 현재 공간의 존재하는 늑대 수
    static int sheepCnt = 0;  // 살아남게 되는 양의 수
    static int wolfCnt = 0;  // 살아남게 되는 늑대의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());  // 세로 길이
        int C = Integer.parseInt(st.nextToken());  // 가로 길이
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = chars[j];
            }
        }

        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 이미 방문했던 곳이거나 울타리일 경우 continue
                if (visit[i][j] || map[i][j] == '#') {
                    continue;
                }
                sheep = 0;
                wolf = 0;
                dfs(i, j);
                // 파악한 양의 수가 늑대 수보다 클 경우
                // 살아남은 양의 수를 추가할 겻이고
                // 늑대 수가 같거나 더 많은 경우 살아남은 늑대 수를 추가한다.
                if (sheep > wolf) {
                    sheepCnt += sheep;
                } else {
                    wolfCnt += wolf;
                }
            }
        }
        // 결과
        System.out.println(sheepCnt + " " + wolfCnt);
    }

    public static void dfs(int i, int j) {
        visit[i][j] = true;

        // 확인하려는 현재 위치가 양일 경우 sheep + 1
        // 늑대일 경우 wolf + 1
        if (map[i][j] == 'k') {
            sheep++;
        } else if (map[i][j] == 'v') {
            wolf++;
        }

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];  // 이동한 x 좌표
            int y = j + dy[k];  // 이동한 y 좌표

            // 울타리 공간을 벗어났거나 방문한 위치일 경우 continue
            if (x < 0 || y < 0 || x >= map.length || y >= map[0].length || visit[x][y]) {
                continue;
            }

            // 이동한 좌표가 울타리일 경우 continue
            if (map[x][y] == '#') {
                continue;
            }

            dfs(x, y);
        }
    }
}