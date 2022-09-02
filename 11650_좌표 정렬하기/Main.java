import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        // x 좌표가 같을 경우
        if (this.x == o.x) {
            // y 좌표가 증가하는 순서
            return this.y - o.y;
        }
        // x 좌표가 순서하는 순서
        return this.x - o.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 평면 위 점의 개수
        PriorityQueue<Point> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Point(x, y));
        }

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            sb.append(cur.x).append(" ").append(cur.y).append("\n");

            // 우선순위 큐가 비어있을 경우
            if (pq.isEmpty()) {
                break;
            }
        }

        System.out.println(sb);
    }
}