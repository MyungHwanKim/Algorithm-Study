import java.util.*;

public class Main {
    // 다음 노드값과 가중치
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int N, int[][] data, int K, int X) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], 1));
        }

        int[] dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) { // dist 값을 최댓값으로 초기화
            dist[i] = Integer.MAX_VALUE;
        }
        dist[X] = 0; // 시작값은 0으로 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(X, 0));  // 시작 노드

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    // dist값이 현재 노드 weight + 이동할 노드 weight 값보다 큰지 작은지
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int item: result) {
                System.out.println(item);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        int[][] data = new int[M][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        dijkstra(N, data, K, X);
    }
}