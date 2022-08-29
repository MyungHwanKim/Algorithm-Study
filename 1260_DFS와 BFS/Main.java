import java.io.*;
import java.util.*;

public class Main {
    static List<ArrayList<Integer>> graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 번호

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // from 정점
            int to = Integer.parseInt(st.nextToken());  // to 정점
            // 양방향 연결
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 0; i < N + 1; i++) {
            // 정점 번호가 작은 것을 먼저 방문하기 위해 정렬
            Collections.sort(graph.get(i));
        }

        // dfs 방문 확인
        boolean[] visited = new boolean[N + 1];
        dfs(N, visited, V);
        // bfs 방문 확인
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(N, visited, V);
        System.out.println(sb.toString());
    }

    public static void dfs(int N, boolean[] visited, int id) {
        visited[id] = true;

        sb.append(id).append(" ");

        for (int idx : graph.get(id)) {
            if (!visited[idx]) {
                dfs(N, visited, idx); // 재귀 호출
            }
        }
    }

    public static void bfs(int N, boolean[] visited, int id) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            sb.append(curId).append(" ");

            for (int i = 0; i < graph.get(curId).size(); i++) {
                int temp = graph.get(curId).get(i);

                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
    }
}