import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;  // 결과
    static boolean[] visited;  // 빙믄 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());  // 컴퓨터 수
        int connect = Integer.parseInt(br.readLine());  // 연결 정보
        visited = new boolean[computer + 1];

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < computer + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connect; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 양방향 연결
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        // dfs 결과
        System.out.println(dfs(graph, computer, 1));
        // bfs 결과
        System.out.println(bfs(graph, computer, 1));

    }

    // dfs로 풀 경우
    public static int dfs(List<ArrayList<Integer>> graph, int computer, int start) {
        // start 부분 방문 true
        visited[start] = true;

        for (int idx : graph.get(start)) {
            // 방문하지 않았을 경우
            if (!visited[idx]) {
                dfs(graph, computer, idx);
                cnt++;
            }
        }
        return cnt;
    }

    // bfs로 풀 경우
    public static int bfs(List<ArrayList<Integer>> graph, int computer, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[computer + 1];
        // 시작부분 queue에 넣고 방문 true
        queue.offer(start);
        visited[start] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int temp = graph.get(cur).get(i);

                if (!visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}