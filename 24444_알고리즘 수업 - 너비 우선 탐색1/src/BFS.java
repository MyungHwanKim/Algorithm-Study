import java.util.*;
import java.io.*;

public class BFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;  // 방문 여부
    static int[] results;  // 결과
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정점의 수
        int M = Integer.parseInt(st.nextToken());  // 간선의 수
        int R = Integer.parseInt(st.nextToken());  // 시작 정점

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        results = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 간선 정보, 양방향 간선
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접 정점은 오름차순
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(R);

        // 결과 출력
        for (int i = 1; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }


    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        results[start] = count++;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    results[next] = count++;
                    queue.offer(next);
                }
            }
        }
    }
}