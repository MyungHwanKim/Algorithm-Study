import java.util.*;
import java.io.*;

public class BFS {
    static List<List<Integer>> graph;
    static int[] parents;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 노드의 개수

        // 그래프 구성
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to); graph.get(to).add(from);
        }
        parents = new int[N + 1];  // 각 노드의 부모 노드를 넣을 배열
        visit = new boolean[N + 1];  // 방문 확인
        bfs(1);  // 트리의 루트는 1이므로 1부터 탐색

        StringBuilder sb = new StringBuilder();  // 결과를 담을 StringBuilder
        for (int i = 2; i < N + 1; i++) {
            sb.append(parents[i]).append("\n");
        }

        // 결과
        System.out.println(sb);
    }

    public static void bfs(int parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(parent);
        visit[parent] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int child = graph.get(cur).get(i);

                // 아직 방문하지 않은 노드인 경우
                if (!visit[child]) {
                    visit[child] = true;
                    // adj 노드의 부모는 cur 이므로
                    // parents 의 adj 인덱스에 cur 업데이트
                    parents[child] = cur;
                    queue.offer(child);
                }
            }
        }
    }
}