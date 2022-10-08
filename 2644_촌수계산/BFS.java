import java.io.*;
import java.util.*;

public class BFS {
    static List<ArrayList<Integer>> graph;  // 양방향 그래프
    static boolean[] isVisited;  // 방문 여부 확인
    static int[] result;  // start 번호 기준에 맞는 촌수 값을 담을 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 사람의 수
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());  // 출발 사람의 번호
        int end = Integer.parseInt(st.nextToken());  // 도착 번호의 번호

        int m = Integer.parseInt(br.readLine());  // 부모 자식 관계의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());  // 부모 번호
            int y = Integer.parseInt(st.nextToken());  // 자식 번호
            // 양방향으로 추가
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        isVisited = new boolean[n + 1];
        result = new int[n + 1];
        // bfs 방문 확인
        bfs(start);
        // 촌수가 0이라면 -1 반환
        System.out.println(result[end] == 0 ? -1 : result[end]);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int idx : graph.get(cur)) {
                if (!isVisited[idx]) {
                    queue.offer(idx);
                    result[idx] = result[cur] + 1;
                    isVisited[idx] = true;
                }
            }
        }
    }
}