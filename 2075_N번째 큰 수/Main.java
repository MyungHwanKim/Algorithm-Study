import java.util.*;
import java.io.*;

class Point implements Comparable<Point> {
    int x; // 행
    int y; // 열
    int value; // 값

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return o.value - this.value; // 내림차순
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N]; // N × N 배열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(); // 우선순위 큐
        for (int i = 0; i < N; i++) {
            // 마지막 행에 있는 값들 넣어주는 경우
            pq.offer(new Point(N - 1, i, arr[N - 1][i]));
        }


        int x, y;
        for (int i = 0; i < N - 1; i++) {
            Point max = pq.poll();
            x = max.x; // max의 행 값
            y = max.y; // max의 열 값

            if (x - 1 >= 0) {
                // 우선순위 큐에서 max을 값을 빼고 그 max 값 바로 위의 값을 넣는 조건
                pq.offer(new Point(x - 1, y, arr[x - 1][y]));
            }

        }
        System.out.println(pq.peek().value);
    }
}