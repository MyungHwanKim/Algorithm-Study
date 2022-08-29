import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, L, R;
    static int[][] board;
    static boolean[][] isVisited; // 방문 확인
    static int[] dx = {0, 1, 0, -1}; // x축 이동
    static int[] dy = {1, 0, -1, 0}; // y축 이동
    static ArrayList<Node> list; // 인구 이동이 필요한 좌표의 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); // 최소 인구 차이
        R = Integer.parseInt(st.nextToken()); // 최대 인구 차이
        board = new int[N][N]; // 땅의 크기에 따른 인구 수

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());
    }

    public static int move() { // 인구 이동
        int result = 0;

        while (true) {
            boolean isMove = false;
            isVisited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isVisited[i][j]) { // 이전의 방문 했을 경우
                        continue;
                    }
                    // 현재 나라에서 주변 나라를 확인하며 이동할 인구 수의 총합 
                    int sum = bfs(i, j);

                    if (list.size() > 1) {
                        // 인구 변경
                        int avg = sum / list.size();
                        for (Node node : list) {
                            board[node.x][node.y] = avg;
                        }
                        isMove = true;
                    }
                }
            }

            if (!isMove) { // 더 이상 이동이 없을 경우
                return result;
            }
            result++;
        }
    }

    public static int bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.offer(new Node(i, j));
        list.add(new Node(i, j));
        isVisited[i][j] = true;

        int sum = board[i][j];
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int k = 0; k < dx.length; k++) {
                // 주변 나라로 이동
                int x = cur.x + dx[k];
                int y = cur.y + dy[k];

                // 범위에서 벗어났을 경우
                if (x < 0 || y < 0 || x >= N || y >= N || isVisited[x][y]) {
                    continue;
                }
                // 주변 나라와의 인구 수의 차이
                int diff = Math.abs(board[cur.x][cur.y] - board[x][y]);
                // 지정한 최소 및 최대 인구 수 사이에 있는 경우
                if (L <= diff && diff <= R) {
                    queue.offer(new Node(x, y));
                    list.add(new Node(x, y));
                    sum += board[x][y];
                    isVisited[x][y] = true;
                }
            }
        }
        return sum;
    }
}