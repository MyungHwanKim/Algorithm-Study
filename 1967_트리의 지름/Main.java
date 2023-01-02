import java.util.*;
import java.io.*;

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static List<List<Node>> graph;
    static boolean[] visit;
    static int diameter = 0;  // 트리의 지름
    static int maxNode = 0;  // 가장 먼 노드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 노도의 개수

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // n - 1 개 간선 정보
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());  // 부모 노드
            int to = Integer.parseInt(st.nextToken());  // 자식 노드
            int weight = Integer.parseInt(st.nextToken());  // 간선의 가중치
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        visit = new boolean[n + 1];  // 방문 확인
        dfs(1, 0);  // 가장 먼 노드 체크

        visit = new boolean[n + 1];  // 방문 확인
        dfs(maxNode, 0);  // 가장 먼 노드에서 가장 긴 지름 확인

        // 결과
        System.out.println(diameter);
    }

    public static void dfs(int node, int length) {
        // 이전 최대 지름보다 현재 length 가 더 길 경우
        // 최대 지름과 가장 먼 노드 업데이트
        if (diameter < length) {
            diameter = length;
            maxNode = node;
        }
        visit[node] = true;

        for (int i = 0; i < graph.get(node).size(); i++) {
            Node adjNode = graph.get(node).get(i);

            // 이동한 노드가 아직 방문하지 않는 노드일 경우
            if (!visit[adjNode.to]) {
                dfs(adjNode.to, length + adjNode.weight);
            }
        }
    }
}