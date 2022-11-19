import java.io.*;
import java.util.*;

public class DFS {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int[][] papers;  // 도화지
    static boolean[][] visit;  // 방문 확인

    static int count = 0;  // 그림의 개수
    static int area = 0; // 현재 그림의 넓이
    static int max = 0;  // 가장 넓은 그림의 넓이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 세로 크기
        int m = Integer.parseInt(st.nextToken());  // 가로 크기

        papers =new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 아직 방문하지 않았으면서 도화지의 정보가 1인 경우
                // 탐색을 통해 넓이를 파악한 후
                // 현재 최대 넓이와 방금 구한 넓이와 비교하여 더 큰 넓이로 업데이트
                // 그리고 그림의 개수를 하나 추가한다.
                area = 0;
                if (!visit[i][j] && papers[i][j] == 1) {
                    dfs(i, j);
                    max = Math.max(max, area);
                    count++;
                }
            }
        }
        // 결과
        System.out.println(count + "\n" + max);
    }

    public static void dfs(int i, int j) {
        area++;
        visit[i][j] = true;

        for (int k = 0; k < dx.length; k++) {
            int x = i + dx[k];  // 다음 이동한 x좌표
            int y = j + dy[k];  // 다음 이동한 y좌표

            // 도화지를 벗어나거나 이미 방문한 정보이면 continue
            if (x < 0 || y < 0 || x >= papers.length || y >= papers[0].length || visit[x][y]) {
                continue;
            }

            // 도화지 정보가 1인 경우
            // 방문 처리하고 다시 탐색
            if (papers[x][y] == 1) {
                visit[x][y] = true;
                dfs(x, y);
            }
        }
    }
}