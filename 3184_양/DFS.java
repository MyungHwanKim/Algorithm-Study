import java.util.*;
import java.io.*;

public class DFS {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int[][] board;  // 뒷마당 영역
    static boolean[][] visit;  // 방문 확인
    static int sheepCnt = 0;  // 아침까지 살아있는 양의 수
    static int wolfCnt = 0;  // 아침까지 살아있는 늑대의 수
    static int sheep = 0;
    static int wolf = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());  // x축 길이
        int C = Integer.parseInt(st.nextToken());  // y축 길이

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                board[i][j] = str[j];
            }
        }

        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 방문한 영역이거나 울타리일 경우 continue
                if (visit[i][j] || board[i][j] == '#') {
                    continue;
                }

                sheep = 0;  // 임시 양의 수
                wolf = 0;  // 임시 늑대의 수
                // 현재 영역이 양인 경우 sheep 에 추가
                // 늑대인 경우 wolf 에 추가
                if (board[i][j] == 'o') {
                    sheep++;
                } else if (board[i][j] == 'v') {
                    wolf++;
                }
                dfs(i, j);

                // 확인한 영역에서 양의 수가 늑대 수보다 많을 경우
                // sheepCnt 에 추가한다.
                // 반대로 늑대 수가 양의 수와 같거나 많을 경우
                // wolfCnt 에 추가한다.
                if (sheep > wolf) {
                    sheepCnt += sheep;
                } else {
                    wolfCnt += wolf;
                }
            }
        }

        // 결과
        System.out.printf("%d %d", sheepCnt, wolfCnt);
    }

    public static void dfs(int i, int j) {
        visit[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];  // 다음 이동할 x좌표
            int y = j + dy[k];  // 다음 이동할 y좌표

            // 뒷마당 영역을 벗어나거나 이미 확인한 영역이라면 continue
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visit[x][y]) {
                continue;
            }

            // 이동한 영역이 울타리 영역이 아닐 경우
            if (board[x][y] != '#') {
                // 양이 존재한다면 sheep + 1
                // 늑대가 존재한다면 wolf + 1
                if (board[x][y] == 'o') {
                    sheep++;
                } else if (board[x][y] == 'v') {
                    wolf++;
                }
                dfs(x, y);
            }
        }
    }
}