import java.util.*;
import java.io.*;

public class DFS {
    static List<List<Integer>> graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 정점의 개수
        int M = Integer.parseInt(st.nextToken());  // 간선의 개수

        // 그래프 구성
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 방향이 없는 그래프이므로
            // 양방향으로 연결한다.
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visit = new boolean[N + 1];  // 방문 확인
        int count = 0;  // 연결 요소의 개수
        for (int i = 1; i < N + 1; i++) {
            // 아직 방문하지 않은 정점인 경우
            // bfs 탐색 후 count 추가
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }

        // 결과
        System.out.println(count);
    }

    public static void dfs(int i) {
        visit[i] = true;

        for (int j = 0; j < graph.get(i).size(); j++) {
            // cur 에 연결되어 있는 정점
            int adj = graph.get(i).get(j);

            // 이동한 정점이 아직 방문하지 않았을 경우
            // dfs 재귀 호출한다.
            if (!visit[adj]) {
                dfs(adj);
            }
        }
    }
}