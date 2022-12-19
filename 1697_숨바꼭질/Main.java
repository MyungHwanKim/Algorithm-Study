import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 2};  // 이동 및 순간 이동
    static int[] dist = new int[100001];  // 거리를 담을 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 수빈이 위치
        int K = Integer.parseInt(st.nextToken());  // 동생의 위치
        // 수빈이 위치가 동생 위치보다 앞서 있다면
        // 뒤로 가는 방법뿐이므로 N - K
        if (N >= K) {
            System.out.println(N - K);
        } else {
            System.out.println(bfs(N, K));
        }
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int x : dx) {
                int next;  // 수빈이의 다음 위치
                // X = 2일 경우 순간 이동
                if (x == 2) {
                    next = cur * x;
                } else {
                    next = cur + x;
                }

                // 수빈이가 갈 수 없는 곳일 경우 continue
                if (next < 0 || next >= dist.length) {
                    continue;
                }

                // 아직 수빈이가 방문하지 않은 위치일 경우
                if (dist[next] == 0) {
                    queue.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }

            // 동생 위치를 방문했더라면 while 문 종료
            if (dist[end] != 0) {
                break;
            }
        }

        // 결과
        return dist[end];
    }
}