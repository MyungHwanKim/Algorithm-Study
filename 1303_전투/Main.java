import java.io.*;
import java.util.*;

class Node { // 위치 노드
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[] dX = {0, 1, 0, -1}; // x축 이동
    static int[] dY = {1, 0, -1, 0}; // y축 이동
    static char[][] board; // 전쟁터
    static boolean[][] isVisited; // 병사 확인
    static int resultMy = 0; // 나의 병사 위력 합
    static int resultYou = 0; // 적의 병사 위력 합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전쟁터 가로
        M = Integer.parseInt(st.nextToken()); // 전쟁터 세로

        board = new char[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j);
            }
        }

        isVisited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                // 어느 쪽 병사인지 확인 되었을 경우
                if (isVisited[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }
        System.out.println(resultMy + " " + resultYou);
    }

    public static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        isVisited[i][j] = true; // 현재 병사가 어느쪽인지 확인

        int cnt = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int k = 0; k < dX.length; k++) {
                // 다음 위치의 병사 위치
                int x = cur.x + dX[k];
                int y = cur.y + dY[k];

                // 전쟁터 크기를 벗어나거나 다음 병사가 이미 확인된 병사일 경우
                if (x < 0 || y < 0 || x >= M || y >= N || isVisited[x][y]) {
                    continue;
                }

                // 처음에 입력된 병사 옷색과 이동한 병사의 옷색이 같을 경우
                if (board[i][j] == board[x][y]) {
                    cnt++;
                    queue.offer(new Node(x, y));
                    isVisited[x][y] = true;
                }
            }
        }

        // 입력된 병사의 옷색이 'W'일 경우(나의 팀)
        if (board[i][j] =='W') {
            resultMy += Math.pow(cnt, 2);
        } else {
            resultYou += Math.pow(cnt, 2);
        }
    }
}