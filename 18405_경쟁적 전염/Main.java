import java.util.*;
import java.io.*;

// 바이러스 정보
class Virus implements Comparable<Virus> {
    int x;
    int y;
    int virus;
    int time;

    public Virus(int x, int y, int virus, int time) {
        this.x = x;
        this.y = y;
        this.virus = virus;
        this.time = time;
    }

    // 번호가 낮은 바이러스부터 탐색해야하므로 정렬
    @Override
    public int compareTo(Virus o) {
        return this.virus - o.virus;
    }
}

public class Main {
    static int[] dx = {1, 0, -1, 0};  // x축 이동
    static int[] dy = {0, 1, 0, -1};  // y축 이동
    static int[][] map;  // 시험관
    static int N, K;
    static PriorityQueue<Virus> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 시험관의 크기
        K = Integer.parseInt(st.nextToken());  // 최대 바이러스 번호

        map = new int[N][N];
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스가 아닌 경우 continue
                if (map[i][j] == 0) {
                    continue;
                }
                pq.offer(new Virus(i, j, map[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());  // 시간
        int X = Integer.parseInt(st.nextToken());  // x좌표
        int Y = Integer.parseInt(st.nextToken());  // y좌표
        // 결과
        System.out.println(bfs(S, X, Y));
    }

    public static int bfs(int time, int i, int j) {
        Queue<Virus> queue = new LinkedList<>();

        // 바이러스 정보를 담은 우선순위 큐에 정보를
        // queue 에 옮겨준다.
        while (!pq.isEmpty()) {
            Virus virus = pq.poll();
            queue.offer(virus);
        }

        while (!queue.isEmpty()) {
            Virus cur = queue.poll();

            // 현재 위치의 정보의 시간이
            // 알고 싶은 시간 초와 일치할 경우
            // break
            if (cur.time == time) {
                break;
            }

            for (int k = 0; k < dx.length; k++) {
                int x = cur.x + dx[k];  // 이동한 x 좌표
                int y = cur.y + dy[k];  // 이동한 y 좌표

                // 이동한 정보가 시험관 크기를 벗어난 경우 continue
                if (x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
                    continue;
                }

                // 이동한 위치가 바이러스가 없는 경우
                if (map[x][y] == 0) {
                    queue.offer(new Virus(x, y, cur.virus, cur.time + 1));
                    map[x][y] = map[cur.x][cur.y];
                }
            }
        }

        // 궁금한 위치의 정보 반환
        return map[i - 1][j - 1];
    }
}