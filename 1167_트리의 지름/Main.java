import java.util.*;
import java.io.*;

class Node {
    int to;
    int dist;

    public Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

public class Main {
    static List<List<Node>> graph;
    static boolean[] visit;
    static int maxDist = 0;  // 두 점 사이의 거리 중 가장 긴 것
    static int maxNode = 0;  // 가장 먼 노드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());  // 정점의 개수 및 간선의 정보

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());  // 출발 정점
            int end;  // 도착 정점
            int dist;  // 정점까지의 거리
            // 도착 정점이 -1 일 경우 간선의 정보가 끝이므로 종료
            while ((end = Integer.parseInt(st.nextToken())) != -1) {
                dist = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Node(end, dist));
            }
        }

        visit = new boolean[V + 1];  // 방문 정보
        // 임의의 노드로 가장 먼 노드 체크
        // maxNode 에 업데이트
        dfs(1, 0);

        visit = new boolean[V + 1];  // 방문 정보 재초기화
        // 앞서 찾은 maxNode 노드로 가장 먼 노드까지 거리 업데이트
        dfs(maxNode, 0);

        // 결과
        System.out.println(maxDist);
    }

    public static void dfs(int node, int dist) {
        // 현재 거리가 최대 거리보다 클 경우
        // 최대 거리와 가장 먼 노드 업데이트
        if (maxDist < dist) {
            maxDist = dist;
            maxNode = node;
        }
        visit[node] = true;  // 방문 처리

        for (int i = 0; i < graph.get(node).size(); i++) {
            Node adjNode = graph.get(node).get(i);
            // 아직 방문하지 않은 노드일 경우
            // 재귀 호출
            if (!visit[adjNode.to]) {
                dfs(adjNode.to, dist + adjNode.dist);
            }
        }
    }
}