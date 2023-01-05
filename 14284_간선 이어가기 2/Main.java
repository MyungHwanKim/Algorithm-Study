import java.util.*;
import java.io.*;

// 노드 구성
class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int n, m;
    static List<List<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  // 정점의 개수
        m = Integer.parseInt(st.nextToken());  // 간선 수

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 정점
            int b = Integer.parseInt(st.nextToken());  // 정점
            int c = Integer.parseInt(st.nextToken());  // 가중치
            // 무방향 그래프이므로 양쪽으로 다 연결한다.
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        // 두 정점이 연결되는 시점
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 결과
        System.out.println(dijkstra(s, t));
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visit = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 현재 노드의 도착 지점이 이미 방문한 정점일 경우 continue
            if (visit[curNode.to]) {
                continue;
            }
            visit[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 아직 방문하지 않은 정점이거나
                // 다음 정점의 to 까지의 거리가 현재 정점의 to 거리 + 다음 정점까지의 weight 의 합보다 클 경우 업데이트
                if (!visit[adjNode.to] && dist[adjNode.to] > dist[curNode.to] + adjNode.weight) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        // 두 정점이 연결되는 시점의 간선의 가중치 합의 최솟값
        return dist[end];
    }
}