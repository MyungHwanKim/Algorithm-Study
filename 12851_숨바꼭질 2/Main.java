import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 2};
    static int[] dist = new int[100001];
    static int count = 0;  // 가장 빠른 시간으로 동생을 찾는 방법의 수
    static int minTime = Integer.MAX_VALUE;  // 동생을 찾는 가장 빠른 시간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 수빈이가 있는 위치
        int K = Integer.parseInt(st.nextToken());  // 동생이 있는 위치

        // 수빈이가 동생보다 앞에 있을 경우
        // 뒤로 이동 방법뿐이므로 N - K 이면서 경우의 수는 1가지이다.
        if (N >= K) {
            System.out.println((N - K) + "\n1");
        } else {
            bfs(N, K);
            System.out.println((minTime + 1) + "\n" + count);
        }
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 소요 시간이 최소 시간보다 클 경우 종료
            if (minTime < dist[cur]) {
                return;
            }

            for (int x : dx) {
                int next;  // 수빈이의 다음 위치

                // X = 2 일 경우 순간 이동
                if (x == 2) {
                    next = cur * x;
                } else {
                    next = cur + x;
                }

                // 수빈이가 갈 수 없는 경우 continue
                if (next < 0 || next > 100000) {
                    continue;
                }

                // 동생이 있는 위치라면 최소 시간을 업데이트한 후
                // 최소 시간의 방법 수를 count + 1 해준다.
                if (next == end) {
                    minTime = dist[cur];
                    count++;
                }

                // 아직 수빈이가 방문하지 않은 위치이거나 다음 위치가 현재 위치 + 1 일 경우
                if (dist[next] == 0 || dist[next] == dist[cur] + 1) {
                    queue.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
    }
}