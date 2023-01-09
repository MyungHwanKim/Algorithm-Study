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
    static List<List<Node>> graph;
    static int V, E, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());  // 정점의 개수
        E = Integer.parseInt(st.nextToken());  // 간선의 개수
        P = Integer.parseInt(st.nextToken());  // 건우가 위치한 정점

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // 간선의 정점, 정점: a, b, 거리: c
            // 지도는 양방향 그래프 형태이므로 양쪽으로 연결
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        // 민준이가 마산으로 바로 가는 거리
        int dist1 = dijkstra(1, V);

        int dist2 = 0;
        // 민준이가 건우까지 거리
        dist2 += dijkstra(1, P);
        // 건우에서 마산까지 거리
        dist2 += dijkstra(P, V);

        // 마산으로 바로 가는 거리가
        // 건우를 데리고 마산을 가는 경우보다 같거나 클 경우
        // 건우를 데리러 간다.
        if (dist1 >= dist2) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visit = new boolean[V + 1];

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 현재 정점을 방문했었다면 continue
            if (visit[curNode.to]) {
                continue;
            }
            visit[curNode.to] = true;

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 이동한 정점이 아직 방문하지 않았고 이동한 정점까지의 누적 거리가
                // 현재 정점까지의 거리 + 현재 정점에서 이동한 정점까지의 거리에서
                // 이동한 정점까지의 누적 거리가 더 클 경우 작은 값으로 업데이트
                if (!visit[adjNode.to] && dist[adjNode.to] > dist[curNode.to] + adjNode.weight) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        // 결과
        return dist[end];
    }
}