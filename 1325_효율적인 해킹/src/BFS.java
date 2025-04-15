import java.util.*;
import java.io.*;

public class BFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] result;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 컴퓨터 번호
            int b = Integer.parseInt(st.nextToken());  // 컴퓨터 번호
            // b 를 해킹하면 a도 해킹 가능하므로 a 가 b를 신뢰하는 방향으로 처리
            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        // 가장 많이 해킹한 값
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i <= N; i++) {
            // 가장 많이 해킹한 값일 경우 출력
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[N + 1]; // 방문 여부
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                // 아직 방문하지 않은 컴퓨터 번호일 경우
                if (!visited[next]) {
                    visited[next] = true;
                    result[next]++;
                    queue.offer(next);
                }
            }
        }
    }
}